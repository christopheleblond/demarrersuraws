import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

export interface Quizz {
  id?: number;
  title?: string;
}

@Injectable({
  providedIn: 'root'
})
export class QuizzService {

  constructor() { }

  findAllQuizz(): Observable<Quizz[]> {
    return of([
      {id: 1, title: 'Demo AWS'} as Quizz
    ]);
  }
}
