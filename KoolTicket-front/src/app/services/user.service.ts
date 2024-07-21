import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl = `${environment.baseUrl}/user`;
  
  constructor(private http: HttpClient) {
  }

  public getAllUsers() {
    return this.http.get(`${this.baseUrl}`);
  }

  public getOneById(id:number) {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}
