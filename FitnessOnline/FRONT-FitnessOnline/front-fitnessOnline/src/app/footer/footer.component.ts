import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { PostsService } from '../services/posts.service';
import { GetsService } from '../services/gets.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {

  constructor(
    public authService: AuthenticationService,
    public postService: PostsService,
    public getService: GetsService
  ){}

  public isLoggedIn;


  ngOnInit(): void {
      this.authService.isLoggedIn$.subscribe( (isLoggedIn) => {
        this.isLoggedIn = isLoggedIn;
      } );
  }

  onSubmit(form: NgForm){
    let content = form.value.txt;
    let userId = 1;

    this.getService.fetchUserByUsername(this.authService.currentUsername).subscribe( 
      (user) => {
        userId = user.id;
        this.postService.addMessage(content, userId.toString()).subscribe( (response) => {
          console.log(response);
        });
      }
    );

    form.reset();
    

  }
}
