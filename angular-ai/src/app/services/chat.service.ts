import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChatResponse } from '../models/chat-response';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private readonly API = '/api/chat/simple-chat';

  private http = inject(HttpClient);

  sendChatMessage(message: string): Observable<ChatResponse> {
    return this.http.post<ChatResponse>(this.API, { message });
  }
}
