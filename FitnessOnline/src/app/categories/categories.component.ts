import { Component, OnInit } from '@angular/core';
import { GetsService } from '../services/gets.service';
import { Category } from '../models/category.model';
import { ProgramsListService } from '../services/programs-list.service';
import { PostsService } from '../services/posts.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrl: './categories.component.css',
  providers: [GetsService]
})
export class CategoriesComponent implements OnInit{
  private categoriesList: Category[];
  public currentPage = 1;

  constructor(
    private getService: GetsService,
    private postService: PostsService,
    private authService: AuthenticationService,
    private programsListService: ProgramsListService
  ){}



  ngOnInit(): void {
      this.getService.fetchAllCategories(0, 6).subscribe(categories => {
        this.categoriesList = categories;
      });
  }

  getCategoriesList(){
    return this.categoriesList;
  }

  
  categoryClick(categoryName: string){
    this.getService.fetchAllProgramsFilteredByCategory(categoryName, 0, 5).subscribe(programs =>{
      this.programsListService.setProgramsList(programs);
    });
  }


  switchPage(page: number){
    if(page >= 1){
      this.currentPage = page;
      this.getService.fetchAllCategories(this.currentPage - 1, 6).subscribe(categories => {
        this.categoriesList = categories;
      });
    }
  }


  onSubscribe(catName: string){
    this.postService.onSubscribe(catName, this.authService.currentUsername).subscribe( (response) => console.log(response));
  }

}
