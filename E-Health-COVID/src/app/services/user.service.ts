import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {SignupInfo} from '../Auth/signup-info';
import {resetpassword} from '../models/resetpassword';
import {LoginInfo} from '../models/LoginInfo';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  get iduser(): number {
    return this._iduser;
  }

  set iduser(value: number) {
    this._iduser = value;
  }
  get role(): string[] {
    return this._role;
  }

  set role(value: string[]) {
    this._role = value;
  }
  private url = environment.serverURL;
  private _role = [''];
  private _iduser = 0;

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  public getByUsername(username: string){
    return this.http.get(this.url + 'api/test/getByUsername/' + username );
  }

  public updateUser(user: SignupInfo) {
    return this.http.put(this.url + 'api/test/updateUser', user );
  }

  public getById(id: number) {
    return this.http.get(this.url + 'api/test/getByid/' + id);
  }

  public getAllUsers() {
    return this.http.get(this.url + 'api/test/retrieve-all-users');
  }

  public deleteUser(id: number) {
    return this.http.delete(this.url + 'api/test/remove-user/' + id);
  }

  // tslint:disable-next-line:typedef
  public addUser(user: SignupInfo) {
    return this.http.post(this.url + 'api/auth/signup', user);
  }

  public resetpwd(reset: resetpassword) {
    return this.http.post(this.url + 'reset', reset);
  }

  public forgotpwd(login: LoginInfo) {
    return this.http.post(this.url + 'forgot', login);
  }
}
