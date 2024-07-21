import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ButtonService {

  baseUrl = `${environment.baseUrl}/button`;
  
  constructor(private http: HttpClient) {
  }

  public getAllButtons() {
    return this.http.get(`${this.baseUrl}`);
  }

  public getOneById(id:number) {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

}
