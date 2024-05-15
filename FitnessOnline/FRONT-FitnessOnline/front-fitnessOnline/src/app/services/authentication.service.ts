import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { PostsService } from './posts.service';
import { User } from '../models/user.model';


interface LoginResponseData {
  jwt: string;
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private isLoggedInSubject = new BehaviorSubject<boolean>(false);
  public isLoggedIn$ = this.isLoggedInSubject.asObservable();
  public currentUsername = "xx";


  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  isAuthenticated(){
    this.isLoggedIn$.subscribe( (value) => {
      if(value) 
        return true;
      else
        return false;
    } );
  }


  signup(user: User){
    const returnMessage = this.http.post<string>("http://localhost:8080/api/v1/register", {
                                              'fname':    user.fname, 
                                              'lname':    user.lname, 
                                              'username':    user.uname, 
                                              'email':    user.email, 
                                              'password': user.password,
                                              'trainer':  user.trainer,
                                              'contact':  user.contact,
                                              'role':             'LOGGED_USER',
                                              'commentsList':     null,
                                              'createdPrograms':  null,
                                              'enrolledPrograms': null,
                                              'city':     user.city, 
                                              'avatar':   user.avatar
                                              }
                                            );

    return returnMessage;
  }

  
  login(username: string, password: string){
    let something = this.http.post<LoginResponseData>("http://localhost:8080/api/v1/login", {
                                              'username': username,
                                              'password': password
                                            }
                                          );
    this.isLoggedInSubject.next(true);
    this.currentUsername = username;

    return something;
  }


  logout(){
    this.http.post<any>("http://localhost:8080/api/v1/logout", {});
    this.isLoggedInSubject.next(false);
    localStorage.removeItem('jwtToken');
    localStorage.removeItem('username');
    this.router.navigate(['']);
  }

}
