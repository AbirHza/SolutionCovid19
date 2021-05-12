import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VerifAuthService {
  get verifrole(): boolean {
    return this._verifrole;
  }

  set verifrole(value: boolean) {
    this._verifrole = value;
  }
  get verif(): boolean {
    return this._verif;
  }

  set verif(value: boolean) {
    this._verif = value;
  }
  // tslint:disable-next-line:variable-name
  private _verif = false;
  // tslint:disable-next-line:variable-name
  private _verifrole = false;

  constructor(){
    this._verif = false;
  }

}
