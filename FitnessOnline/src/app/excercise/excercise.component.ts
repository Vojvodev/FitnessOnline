import { Component, OnInit } from '@angular/core';
import { Excercises } from '../models/excercises.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-excercise',
  templateUrl: './excercise.component.html',
  styleUrl: './excercise.component.css'
})
export class ExcerciseComponent implements OnInit{
  myName: string;
  myType: string;
  myMuscle: string;
  myEquipment: string;
  myDifficulty: string;
  myInstructions: string;

  constructor(
    private route: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.route.params.subscribe( (params) => {
      this.myName= params['name'];
      this.myType= params['type'];
      this.myMuscle = params['muscle'];
      this.myEquipment = params['equipment'];
      this.myDifficulty = params['difficulty'];
      this.myInstructions = params['instructions'];
    });
  
  }

}
