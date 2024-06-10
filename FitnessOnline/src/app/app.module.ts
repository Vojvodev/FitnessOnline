import { FormsModule }    from '@angular/forms';
import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';

import { AppComponent }         from './app.component';
import { HeaderComponent }      from './header/header.component';
import { FooterComponent }      from './footer/footer.component';
import { WelcomeComponent }     from './welcome/welcome.component';
import { CategoriesComponent }  from './categories/categories.component';
import { ProgramsComponent }    from './programs/programs.component';
import { LoginComponent }       from './login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule }     from '@angular/common/http';
import { ProgramComponent }     from './program/program.component';
import { AddProgramComponent }  from './add-program/add-program.component';
import { NotFoundComponent }    from './not-found/not-found.component';
import { authGuard }            from './auth.guard';
import { CommentsComponent } from './comments/comments.component';
import { MyJourneyComponent } from './my-journey/my-journey.component';
import { MyProgramsComponent } from './my-programs/my-programs.component';
import { ManageProfileComponent } from './manage-profile/manage-profile.component';
import { NewsComponent } from './news/news.component';
import { ExcerciseComponent } from './excercise/excercise.component';


const appRoutes: Routes = [
  {path: '',                component: WelcomeComponent},
  {path: 'login',           component: LoginComponent},
  {path: 'program/:id',     component: ProgramComponent},
  {path: 'add/program',     component: AddProgramComponent, canActivate:[authGuard]},       // 
  {path: 'my-journey',      component: MyJourneyComponent},         
  {path: 'my-programs',     component: MyProgramsComponent},         
  {path: 'manage-profile',  component: ManageProfileComponent},
  {path: 'excercise/:name/:type/:muscle/:equipment/:difficulty/:instructions', component: ExcerciseComponent},         
  {path: '**',              component: NotFoundComponent}          
];       


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    WelcomeComponent,
    CategoriesComponent,
    ProgramsComponent,
    LoginComponent,
    ProgramComponent,
    AddProgramComponent,
    NotFoundComponent,
    CommentsComponent,
    MyJourneyComponent,
    MyProgramsComponent,
    ManageProfileComponent,
    NewsComponent,
    ExcerciseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
  ],
  exports:[
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
