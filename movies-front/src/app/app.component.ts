import { BackendCheckService, BackendState } from './backend-check.service';
import { Component, OnInit } from '@angular/core';
import { MoviesService } from './movies.service';
import { Movie } from './models';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'movies-front';
  state: BackendState;
  searchForm: FormGroup;
  results$: Observable<Movie[]>;

  constructor(private moviesService: MoviesService, private fb: FormBuilder, private backendCheckService: BackendCheckService) {
      this.searchForm = this.fb.group({
        search: this.fb.control(''),
        sort: this.fb.control('')
      });
  }

  ngOnInit() {
    this.results$ = this.moviesService.findAll();

    this.searchForm.valueChanges.subscribe(changes => {
      this.results$ = this.moviesService.searchMovies(changes);
    });

    this.backendCheckService.backendStatusChanges$.subscribe(state => this.state = state);
  }
}
