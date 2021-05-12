import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import {MaterialModule} from './material/material.module';
import { LoginFormComponent } from './components/login-form/login-form.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UsermanagementComponent } from './components/usermanagement/usermanagement.component';
import { AdduserformComponent } from './components/adduserform/adduserform.component';
import { ResetpwdComponent } from './components/resetpwd/resetpwd.component';
import {ChartsModule} from 'ng2-charts';
import { MyLineChartComponent } from './my-line-chart/my-line-chart.component';
import { StatisticsBarChartComponent } from './components/statistics-bar-chart/statistics-bar-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginFormComponent,
    UsermanagementComponent,
    AdduserformComponent,
    ResetpwdComponent,
    MyLineChartComponent,
    StatisticsBarChartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    ChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
