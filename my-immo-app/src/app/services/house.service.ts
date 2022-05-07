import { Injectable } from '@angular/core';
import { ApiService} from 'src/app/services/api.service';

@Injectable({
  providedIn: 'root'
})
export class HouseService {
  selectedHouse: number = 0;

  newHouse: any = {
    countAppartments: '',
    city: '',
    street: '',
    house_Number: '',
    postal_code: '',
    insuranceNumber: ''
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

  constructor(private api: ApiService) { }

  async getHouses(){
    this.houses = await this.api.house.get();
  }

  async createHouse(){
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


}
