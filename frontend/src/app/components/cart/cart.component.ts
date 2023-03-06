import { Component,OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private login:LoginService, private cart:CartService){}

  cartItem:{
    id:number,user:object,quantity:{quantityId:number,quantity:number,product:{category:string, 
      description:string,
      id:number,
      image:string,
      name:string,
      price:number}}[]
  }[]=[]
  ngOnInit(): void {
    this.login.getUser().subscribe(
      {
        next:(r:any)=>{

          this.cart.getCartItems(r).subscribe(
            {
              next:(r:any)=>{
                console.log(r);
                for(let i of r){
                  this.cartItem.push(i);
                }
              
              },
              error:(e)=>{
                console.log(e);
              }
            }
          )
        },
        error:(e)=>{
          console.log(e);
        }
      }
    )
  }
}
