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
      this.getService.fetchAllPrograms(1, 100).subscribe( (programs) => this.programsList = programs );
  }


  getProgramsList() : Program[] {
    return this.programsList;
  }

  setProgramsList(list: Program[]){
    this.programsList = list;
  }
}
