import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-men',
  templateUrl: './men.component.html',
  styleUrls: ['./men.component.css']
})
export class MenComponent implements OnInit{

  constructor(private product:ProductService, private cart: CartService, private login:LoginService){}
  data: { id: number, name: string, description: string, category: string, price: number, image: string }[] = []
  ngOnInit(): void {
    this.product.getProducts().subscribe(
      {
        next: (r: any) => {
          console.log(r);
          for (const i of r) {
            if (i.category == "men") {
              this.data.push(i);
            }

          }
        },
        error: (e) => {
          console.log(e);
        }
      }
    )
  }

  quantity:{product:object,quantity:number}[]=[]
  user:object={}
cartData={
  user:this.user,
quantity:this.quantity
}

  addCart(product:any){
    this.login.getUser().subscribe(
      {
        next:(r:any)=>{
          console.log(r);
          this.user=r;
          this.cartData.user=this.user;
          this.quantity.push({product:product,quantity:1})
    this.cartData.quantity=this.quantity;
    console.log(this.cartData)
    this.cart.addToCart(this.cartData).subscribe(
      {
        next:(r:any)=>{
         
          console.log(r);
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
