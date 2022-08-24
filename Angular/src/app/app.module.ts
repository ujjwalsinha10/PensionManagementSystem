import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { PensionDetailsComponent } from './components/pension-details/pension-details.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ProcessPensionComponent } from './components/process-pension/process-pension.component';
import { AuthInterceptor } from './utils/auth.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PensionerListComponent } from './components/pensioner-list/pensioner-list.component';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    PensionDetailsComponent,
    ProcessPensionComponent,
    PageNotFoundComponent,
    PensionerListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatSelectModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
