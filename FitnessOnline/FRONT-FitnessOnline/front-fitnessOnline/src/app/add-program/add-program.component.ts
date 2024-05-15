import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostsService } from '../services/posts.service';
import { ViewportScroller } from '@angular/common';


@Component({
  selector: 'app-add-program',
  templateUrl: './add-program.component.html',
  styleUrl: './add-program.component.css'
})
export class AddProgramComponent implements OnInit{
  checked = false;

  constructor(
    private postService: PostsService,
    private viewportScroller: ViewportScroller
  ){}

  ngOnInit(): void {
    this.viewportScroller.scrollToPosition([0, 0]);
  }


  onCheck(){
    this.checked = !this.checked;
  }
  
  
  addProgram(form: NgForm){
    const name          = form.value.name1;
    const description   = form.value.description;
    const categoryName  = form.value.category;
    let price           = form.value.price;
    price = parseFloat(price);

    const difficulty    = form.value.difficulty;
    const duration      = form.value.duration;
    const location      = form.value.location;
    const activity_type = form.value.activity_type;
    const equipment     = form.value.equipment;
    const trainerName   = form.value.trainerName;

    let bodyweight      = form.value.notBodyweight;
    if(bodyweight === '') bodyweight = true;
      else bodyweight = false;
    
    const image         = form.value.photo;

    console.log(
      name, 
      description,  
      price, 
      difficulty, 
      duration, 
      location, 
      activity_type, 
      equipment, 
      'bw', bodyweight, 
      'image', image,
      categoryName,
      trainerName       
    );
    
    this.postService.addProgram(
      name, 
      description,  
      price, 
      difficulty, 
      duration, 
      location, 
      activity_type, 
      equipment, 
      bodyweight, 
      image,
      categoryName,
      trainerName
    ).subscribe( (response) => {
      console.log(response);
    });
  
    form.reset();
  }


}
