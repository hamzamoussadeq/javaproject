import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/pageDesign/navbar/navbar.component';
import { FooterComponent } from './components/pageDesign/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { ItemsCatalogueComponent } from './components/items-catalogue/items-catalogue.component';
import { WomensComponent } from './components/womens/womens.component';

import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {FormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';

import { MenComponent } from './components/men/men.component';
import { KidsComponent } from './components/kids/kids.component';
import { HomeAppComponent } from './components/home-app/home-app.component';
import { FootwearComponent } from './components/footwear/footwear.component';
import { BeautyComponent } from './components/beauty/beauty.component';
import { ElectricComponent } from './components/electric/electric.component';
import { AccessoriesComponent } from './components/accessories/accessories.component';
import { LoginComponent } from './components/login/login.component';
import { CartComponent } from './components/cart/cart.component';
import { SignupComponent } from './components/signup/signup.component';
import { OrderComponent } from './components/order/order.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ItemsCatalogueComponent,
    WomensComponent,
    MenComponent,
    KidsComponent,
    HomeAppComponent,
    FootwearComponent,
    BeautyComponent,
    ElectricComponent,
    AccessoriesComponent,
    LoginComponent,
    CartComponent,
    SignupComponent,
    OrderComponent,
    SearchComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    FormsModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
