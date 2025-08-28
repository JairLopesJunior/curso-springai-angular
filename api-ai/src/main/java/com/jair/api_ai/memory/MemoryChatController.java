package com.jair.api_ai.memory;

import com.jair.api_ai.chat.ChatMessage;
import com.jair.api_ai.chat.NewChatResponse;
import com.jair.api_ai.services.MemoryChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat-memory")
public class MemoryChatController {

    private final MemoryChatService chatService;

    public MemoryChatController(MemoryChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/{chatId}")
    ChatMessage simpleChat(@PathVariable String chatId, @RequestBody ChatMessage chatMessage) {
        String response = this.chatService.chat(chatMessage.message(), chatId);
        return new ChatMessage(response);
    }

    @PostMapping("/start")
    NewChatResponse startNewChat(@RequestBody ChatMessage chatMessage) {
        return this.chatService.createNewChat(chatMessage.message());
    }

    @GetMapping
    List<Chat> getAllChatsForUser() {
        return this.chatService.getAllChatsForUser();
    }

    @GetMapping
    List<com.jair.api_ai.memory.ChatMessage> getChatmessages(@PathVariable String chatId) {
        return this.chatService.getChatMessages(chatId);
    }
}



























