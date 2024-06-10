import { Component } from '@angular/core';
import { Program } from '../models/program.model';
import { GetsService } from '../services/gets.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-my-programs',
  templateUrl: './my-programs.component.html',
  styleUrl: './my-programs.component.css'
})
export class MyProgramsComponent {
  public programsList: Program[];

  constructor(
    private getService: GetsService,
    private authService: AuthenticationService
  ) {}


  ngOnInit(): void {
    this.getService.fetchCreatedPrograms(this.authService.currentUsername).subscribe(programs => {       
    this.programsList = programs;
    });
  }
}
