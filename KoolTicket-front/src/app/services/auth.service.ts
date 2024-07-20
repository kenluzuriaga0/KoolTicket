import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment"
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl = `${environment.baseUrl}/auth`;
  
  constructor(private http: HttpClient, private cookie:CookieService) {
  }

  public postCredentials(loginData: any) {
    return this.http.post(`${this.baseUrl}/login`, loginData);
  }
  public getCurrentUser() {
    return this.http.get(`${this.baseUrl}/current`);
  }

  public loginUser(token: string) {
    this.cookie.set('token', token)
  }

  public isLoggedIn() {
    let tokenStr = this.cookie.get('token');
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false
    }
    return true;
  }

  // Cerramos sesion y eliminamos el token
  public logout(){
    this.cookie.delete('token');
    return true
  }

  // obtener el token
  public getToken(){
    // return localStorage.getItem('token');
    return this.cookie.get('token');
  }

  // Seteamos el usuario que inicia sesion
  public setUser(user:any){
    // localStorage.setItem('user',JSON.stringify(user)); //convertir a json
    this.cookie.set('user',user);
  }
  
  //Obtener el usuario y si no existe, cierra sesion
  // public getUser():SegUsuario{
  //   let userStr = localStorage.getItem('user');
  //   if (userStr != null) {
  //     return JSON.parse(userStr);
  //   }
  //   this.logout();
  //   return null;
  // }


}
