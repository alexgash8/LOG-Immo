import { Component, OnInit } from '@angular/core';
import { ApiService} from 'src/app/services/api.service';

@Component({
  selector: 'app-house',
  templateUrl: './house.component.html',
  styleUrls: ['./house.component.scss']
})

export class HouseComponent implements OnInit {
  selectedHouse: number = 0;
  selectedMeterType: any = '';
  selectedMeter: number = 0;
  showPopUp: boolean = false;


  newPayment: any = {
    id: '',
    text: '',
    ammount: '',
    datum: ''
  }

  newHouse: any = {
    countAppartments: '',
    city: '',
    street: '',
    house_Number: '',
    postal_code: '',
    insuranceNumber: ''
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

  constructor(private api: ApiService) { }

  async ngOnInit() {
    await this.getHouses();
  }

  openPopUp() {
    this.showPopUp = true;
  }
  closePopUp(){
    this.showPopUp = false;
  }

  onChangeHouse(deviceValue: any) {
    console.log(deviceValue, this.selectedHouse);
    this.getMeters();
    this.getPayments();
  }

  onChangeMeterType(deviceValue: any) {
    console.log(deviceValue, this.selectedMeterType);
    this.getMeters();
  }

  onChangeMeter(deviceValue: any) {
    console.log(deviceValue, this.selectedMeter);
    this.getHistories();
  }

  async getHouses(){
    this.houses = await this.api.house.get();
  }

  async getMeterTypes(){
    this
  }

  async getMeters() {
    this.meters = await this.api.meter.get(this.houses[this.selectedHouse].id);
  }

  async getHistories() {
    // this.histories = await this.api.meter.get(this.houses[this.selectedMeter].id);
  }

  async getPayments() {
    // this.histories = await this.api.payment.get(this.houses[this.selectedHouse].id);
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
      ammount: this.newPayment.ammount,
      datum: this.newPayment.datum,
    }
    await this.api.payment.add(newPayment);
    this.getPayments();
  }

  async createMeter() {
    const newMeter = {
      meter_type: this.newMeter.meter_type,
      number: this.newMeter.number,
      type: 'HMeter',
      house: {
        id: this.newHouse.id
      }
    }
    await this.api.meter.add(newMeter);
    this.getMeters();
  }

  async createHouse(){
    this.closePopUp();
    const newHouse = {
      countAppartments: this.newHouse.countAppartments,
      insuranceNumber: this.newHouse.insuranceNumber,
      address: {
        id: 0,
        type: 'HOUSE',
        street: this.newHouse.street,
        city: this.newHouse.city,
        houseNumber: this.newHouse.house_Number,
        appNumb: this.newHouse.appNumb,
        postalCode: this.newHouse.postal_code
      }
    };
    const answer = await this.api.house.add(newHouse);
    console.log('data:', this.newHouse);
    this.getHouses();
  }

  houses : any = [
    {
      id: 1,
      countAppartments: 11,
      insuranceNumber: 11,
      address: {
        id: 1,
        city: 'kiev',
        street: 11,
        house_Number: 11,
        appNumb: 11,
        postal_code: 11
      }
    },
    {
      id: 2,
      countAppartments: 22,
      insuranceNumber: 22,
      address: {
        id: 2,
        city: 'mariupol',
        street: 22,
        house_Number: 2,
        appNumb: 2,
        postal_code: 22
      }
    },
  ];

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
