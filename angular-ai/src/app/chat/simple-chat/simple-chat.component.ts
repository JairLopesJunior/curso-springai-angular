import { CommonModule, NgClass } from '@angular/common';
import { Component, OnInit, signal } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-simple-chat',
  standalone: true,
  imports: [
    CommonModule,
    MatCardModule,
    MatToolbarModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    FormsModule,
    NgClass
  ],
  templateUrl: './simple-chat.component.html',
  styleUrls: ['./simple-chat.component.css']
})
export class SimpleChatComponent implements OnInit {

  userInput = '';

  messages = signal([
    { text: 'Hello, How can I help you today?' , isBot: true}
  ]);

  constructor() { }

  ngOnInit() {
  }

  sendMessage(): void {
    this.trimUserMessage();
    if (this.userInput !== '') {
      this.updateMessages(this.userInput);
      this.userInput = '';
      this.simulateResponse();
    }
  }

  private updateMessages(text: string, isBot = false) {
    this.messages.update(messages => [...messages, { text: text, isBot: isBot }]);
  }

  private trimUserMessage(): void {
    this.userInput = this.userInput.trim();
  }

  private simulateResponse() {
    setTimeout(() => {
      const response = 'This is a simulated response from Chat AI';
      this.updateMessages(response, true);
    }, 2000);
  }
}
