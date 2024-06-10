import { Component, OnInit } from '@angular/core';
import { GetsService } from '../services/gets.service';
import { NgForm } from '@angular/forms';
import { ProgramsListService } from '../services/programs-list.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-plans',
  templateUrl: './programs.component.html',
  styleUrl: './programs.component.css',
  providers: [GetsService]
})
export class ProgramsComponent implements OnInit{
  public currentPage = 1;
  isLoggedIn = true;

  constructor(
    private getService: GetsService,
    private programsListService: ProgramsListService,
    private authService: AuthenticationService
  ){}


  ngOnInit(): void {
    this.getService.fetchAllPrograms(0, 5).subscribe(programs => {
      this.programsListService.setProgramsList(programs);
    });

    this.authService.isLoggedIn$.subscribe(isLoggedIn => {
      this.isLoggedIn = !this.isLoggedIn;
    });
  }

  getProgramsListService(){
    return this.programsListService;
  }

  onSort(direction: string, field: string){
    this.getService.fetchAllProgramsSorted(direction, field, 0 , 5).subscribe(programs =>{
      this.programsListService.setProgramsList(programs);
    });
  }

  onFilter(form: NgForm){
    this.getService.fetchAllProgramsFiltered(form, 0, 5).subscribe(programs =>{
      this.programsListService.setProgramsList(programs);
    });
  }

  switchPage(page: number){
    if(page >= 1){
      this.currentPage = page;
      this.getService.fetchAllPrograms(this.currentPage - 1, 5).subscribe(programs => {
        this.programsListService.setProgramsList(programs);
      });
    }
  }





}
