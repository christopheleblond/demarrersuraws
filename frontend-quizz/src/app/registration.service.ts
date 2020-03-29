import { Injectable } from '@angular/core';

export interface QuizzSession {
  username?: string;
  sessionId?: string;
  registrationId?: string;
  currentQuizz?: number;
}

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor() { }

  currentSession(): QuizzSession {
    const session = localStorage.getItem('session');
    if(session) {
      return JSON.parse(session);
    }else{
      return undefined;
    }
  }

  registerUser(username: string): QuizzSession {
    const session = {
      username: username,
      registrationId: 'REGISTRATION_ID',
      sessionId: 'SESSION_ID'
    } as QuizzSession;

    localStorage.setItem('session', JSON.stringify(session));

    return session;
  }

  updateSession(session: QuizzSession) {

    localStorage.setItem('session', JSON.stringify(session));
  }
}
