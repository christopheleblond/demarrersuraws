import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterFormComponent } from './register-form/register-form.component';
import { QuizzListComponent } from './quizz-list/quizz-list.component';
import { QuizzFormComponent } from './quizz-form/quizz-form.component';


const routes: Routes = [
  {path: '', component: RegisterFormComponent},
  {path: 'quizz', component: QuizzListComponent},
  {path: 'quizz/:quizzid', component: QuizzFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
