import { Component, OnInit } from '@angular/core';
import { GetsService } from '../services/gets.service';
import { AuthenticationService } from '../services/authentication.service';
import { Program } from '../models/program.model';
import html2pdf from 'html2pdf.js';

@Component({
  selector: 'app-my-journey',
  templateUrl: './my-journey.component.html',
  styleUrl: './my-journey.component.css'
})
export class MyJourneyComponent implements OnInit{
  public programsList: Program[];

  constructor(
    private getService: GetsService,
    private authService: AuthenticationService
  ) {}


  ngOnInit(): void {
    this.getService.fetchEnrolledPrograms(this.authService.currentUsername).subscribe( (programs) => {
       this.programsList = programs;
    } );
  }

  generatePDF() {
    const element = document.body;
    const opt = {
      margin: 1,
      filename: 'MY-JOURNEY.pdf',
      image: { type: 'jpeg', quality: 0.98 },
      html2canvas: { scale: 2 },
      jsPDF: { unit: 'in', format: 'letter', orientation: 'portrait' }
    };

    // Use html2pdf library to generate PDF
    html2pdf().from(element).set(opt).save();
  }

}
