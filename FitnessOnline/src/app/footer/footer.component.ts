import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {

  constructor(public authService: AuthenticationService){}

  public isLoggedIn;


  ngOnInit(): void {
      this.authService.isLoggedIn$.subscribe( (isLoggedIn) => {
        this.isLoggedIn = isLoggedIn;
      } );
  }

  onSubmit(form: NgForm){
    form.reset();
  }
}
