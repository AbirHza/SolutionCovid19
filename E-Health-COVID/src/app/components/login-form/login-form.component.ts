import { Component, OnInit } from '@angular/core';
import {LoginInfo} from '../../Auth/login-info';
import {SignupInfo} from '../../Auth/signup-info';
import {AuthService} from '../../Auth/auth.service';
import {TokenStorageService} from '../../Auth/token-storage.service';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {VerifAuthService} from '../../services/verif-auth.service';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: LoginInfo = new LoginInfo('', '' );
  user: SignupInfo = new SignupInfo('', '', '', null, '',
    '', '', '', null);

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService,
              private router: Router, private verifauth: VerifAuthService, private us: UserService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  // tslint:disable-next-line:typedef
  onSubmit(f: NgForm) {
    console.log(f.value);

    this.loginInfo = new LoginInfo(
      f.value.username,
      f.value.password);

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.roles);
        this.isLoginFailed = false;
        this.isLoggedIn = false;
        this.roles = this.tokenStorage.getAuthorities();
        this.verifauth.verif = true;
        console.log(this.tokenStorage.getAuthorities());
        for (const ro of this.tokenStorage.getAuthorities()){
          // tslint:disable-next-line:triple-equals
          if (ro == '[\"ROLE_ADMINISTRATEUR\"]') {
            this.verifauth.verifrole = true;
          }
        }
        console.log('success');
        this.router.navigate(['']);
      },
      error => {
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  onResetPwd(f: NgForm) {
    this.loginInfo.password = '';
    this.loginInfo.username = f.value.username;
    this.us.forgotpwd(this.loginInfo).subscribe(d => {
      this.router.navigate(['reset']);
    }, error => {
      this.router.navigate(['reset']);
    });
  }
}
