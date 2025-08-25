import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'simple-chat' , pathMatch: 'full'},
  { path: 'simple-chat', loadComponent: () => import('./chat/simple-chat/simple-chat.component').then(m => m.SimpleChatComponent)},
  { path: '**', redirectTo: 'simple-chat' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
