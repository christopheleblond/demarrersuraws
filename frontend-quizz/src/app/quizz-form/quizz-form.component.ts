import { Component, OnInit } from '@angular/core';
import { QuizzSession, RegistrationService } from '../registration.service';
import { QuizzService } from '../services/quizz.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-quizz-form',
  templateUrl: './quizz-form.component.html',
  styleUrls: ['./quizz-form.component.scss']
})
export class QuizzFormComponent implements OnInit {

  currentSession: QuizzSession;

  constructor(private quizzService: QuizzService, private registrationService: RegistrationService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.currentSession = this.registrationService.currentSession();
    if (!this.currentSession) {
      this.router.navigate(['']);
    }

    const quizzId = this.route.params['quizzId'];
    this.currentSession.currentQuizz = quizzId;

    this.registrationService.updateSession(this.currentSession);
  }

}
