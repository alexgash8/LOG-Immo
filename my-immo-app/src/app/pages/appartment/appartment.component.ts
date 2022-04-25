import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-appartment',
  templateUrl: './appartment.component.html',
  styleUrls: ['./appartment.component.scss']
})
export class AppartmentComponent implements OnInit {
  showPopUp: boolean = false;
  newAppartment: any = {
    appId: '',
    rooms: '',
    m2: '',
    rent: '',
    costs: ''
  }
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
}
