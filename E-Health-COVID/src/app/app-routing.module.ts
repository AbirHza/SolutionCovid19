import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginFormComponent} from './components/login-form/login-form.component';
import {FooterComponent} from './components/footer/footer.component';
import {UsermanagementComponent} from './components/usermanagement/usermanagement.component';
import {AdduserformComponent} from './components/adduserform/adduserform.component';
import {HomeComponent} from './components/home/home.component';
import {ResetpwdComponent} from './components/resetpwd/resetpwd.component';
import {MyLineChartComponent} from './my-line-chart/my-line-chart.component';
import {StatisticsBarChartComponent} from './components/statistics-bar-chart/statistics-bar-chart.component';
import {GuardloginGuard} from './Router-Guard/LoginGuard/guardlogin.guard';
import {GuardAdminDashboardGuard} from './Router-Guard/AdminGuard/guard-admin-dashboard.guard';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginFormComponent},
  {path: 'footer', component: FooterComponent},
  {path: 'usermanagement', component: UsermanagementComponent, canActivate: [GuardAdminDashboardGuard]},
  {path: 'adduser', component: AdduserformComponent},
  {path: 'reset', component: ResetpwdComponent},
  {path: 'statistics', component: MyLineChartComponent},
  {path: 'barchart', component: StatisticsBarChartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
