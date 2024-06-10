import { Component, HostListener, OnInit } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';
import { User } from '../models/user.model';
import { ViewportScroller } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  isSmallScreen: boolean = innerWidth<900;
  passwordsDifferent = false;
  trainer: boolean = false;


  constructor(
    private authService: AuthenticationService,
    private viewportScroller: ViewportScroller,
    private router: Router
  ){}


  ngOnInit(): void {
    this.viewportScroller.scrollToPosition([0, 0]);
  }


  onCheck(){
    this.trainer = !this.trainer;
  }



  onLogin(form: NgForm){

    const username = form.value.logUsername;
    const password = form.value.logPassword;


    this.authService.login(username, password)
     .subscribe( (response) => {
                                  console.log(response);
                                  localStorage.setItem('jwtToken', response.jwt);
                                  localStorage.setItem('username', username);
                                  this.router.navigate(['']);
                                } ); 
    form.reset();
  }


  onSignup(form: NgForm){
    if(form.invalid){ return; }
    
    let user = new User(
      form.value.fname,
      form.value.lname,
      form.value.signUsername,
      form.value.email,
      form.value.signPassword,
      this.trainer,
      form.value.contact,
      form.value.city,
      form.value.avatar
    )
    console.log(user);

    const password =  form.value.signPassword;
    const rpassword = form.value.passwordConfirm;

    if(password !== rpassword){
      this.passwordsDifferent = true; return;
    }else{
      this.passwordsDifferent = false;
    }


    this.authService.signup(user)
      .subscribe( (response) => {
        console.log("OK");
        } ); 

    form.reset();
    this.router.navigate(['']);
  }


  onLogOut(){
    this.authService.logout();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.isSmallScreen = event.target.innerWidth < 900;
  }

}
