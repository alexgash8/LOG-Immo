import { Component, OnInit } from '@angular/core';
import { HouseService } from 'src/app/services/house.service'
import { ApiService} from 'src/app/services/api.service';

@Component({
  selector: 'app-house',
  templateUrl: './house.component.html',
  styleUrls: ['./house.component.scss']
})

export class HouseComponent implements OnInit {

  selectedMeterType: any = '';
  selectedMeter: number = 0;
  showPopUp: boolean = false;

  newPayment: any = {
    id: '',
    text: '',
    amount: '',
    datum: ''
  }

  newHistory: any = {
    id: '',
    ammount: '',
    datum: ''
  }

  newMeter: any = {
    id: '',
    meter_type: '',
    number: ''
  }

  newMeterType: any = {
    meter_type: ''
  }

  constructor(public houseService : HouseService, private api: ApiService) { }

  async ngOnInit() {
    await this.houseService.getHouses();
  }

  openPopUp() {
    this.showPopUp = true;
  }
  closePopUp(){
    this.showPopUp = false;
  }

  onChangeHouse(deviceValue: any) {
    // console.log(deviceValue, this.selectedHouse);
    this.getMeters();
    this.getPayments();
  }



  async onCreateHouse() {
    await this.houseService.createHouse();
    this.closePopUp();
  }

  onChangeMeterType(deviceValue: any) {
    console.log(deviceValue, this.selectedMeterType);
  }

  onChangeMeter(deviceValue: any) {
    console.log(deviceValue, this.selectedMeter);
    this.getHistories();
  }

  async getMeters() {
    this.meters = await this.api.meter.get(this.houseService.houses[this.houseService.selectedHouse].id);
  }

  async getHistories() {
    // this.histories = await this.api.meter.get(this.houses[this.selectedMeter].id);
  }

  async getPayments() {
    this.payments = await this.api.payment.get(this.houseService.houses[this.houseService.selectedHouse].id);
  }

  async createHistory() {
    const newHistory = {
      ammount: this.newHistory.ammount,
      datum: this.newHistory.datum,
    }
    await this.api.history.add(newHistory);
    this.getHistories();
  }

  async createPayment() {
    const newPayment = {
      amount: this.newPayment.amount,
      text: this.newPayment.text,
      datum: this.newPayment.datum,
    }
    await this.api.payment.add(newPayment);
    this.getPayments();
  }

  async createMeter() {
    const newMeter = {
      meter_type: this.newMeter.meter_type,
      number: this.newMeter.number,
      house: {
        id: this.houseService.newHouse.id
      }
    }
    await this.api.meter.add(newMeter);
    this.getMeters();
  }



  histories : any = [
    {
      id : '1',
      ammount : '33',
      datum: '21-12-2211'
    },
    {
      id : '2',
      ammount : '22',
      datum: '11-11-1111'
    },{
      id : '3',
      ammount : '111',
      datum: '22-22-2222'
    },
  ]

  meterTypes : any = [
    {
      meter_type: 'HEAT'
    },
    {
      meter_type: 'WATER'
    },
    {
      meter_type: 'ELECTRICITY'
    }
  ];

  meters : any = [
    // {
    //   id: 1,
    //   meter_type: 'HEAT',
    //   number: "000000000000002"
    // },
    // {
    //   id: 2,
    //   meter_type: 'WATER',
    //   number: "0003235442400002"
    // },
    // {
    //   id: 3,
    //   meter_type: 'ELECTRICITY',
    //   number: "0003235442400002"
    // },
  ];

  payments: any = [
    {
      id: '1',
      text: 'fur wasser',
      ammount: '333',
      datum: '22-22-2222'
    },{
      id: '2',
      text: 'fur Strom',
      ammount: '444,3',
      datum: '22-22-2222'
    }
  ];
}
