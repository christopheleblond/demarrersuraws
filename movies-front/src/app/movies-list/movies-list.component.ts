import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.scss']
})
export class MoviesListComponent implements OnInit {

  @Input() movies = [];

  coverBaseUrl = 'https://github.com/FEND16/movie-json-data/raw/master/img/';

  constructor() { }

  ngOnInit() {
  }

}
