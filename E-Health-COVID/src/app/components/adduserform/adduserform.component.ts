import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {SignupInfo} from '../../Auth/signup-info';
import {AuthService} from '../../Auth/auth.service';
import {Router} from '@angular/router';
import {UserService} from '../../services/user.service';
import {MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-adduserform',
  templateUrl: './adduserform.component.html',
  styleUrls: ['./adduserform.component.scss']
})
export class AdduserformComponent implements OnInit {
  errorMessage: any;
  isSuccessful: any;
  isSignUpFailed: boolean;
  listrole = [''];
  user: SignupInfo = new SignupInfo('', '', '', null, '', '', '', '', null);

  constructor(private auth: AuthService, private us: UserService, private matdialogref: MatDialogRef<AdduserformComponent>) { }

  ngOnInit(): void {
    console.log(this.us.iduser);
    if (this.us.iduser !=0) {
      this.us.getById(this.us.iduser).subscribe(u => {
        this.user = u as SignupInfo;
        console.log(this.user);
      });
    }
  }

  onSubmit(f: NgForm) {
    if ( this.us.iduser == 0) {
      console.log(f.value);
      this.user.nom = f.value.nom;
      this.user.prenom = f.value.prenom;
      this.user.username = f.value.username;
      this.user.dateNaissance = f.value.dateNaissance;
      this.user.matricule = f.value.matricule;
      // this.user.role = f.value.role;
      this.listrole.push(f.value.role);
      // this.user.role = this.listrole;
      this.user.email = f.value.email;
      this.user.password = f.value.password;
      this.user.sexe = f.value.sexe;
      console.log(this.user);
      this.us.addUser(this.user).subscribe(data => {
        console.log(data);
        alert('user registred');
        this.matdialogref.close();
        this.us.iduser = 0;
        f.reset();
    },
      error => alert(error.message));
    }
    else {
      console.log(f.value);
      this.user.nom = f.value.nom;
      this.user.prenom = f.value.prenom;
      this.user.username = f.value.username;
      this.user.dateNaissance = f.value.dateNaissance;
      this.user.matricule = f.value.matricule;
      // this.user.role = f.value.role;
      this.listrole.push(f.value.role);
      // this.user.role = this.listrole;
      this.user.email = f.value.email;
      this.user.password = f.value.password;
      this.user.sexe = f.value.sexe;
      this.user.id = this.us.iduser;
      console.log(this.user);
      this.us.updateUser(this.user).subscribe(data => {
          console.log(data);
          alert('user modified');
          this.matdialogref.close();
          this.us.iduser = 0;
          f.reset();
        },
        error => alert(error.message));
    }
  }
}
