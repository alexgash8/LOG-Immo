import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-leaser',
  templateUrl: './leaser.component.html',
  styleUrls: ['./leaser.component.scss']
})
export class LeaserComponent implements OnInit {
  showPopUp: boolean = false;
  newLeaser: any = {
    firstName: '',
    lastName: '',
    countPeople: '',
    dateIn: ''
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
  createHouse(){
    this.closePopUp();
    console.log('data:', this.newLeaser);
  }

}
