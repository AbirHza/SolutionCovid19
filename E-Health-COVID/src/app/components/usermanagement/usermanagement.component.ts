import {Component, OnInit, ViewChild} from '@angular/core';
import {SignupInfo} from '../../Auth/signup-info';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {UserService} from '../../services/user.service';
import {HttpErrorResponse} from '@angular/common/http';
import {AuthService} from '../../Auth/auth.service';
import {Router} from '@angular/router';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import {AdduserformComponent} from '../adduserform/adduserform.component';

@Component({
  selector: 'app-usermanagement',
  templateUrl: './usermanagement.component.html',
  styleUrls: ['./usermanagement.component.scss']
})
export class UsermanagementComponent implements OnInit {
  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  user: SignupInfo[] = [];
  displayedColumns: string[] = ['id', 'prenom', 'nom', 'username', 'matricule', 'spécialitée', 'email', 'date de naissance', 'sexe', 'Edit', 'Delete'];
  dataSource = new MatTableDataSource(this.user);

  constructor(private us: UserService, private auth: AuthService,  private router: Router, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.us.getAllUsers().subscribe(data => {
      this.user = data as SignupInfo[];
      this.dataSource.data = this.user;
      console.log(this.dataSource.data);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      return this.user;
    },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
      );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  deleteUser(id: number) {
    this.us.deleteUser(id).subscribe(data => {
      this.user = [];
      this.dataSource = new MatTableDataSource(this.user);
      window.location.reload();
      alert('user deleted');
    });
  }

  onEdit(idUser: number) {
    this.us.iduser = idUser;
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "70%";
    dialogConfig.height = "100%";
    this.dialog.open(AdduserformComponent, dialogConfig);
  }

  onCreate() {
    this.us.iduser = 0;
    // this.router.navigate(['adduser']);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = "70%";
    dialogConfig.height = "100%";
    this.dialog.open(AdduserformComponent, dialogConfig);
  }
}
