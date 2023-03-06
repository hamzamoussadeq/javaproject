import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RegisterService } from 'src/app/services/register.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit{

  credentials={
    username:'',     
    password:'',
    address:'',
    phoneNo:''
  }

  constructor(private registerService:RegisterService , private snackbar:MatSnackBar) { }

  ngOnInit(): void{
  }
  onsubmit()
  {
    // console.log("form is submitted");
    if((this.credentials.username!='' && this.credentials.password!='' && this.credentials.address!='' && this.credentials.phoneNo!='')
    && (this.credentials.username!=null && this.credentials.password!=null && this.credentials.address!=null && this.credentials.phoneNo!=null))
    {
      console.log("We have to submit the form to server");
      this.registerService.doRegister(this.credentials).subscribe(
        (        response: any)=>{
          console.log(response);
          this.snackbar.open("Registration successfull","close")

          window.location.href="/items-catalogue"
        },
        (        error: any)=>{
          console.log(error);
          this.snackbar.open("Registration Failed","close")

        }
      )

    }else{
      console.log("fields are empty !!");
      this.snackbar.open("fields are empty","close")
    }
  }

}
