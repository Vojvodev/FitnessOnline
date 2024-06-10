import { Injectable, OnInit } from '@angular/core';
import { Program } from '../models/program.model';
import { GetsService } from './gets.service';

@Injectable({
  providedIn: 'root'
})
export class ProgramsListService implements OnInit{
  private programsList: Program[];

  constructor(
    private getService: GetsService
  ) { }


  ngOnInit(): void {
      this.fillProgramsList();
  }


  getProgramsList() : Program[] {
    return this.programsList;
  }

  setProgramsList(list: Program[]){
    this.programsList = list;
  }

  fillProgramsList(){
    this.getService.fetchAllProgramsRaw().subscribe( (programs) => this.programsList = programs );
  }
}
