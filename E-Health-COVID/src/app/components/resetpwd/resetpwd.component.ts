import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {resetpassword} from '../../models/resetpassword';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-resetpwd',
  templateUrl: './resetpwd.component.html',
  styleUrls: ['./resetpwd.component.scss']
})
export class ResetpwdComponent implements OnInit {
  hide = true;
  form: any = {};
  isLoginFailed = false;
  errorMessage = '';
  isLoggedIn = false;
  reset: resetpassword = new resetpassword('', '');
  constructor(private us: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  updatepass(f: NgForm) {
    this.reset.token = f.value.token;
    console.log(f.value);
    this.reset.password = f.value.password;
    console.log(this.reset);
    this.us.resetpwd(this.reset).subscribe(d => {
      console.log(d);
      console.log('success');
      this.router.navigate(['login']);
    }, error => {
      console.log(error.message);
      this.router.navigate(['login']);
    });
  }
}
