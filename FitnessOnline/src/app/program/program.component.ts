import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Program } from '../models/program.model';
import { ProgramsListService } from '../services/programs-list.service';
import { ViewportScroller } from '@angular/common';
import { AuthenticationService } from '../services/authentication.service';
import { GetsService } from '../services/gets.service';
import { PostsService } from '../services/posts.service';

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrl: './program.component.css'
})
export class ProgramComponent implements OnInit{
  program : Program;
  id: number;

  constructor(
    private route: ActivatedRoute,
    private viewportScroller: ViewportScroller,
    private programsListService: ProgramsListService,
    private authService: AuthenticationService,
    private postService: PostsService
  ){}

  ngOnInit(): void {
      this.viewportScroller.scrollToPosition([0, 0]);

      this.route.params.subscribe( (params: Params) => {
        this.id = +params['id'];
      });
      
      this.program = this.programsListService.getProgramsList()[this.id - 1];
  }

  onEnroll(programId: number){
    let currentUsername = this.authService.currentUsername;
    
    this.postService.enroll(currentUsername, programId).subscribe( (response) => console.log(response) );
  }


}
