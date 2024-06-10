import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comments } from '../models/comment.model';

@Injectable({
  providedIn: 'root'
})
export class PostsService {
  private baseURL = 'http://localhost:8080/api/v1/';


  constructor(private http: HttpClient) { }


  addComment(content: string, userId: number, programId: number) {

    /* const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem('jwtToken')
      })
    }; */

    /* const encodedContent = encodeURIComponent(content);
    const encodedURL = `${this.baseURL}add/comment?content=${encodedContent}&userId=${userId}&programId=${programId}`;

    return this.http.post<string>(encodedURL, {}); */

    return this.http.post<string>(this.baseURL + 'add/comment', {
      content: content,
      userId: userId,
      programId: programId
    });
    
    // return this.http.post<string>(this.baseURL + 'add/comment?content=' + content + '&userId=' + userId + '&programId=' + programId, {});
  }


  addMessage(content: string, senderId: string){
    console.log(content);
    return this.http.post<string>(this.baseURL + 'add/message', { content, senderId });
  }


  addProgram(
              name          : string, 
              description   : string, 
              price         : number, 
              difficulty    : string, 
              duration      : string, 
              location      : string, 
              activity_type : string, 
              equipment     : string, 
              bodyweight    : boolean, 
              image         : string,
              categoryName  : string,
              trainerName   : string 
            ){

    /* const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + localStorage.getItem('jwtToken')
      })
    }; */


    return this.http.post<string>(this.baseURL + 'add/program', 
      {
        name          : name         , 
        description   : description  , 
        price         : price        , 
        difficulty    : difficulty   , 
        duration      : duration     , 
        location      : location     , 
        activity_type : activity_type, 
        equipment     : equipment    , 
        bodyweight    : bodyweight   , 
        image         : image        ,
        categoryName  : categoryName , 
        trainerName   : trainerName  
      }
      /* ,httpOptions */
    );

  }


  enroll(username: string, programId: number){
    return this.http.put<string>(`${this.baseURL}enroll`, null, {
      params: {
          username: username,
          programId: programId.toString()
      }
    });
  }


  onSubscribe(categoryName: string, username: string){
    return this.http.post<string>(this.baseURL + 'add/subscription'+'?categoryName=' + categoryName + '&username=' + username, {});
  }


  


}
