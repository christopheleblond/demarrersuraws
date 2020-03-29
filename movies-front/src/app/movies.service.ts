import { Injectable } from '@angular/core';
import { Movie } from './models';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators'
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Movie[]> {
    return this.http.get<Movie[]>(environment.backendUrl + '/movies?sort=title');
  }

  searchMovies(criteria: {search: string, sort: string}): Observable<Movie[]> {
    return this.http.get<Movie[]>(environment.backendUrl + '/movies/search?q=' + criteria.search + '&sort=' + criteria.sort);
  }
}
