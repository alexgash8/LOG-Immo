import { Component, OnInit } from '@angular/core';
import { ApiService} from 'src/app/services/api.service';

@Component({
  selector: 'app-house',
  templateUrl: './house.component.html',
  styleUrls: ['./house.component.scss']
})

export class HouseComponent implements OnInit {
  selectedHouse: number = 0;
  showPopUp: boolean = false;
  houses = [
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
  meters : any = [
    {
      id: 1,
      name: 'aaa',
      type: 'gas',
      number: "000000000000002"
    },
    {
      id: 2,
      name: 'bbbb',
      type: 'water',
      number: "0003235442400002"
    },

  ];
  newHouse: any = {
    appNumb: '',
    city: '',
    street: '',
    number: '',
    plz: '',
    insurance: ''
  }
  newCounter: any = {
    name: '',
    type: '',
    number: ''
  }
  constructor(private api: ApiService) { }

  ngOnInit(): void {
  }
  openPopUp() {
    this.showPopUp = true;
  }
  closePopUp(){
    this.showPopUp = false;
  }

  onChange(deviceValue: any) {
    console.log(deviceValue, this.selectedHouse);
    this.refreshMeters();
  }

  async refreshMeters() {
    // this.meters = await this.api.meter.get(this.houses[this.selectedHouse].id);
  }

  createCounter() {

  }

  async createHouse(){
    this.closePopUp();
    const obj = {
      id: 0,
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
    const answer = await this.api.house.add(obj);
    // this.houses = await this.api.house.get();
    console.log('data:', this.newHouse);
  }
}
