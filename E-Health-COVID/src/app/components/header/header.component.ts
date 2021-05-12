import { Component, OnInit } from '@angular/core';
import {VerifAuthService} from '../../services/verif-auth.service';
import {TokenStorageService} from '../../Auth/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  info: any;
  dropdowncheck = false;
  username = '';
  constructor(public verifAuth: VerifAuthService, private token: TokenStorageService) { }

  ngOnInit(): void {
    if (this.token.getToken()) {
      this.username = this.token.getUsername();
      this.info = {
        token: this.token.getToken(),
        username: this.token.getUsername(),
        authorities: this.token.getAuthorities()
      };
    }
    console.log(this.token.getToken());
    console.log(this.info);
    console.log(this.verifAuth.verif);
  }

  dropdownchange(){
    this.dropdowncheck = !this.dropdowncheck;
  }

  // tslint:disable-next-line:typedef
  logout() {
    window.sessionStorage.clear();
    this.verifAuth.verifrole = false;
    this.verifAuth.verif = false;
  }
}
