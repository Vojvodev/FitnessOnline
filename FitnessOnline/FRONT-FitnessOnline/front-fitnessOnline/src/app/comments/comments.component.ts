import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CommentsListService } from '../services/comments-list.service';
import { GetsService } from '../services/gets.service';
import { PostsService } from '../services/posts.service';
import { Comments } from '../models/comment.model';
import { AuthenticationService } from '../services/authentication.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css'
})
export class CommentsComponent implements OnInit{
  programId: string;
  commenter = new Array<string>;
  currentUsername: string;
  public isLoggedIn;

  constructor(
    private getService: GetsService,
    private postService: PostsService,
    public commentService: CommentsListService,
    public authService: AuthenticationService,
    private route: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.authService.isLoggedIn$.subscribe( (isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    } );
    
    this.route.params.subscribe( params => {this.programId = params['id'];} );

    this.currentUsername = this.authService.currentUsername;

    this.getService.fetchAllComments(this.programId).subscribe(comments => {       
      this.commentService.setCommentsList(comments);

      comments.forEach((comment) => {
        this.getService.getCommenterByCommentId(comment.id)
          .subscribe( (commenter) => this.commenter.push(commenter) );
      })
    });
  }


  onPostComment(form: NgForm){
    let content = form.value.comment;
    let userId = 1;
    
    this.getService.fetchUserByUsername(this.currentUsername).subscribe( 
      (user) => {
        userId = user.id;
        this.postService.addComment(content, userId, +this.programId).subscribe( (response) => {
          console.log(response);
          } 
        );
        
      }
    );

    

    form.reset();
  }
  

}
