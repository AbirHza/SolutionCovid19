import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {AuthService} from '../../Auth/auth.service';
import {VerifAuthService} from '../../services/verif-auth.service';

@Injectable({
  providedIn: 'root'
})
export class GuardAdminDashboardGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.verifAuth.verifrole) {
      return true;
    }
    else {
      return this.router.parseUrl('');
    }
  }
  constructor(private verifAuth: VerifAuthService, private router: Router) {
  }
}
