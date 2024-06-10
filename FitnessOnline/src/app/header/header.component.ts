import { Component, ElementRef, OnInit, ViewChild, viewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { GetsService } from '../services/gets.service';
import { ProgramsListService } from '../services/programs-list.service';
import { PostsService } from '../services/posts.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{
  public isLoggedIn;


  ngOnInit(): void {
      this.authService.isLoggedIn$.subscribe( (isLoggedIn) => {
        this.isLoggedIn = isLoggedIn;
        console.log('Logged in: ' + this.isLoggedIn);
      } );
      // this.isLoggedIn = true;                  // ZA TESTIRANJE                       -----------------------------------------------
  }

  constructor(
    private router: Router,
    public authService: AuthenticationService,
    private getService: GetsService,
    private programsListService: ProgramsListService
  ){}


  scrollToCategories(){
    this.router.navigate(['']);
    const categoriesSection = document.getElementById('categories');
    if (categoriesSection) {
      categoriesSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }

  srcollToPlans(){
    this.router.navigate(['']);
    const plansSection = document.getElementById('plans');
    if (plansSection) {
      plansSection.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
  }


  onSearch(form: NgForm){
    this.srcollToPlans();

    const searchFor = form.value.search;

    this.getService.searchPrograms(searchFor, 0, 5).subscribe((programs) => {
      this.programsListService.setProgramsList(programs);
      console.log(this.programsListService.getProgramsList());
    })
  }



  onMyJourney(){
    this.router.navigate(['my-journey']);
  }

  onMyPrograms(){
    this.router.navigate(['my-programs']);
  }

  onCreateNew(){
    this.router.navigate(['/add/program']);
  }
  
  onManageAccount(){
    this.router.navigate(['manage-profile']);
  }


  onLogout(){
    this.authService.logout();
  }
}
