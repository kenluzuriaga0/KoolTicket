import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  baseUrl = `${environment.baseUrl}/branch`;
  
  constructor(private http: HttpClient) {
  }

  public getAllBranches() {
    return this.http.get(`${this.baseUrl}`);
  }
}
