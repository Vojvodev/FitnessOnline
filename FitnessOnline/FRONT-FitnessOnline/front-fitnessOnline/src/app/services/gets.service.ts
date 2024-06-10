import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { map } from "rxjs";
import { Injectable } from "@angular/core";
import { Program } from "../models/program.model";
import { Category } from "../models/category.model";
import { NgForm } from "@angular/forms";
import { Comments } from "../models/comment.model";
import { User } from "../models/user.model";
import { News } from "../models/news.model";
import { Excercises } from "../models/excercises.model";

@Injectable({
    providedIn: 'root'
  })
export class GetsService{
    private baseURL = 'http://localhost:8080/api/v1/';

    constructor(private http: HttpClient){}


    getCommenterByCommentId(id: number){
        return this.http.get<string>(this.baseURL + 'commenter', 
        {
            params:{
                id: id.toString()
            },
            responseType: 'text' as 'json'
        });
    }


    fetchAllComments(programId: string){
        return this.http.get<Comments[]>(this.baseURL + 'comments', 
        {
            params:{
                programId: programId
            }
        })
        .pipe(map(response => {
            const commentArray = [];
            for(const key in response){
                commentArray.push({...response[key]});
            }
            return commentArray;
        }));
    }


    searchPrograms(searchFor: string, page: number, size: number){
        const params = new HttpParams()
            .set('searchFor', searchFor)
            .set('page', page.toString())
            .set('size', size.toString());

        return this.http.get<any>(this.baseURL + 'search', { params})
        .pipe(map( (response) => response.content ));
    
    }


    fetchAllProgramsRaw(){
        return this.http.get<Program[]>(this.baseURL + 'programs-raw')
            .pipe(map(response => {
                const planArray = [];
                for(const key in response){
                    planArray.push({...response[key]});
                }
                return planArray;
            }));
    }


    fetchAllPrograms(page: number, size: number){
        return this.http.get<Program[]>(this.baseURL + 'programs', {
            params: {
                page: page,
                size: size
            }
        })
        .pipe(map(response => {
            const planArray = [];
            for(const key in response){
                planArray.push({...response[key]});
            }
            return planArray;
        }));
    }


    fetchAllProgramsSorted(direction: string, field: string, page: number, size: number){
        return this.http.get<Program[]>(this.baseURL + 'programs/sorted', {
            params: {
                direction: direction,
                field: field,
                page: page,
                size: size
            }
        })
        .pipe(map(response => {
            const planArray = [];
            for(const key in response){
                planArray.push({...response[key]});
            }
            return planArray;
        }));
    }
    

    fetchAllProgramsFiltered(form: NgForm, page: number, size: number){
        if(form.value.category === ''){
            form.value.category = 'xxx';
        }
        if(form.value.difficulty === ''){
            form.value.difficulty = 'xxx';
        }
        if(form.value.location === ''){
            form.value.location = 'xxx';
        }
        if(form.value.price1 === ''){
            form.value.price1 = '999999';
        }
        if(form.value.price2 === ''){
            form.value.price2 = '999999';
        }

        return this.http.get<Program[]>(this.baseURL + 'programs/filtered', {
            params: {
                categoryName:   form.value.category,
                difficulty:     form.value.difficulty,
                location:       form.value.location,
                price1:         form.value.price1,
                price2:         form.value.price2,
                page:           page,
                size:           size
            }
        })
        .pipe(map(response => {
            const planArray = [];
            for(const key in response){
                planArray.push({...response[key]});
            }
            return planArray;
        }));
        
    } 

    
    fetchAllProgramsFilteredByCategory(categoryName: string, page: number, size: number){
        return this.http.get<Program[]>(this.baseURL + 'programs/filtered', {
            params: {
                categoryName:   categoryName,
                difficulty:     '',
                location:       '',
                price1:         '',
                price2:         '',
                page:           page.toString(),
                size:           size.toString()
            }
        })
        .pipe(map(response => {
            const planArray = [];
            for(const key in response){
                planArray.push({...response[key]});
            }
            return planArray;
        }));
    }


    fetchAllCategories(page: number, size: number){
        return this.http.get<Category[]>(this.baseURL + 'categories', {
            params: {
                page: page,
                size: size
            }
        })
        .pipe(map(response => {
            const categoryArray = [];
            for(const key in response){
                categoryArray.push({...response[key]});
            }
            return categoryArray;
        }));
    }



    fetchUserByUsername(username: string){
        return this.http.get<User>(this.baseURL + 'user', { params: {username: username}});
    }


    fetchNews(){
        return this.http.get<News[]>(this.baseURL + 'rss-feed')
            .pipe(map(response => {
                const newsArray = [];
                for(const key in response){
                    newsArray.push({...response[key]});
                }
                return newsArray;
            }));
    }

    fetchExcercises(APIKey: string){
        const headers = new HttpHeaders({
            'x-api-key': APIKey
          });

        return this.http.get<Excercises[]>('https://api.api-ninjas.com/v1/exercises', { headers })
            .pipe(map(response => {
                const excercisesArray = [];
                for(const key in response){
                    excercisesArray.push({...response[key]});
                }
                return excercisesArray;
            }));
    }


    fetchEnrolledPrograms(username: string){
        return this.http.get<Program[]>(this.baseURL + 'get-enrolled-programs', { params: {username: username}})
        .pipe(map(response => {
            const programArray = [];
            for(const key in response){
                programArray.push({...response[key]});
            }
            return programArray;
        }));
    }


    fetchCreatedPrograms(username: string){
        return this.http.get<Program[]>(this.baseURL + 'get-created-programs', { params: {username: username}})
        .pipe(map(response => {
            const programArray = [];
            for(const key in response){
                programArray.push({...response[key]});
            }
            return programArray;
        }));
    }

}