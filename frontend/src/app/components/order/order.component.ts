import { Component,OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{

  constructor(private login:LoginService, private cart:CartService){}
  user={
    id:'',
    username:'',
    address:'',
    phoneNo:'',
    passowrd:''
  }
  orderItem:{
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
          console.log(r)
          this.user=r;
          this.cart.getCartItems(r).subscribe(
            {
              next:(r:any)=>{
                console.log(r);
                for(const i of r){
                  this.orderItem.push(i);
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
