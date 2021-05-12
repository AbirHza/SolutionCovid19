import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {SignupInfo} from './signup-info';
import {LoginInfo} from './login-info';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private url = environment.serverURL;
  private loginUrl = 'api/auth/signin';
  private signupUrl = 'api/auth/signup';

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: LoginInfo): Observable<any> {
    return this.http.post(this.url + this.loginUrl, credentials, httpOptions);
  }

  signUp(info: SignupInfo): Observable<any> {
    console.log(info);
    return this.http.post(this.url + this.signupUrl, info);
  }
}
