import { Component, OnInit } from '@angular/core';
import { ApiService} from 'src/app/services/api.service';

@Component({
  selector: 'app-appartment',
  templateUrl: './appartment.component.html',
  styleUrls: ['./appartment.component.scss']
})
export class AppartmentComponent implements OnInit {
  selectedHouseInAppartment: number = 0;
  selectedAppartment: number = 0;
  showPopUp: boolean = false;
  newAppartment: any = {
    appId: '',
    rooms: '',
    m2: '',
    rent: '',
    costs: ''
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

  comments : any = [
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

  constructor() { }

  ngOnInit(): void {
  }
  openPopUp() {
    this.showPopUp = true;
  }
  closePopUp(){
    this.showPopUp = false;
  }
  createAppartment(){
    this.closePopUp();
    console.log('data:', this.newAppartment);
  }

  onChangeHouseInAppartment(deviceValue: any) {
    console.log(deviceValue, this.selectedHouseInAppartment);
    this.getAppartments();
  }

  onChangeAppartment(deviceValue: any) {
    console.log(deviceValue, this.selectedAppartment);
    this.getComments();
    this.getMeters();
  }


  async getAppartments() {
    // this.appartments = await this.api.appartment.get(this.houses[this.selectedHouseInAppartment].id);
  }

  async getMeters() {
    // this.meters = await this.api.meter.get(this.houses[this.selectedHouseInAppartment].id);
  }

  async getComments() {
    // this.comments = await this.api.comment.get(this.houses[this.selectedHouseInAppartment].id);
  }
}
