import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { GetsService } from '../services/gets.service';
import { User } from '../models/user.model';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-manage-profile',
  templateUrl: './manage-profile.component.html',
  styleUrl: './manage-profile.component.css'
})
export class ManageProfileComponent implements OnInit{
  currentUsername = this.authService.currentUsername;
  currentUser: User = null;

  constructor(
    private getService: GetsService,
    private authService: AuthenticationService
  ){}  


  ngOnInit(): void {
    this.getService.fetchUserByUsername(this.currentUsername)
    .subscribe( (user) => this.currentUser = user );
  }


  onSubmit(form: NgForm){
    //Sign up Update
  }

}
