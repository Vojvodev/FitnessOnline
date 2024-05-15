import { Injectable, OnInit } from '@angular/core';
import { Comments } from '../models/comment.model';

@Injectable({
  providedIn: 'root'
})
export class CommentsListService{
  private commentsList: Comments[];

  constructor() { }

  getCommentsList() : Comments[] {
    return this.commentsList;
  }

  setCommentsList(list: Comments[]){
    this.commentsList = list;
  }
}
