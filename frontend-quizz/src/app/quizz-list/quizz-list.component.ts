import { Component, OnInit } from '@angular/core';
import { RegistrationService, QuizzSession } from '../registration.service';
import { Router } from '@angular/router';
import { Quizz, QuizzService } from '../services/quizz.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-quizz-list',
  templateUrl: './quizz-list.component.html',
  styleUrls: ['./quizz-list.component.scss']
})
export class QuizzListComponent implements OnInit {

  currentSession: QuizzSession;

  quizzs$: Observable<Quizz[]>;

  constructor(private quizzService: QuizzService, private registrationService: RegistrationService, private router: Router) { }

  ngOnInit() {
    this.currentSession = this.registrationService.currentSession();
    if (!this.currentSession) {
      this.router.navigate(['']);
    }

    this.quizzs$ = this.quizzService.findAllQuizz();
  }

}
