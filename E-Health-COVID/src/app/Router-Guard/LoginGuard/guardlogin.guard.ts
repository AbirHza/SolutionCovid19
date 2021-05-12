import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';
import {TokenStorageService} from '../../Auth/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class GuardloginGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (!this.token.getToken()) {
      return true;
    }
    else {
      return this.router.parseUrl('');
    }
  }

  constructor(private token: TokenStorageService, private router: Router) {
  }

}
