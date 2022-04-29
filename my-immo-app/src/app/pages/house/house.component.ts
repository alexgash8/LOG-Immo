import { Component, OnInit } from '@angular/core';
import { ApiService} from 'src/app/services/api.service';

@Component({
  selector: 'app-house',
  templateUrl: './house.component.html',
  styleUrls: ['./house.component.scss']
})

export class HouseComponent implements OnInit {
  selectedHouse: number = 0;
  selectedMeter: number = 0;
  showPopUp: boolean = false;
  houses : any = [
    {
      id: 1,
      countAppartments: 11,
      insuranceNumber: 11,
      address: {
        id: 1,
        city: 'kiev',
        street: 11,
        houseNumber: 11,
        appNumb: 11,
        postalCode: 11
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
        houseNumber: 2,
        appNumb: 2,
        postalCode: 22
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
  meters : any = [
    {
      id: 1,
      type: 'HEAT',
      number: "000000000000002"
    },
    {
      id: 2,
      type: 'WATER',
      number: "0003235442400002"
    },
    {
      id: 3,
      type: 'ELECTRICITY',
      number: "0003235442400002"
    },
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
  ]

  newPayment: any = {
    id: '',
    text: '',
    ammount: '',
    datum: ''
  }

  newHouse: any = {
    appNumb: '',
    city: '',
    street: '',
    number: '',
    plz: '',
    insurance: ''
  }

  newHistory: any = {
    id: '',
    ammount: '',
    datum: ''
  }

  newMeter: any = {
    id: '',
    type: '',
    number: ''
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

  onChangeMeter(deviceValue: any) {
    console.log(deviceValue, this.selectedMeter);
    this.getHistories();
  }

  async getHouses(){
    this.houses = await this.api.house.get();
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
      type: this.newMeter.type,
      number: this.newMeter.number,
    }
    await this.api.meter.add(newMeter);
    this.getMeters();
  }

  async createHouse(){
    this.closePopUp();
    const newHouse = {
      countAppartments: this.newHouse.appNumb,
      insuranceNumber: this.newHouse.appNumb,
      address: {
        id: 0,
        street: this.newHouse.appNumb,
        houseNumber: this.newHouse.appNumb,
        appNumb: this.newHouse.appNumb,
        postalCode: this.newHouse.appNumb
      }
    };
    const answer = await this.api.house.add(newHouse);
    console.log('data:', this.newHouse);
    this.getHouses();
  }


}
