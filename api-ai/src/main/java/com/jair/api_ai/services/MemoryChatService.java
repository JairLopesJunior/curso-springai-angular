package com.jair.api_ai.services;

import com.jair.api_ai.chat.ChatMessage;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class MemoryChatService {

    private final ChatClient chatClient;

    public MemoryChatService(ChatClient.Builder builder,
                             ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                )
                .build();
    }

    public String memoryChat(String message) {
        return this.chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}



























