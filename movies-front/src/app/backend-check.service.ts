import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { timer, Observable, interval, Subject, BehaviorSubject, of } from 'rxjs';
import { tap, map, mergeMap, timeout, catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

export type BackendState = 'BACKEND_UP' | 'BACKEND_DOWN';

@Injectable({
  providedIn: 'root'
})
export class BackendCheckService implements OnInit {

  backendStatusChanges$ = new BehaviorSubject<BackendState>('BACKEND_DOWN');

  constructor(private http: HttpClient) {
    interval(3000)
    .pipe(
      mergeMap(val => this.http.get(environment.backendUrl)
        .pipe(timeout(1000),
          map(res => ('BACKEND_UP')),
          catchError(err => of('BACKEND_DOWN')))))
    .subscribe(val => {
      this.backendStatusChanges$.next(val as BackendState);
    });
  }

  ngOnInit() {

  }
}
