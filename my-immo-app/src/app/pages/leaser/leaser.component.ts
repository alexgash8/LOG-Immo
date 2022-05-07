import { Component, OnInit } from '@angular/core';
import {ApiService} from "../../services/api.service";
import { HouseService } from 'src/app/services/house.service'

@Component({
  selector: 'app-leaser',
  templateUrl: './leaser.component.html',
  styleUrls: ['./leaser.component.scss']
})

export class LeaserComponent implements OnInit {
  selectedHouse: number = 0;
  showPopUp: boolean = false;
  selectedLeaser: number = 0;
  newLeaser: any = {
    firstName: '',
    lastName: '',
    countPeople: '',
    dateIn: '',
    price: 750,
    operatingCosts: 250,
    email: 'alexgash8@gmail.com',
    bankAccount: {
      id: 0,
      bankName: 'PostBank',
      iban: 'BE212335134646413',
      bic: '1315646415 1346143646'
    },
    lastAddress: {
      id:0,
      street: 'Pushkina',
      houseNumber: 10,
      type:'HOUSE',
      postalCode:'51273'
    },
    futureAddress: {
      id:0,
      street: 'Holsteiner',
      houseNumber: 171,
      type:'HOUSE',
      postalCode:'22457'
    },
    appartment: {
      id:38
    },
    phones: [
      {
        id: 0,
        number: '0673516001',
        type: 'HOME'
      },
      {
        id: 0,
        number: '0633772515',
        type: 'MOBILE'
      }
    ]
  }

  leasers : any = [
    {}, {}
  ]

  constructor(public houseService : HouseService, private api: ApiService) { }

  ngOnInit(): void {
  }
  openPopUp() {
    this.showPopUp = true;
  }
  closePopUp(){
    this.showPopUp = false;
  }
  createLeaser(){
    this.closePopUp();
    console.log('data:', this.newLeaser);
  }

  onChangeLeaser(deviceValue: any) {
    console.log(deviceValue, this.selectedLeaser);

  }

  onChangeHouse(deviceValue: any) {
    // console.log(deviceValue, this.selectedHouse);
    // this.getAppartments();
  }

}
//
// class HouseComponent {
//   newHouse: any = {
//     countAppartments: '',
//     city: '',
//     street: '',
//     house_Number: '',
//     postal_code: '',
//     insuranceNumber: ''
//   }
//   constructor(private api: ApiService) { }
//   async ngOnInit() {
//     await this.getHouses();
//   }
//
//   onChangeHouse(deviceValue: any) {
//     console.log(deviceValue, this.selectedHouse);
//     // getAppartments();
//   }
//
//
//
//   async getHouses(){
//     this.houses = await this.api.house.get();
//   }
//
//   houses : any = [
//     {
//       id: 1,
//       countAppartments: 11,
//       insuranceNumber: 11,
//       address: {
//         id: 1,
//         city: 'kiev',
//         street: 11,
//         house_Number: 11,
//         appNumb: 11,
//         postal_code: 11
//       }
//     },
//     {
//       id: 2,
//       countAppartments: 22,
//       insuranceNumber: 22,
//       address: {
//         id: 2,
//         city: 'mariupol',
//         street: 22,
//         house_Number: 2,
//         appNumb: 2,
//         postal_code: 22
//       }
//     },
//   ];
// }


