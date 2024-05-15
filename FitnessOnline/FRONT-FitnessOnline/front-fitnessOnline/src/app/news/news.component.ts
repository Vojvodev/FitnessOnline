import { Component, OnInit } from '@angular/core';
import { GetsService } from '../services/gets.service';
import { News } from '../models/news.model';
import { Excercises } from '../models/excercises.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrl: './news.component.css'
})
export class NewsComponent implements OnInit{
  newsArray: News[];
  excercisesArray: Excercises[];
  APIKey = 'hdQ5Hnm+fjNg/c0Vr00R8g==iRciOvGULVHAl6aC';


  constructor(
    private getService: GetsService,
    private router: Router
  ){}


  ngOnInit(): void {
    this.getService.fetchNews().subscribe( (response) => {
      this.newsArray = response; 
      this.newsArray = this.newsArray.slice(0, 5);
    } );

    this.getService.fetchExcercises(this.APIKey).subscribe( (response) => {this.excercisesArray = response} );
  }

}
