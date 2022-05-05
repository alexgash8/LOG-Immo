import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

let headers = new HttpHeaders();
let url = 'http://localhost:9999';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private http : HttpClient,
  ) {}

  get httpOptions() {
    // const auth_token = (appState.user?.auth_token) ? appState.user.auth_token : 'no';
    headers = headers
      .set('Content-Type', 'application/json');
      // .set('auth_token', auth_token);
    const httpOptions = { headers };
    return httpOptions
  }


  house = {
    get: () => this.http.get(url + '/house/houses', this.httpOptions).toPromise(),
    add: (info:any) => this.http.post(url + '/house', info, this.httpOptions).toPromise(),
    del: (id: any) => this.http.delete(url + '/house' + id, this.httpOptions).toPromise(),
    edit: (info: any) => this.http.put(url + '/house', info, this.httpOptions).toPromise()
  };

  meter = {
    get: (id: any) => this.http.get(url + '/house-meter/' + id, this.httpOptions).toPromise(),
    add: (info:any) => this.http.post(url + '/house-meter', info, this.httpOptions).toPromise(),
    del: (id: any) => this.http.delete(url + '/house-meter' + id, this.httpOptions).toPromise(),
    edit: (info: any) => this.http.put(url + '/house-meter', info, this.httpOptions).toPromise()
  };

  history = {
    get: (id: any) => this.http.get(url + '/history/' + id, this.httpOptions).toPromise(),
    add: (info:any) => this.http.post(url + '/history', info, this.httpOptions).toPromise(),
    del: (id: any) => this.http.delete(url + '/history' + id, this.httpOptions).toPromise(),
    edit: (info: any) => this.http.put(url + '/history', info, this.httpOptions).toPromise()
  };

  payment = {
    get: (id: any) => this.http.get(url + '/payment/' + id, this.httpOptions).toPromise(),
    add: (info:any) => this.http.post(url + '/payment', info, this.httpOptions).toPromise(),
    del: (id: any) => this.http.delete(url + '/payment' + id, this.httpOptions).toPromise(),
    edit: (info: any) => this.http.put(url + '/payment', info, this.httpOptions).toPromise()
  };
}
