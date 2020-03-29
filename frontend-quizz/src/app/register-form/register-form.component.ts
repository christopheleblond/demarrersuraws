import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService, QuizzSession } from '../registration.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.scss']
})
export class RegisterFormComponent implements OnInit {

  registerForm: FormGroup;

  currentSession: QuizzSession;

  constructor(private registrationService: RegistrationService, private fb: FormBuilder, private router: Router) {
    this.registerForm = this.fb.group({
      username: new FormControl('', [Validators.required, Validators.minLength(3)])
    });
  }

  ngOnInit() {
    this.currentSession = this.registrationService.currentSession();
    if(this.currentSession) {
      if(this.currentSession.currentQuizz >= 0) {
        this.router.navigate(['quizz', this.currentSession.currentQuizz]);
      }else{
        this.router.navigate(['quizz'])
      }
    }
  }

  registerUser() {
    const user = this.registerForm.value['username'];
    console.log('Register !', user);

    this.registrationService.registerUser(user);

    this.router.navigate(['/quizz']);
  }
}
