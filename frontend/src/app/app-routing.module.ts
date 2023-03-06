import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ItemsCatalogueComponent } from './components/items-catalogue/items-catalogue.component';
import { WomensComponent } from './components/womens/womens.component';
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

const routes: Routes = [
  {path:'',component:HomeComponent },
  {path:'items-catalogue',component:ItemsCatalogueComponent },
  {path:'womens',component:WomensComponent},
  {path:'men',component:MenComponent},
  {path:'kids',component:KidsComponent},
  {path:'home-app',component:HomeAppComponent},
  {path:'footwear',component:FootwearComponent},
  {path:'beauty',component:BeautyComponent},
  {path:'electric',component:ElectricComponent},
  {path:'accessories',component:AccessoriesComponent},
  {path:'login',component:LoginComponent},
  {path:'cart',component:CartComponent},
  {path:'signup',component:SignupComponent},
  {path:'order',component:OrderComponent},
  {path:'search',component:SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
