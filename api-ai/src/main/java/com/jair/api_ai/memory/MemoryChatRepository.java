package com.jair.api_ai.memory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoryChatRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemoryChatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String generateChatId(String userId, String description) {
        String sql = "INSERT INTO chat_memory (user_id, description) VALUES (?, ?) RETURNING conversation_id";
        return jdbcTemplate.queryForObject(sql, String.class, userId, description);
    }

    public List<Chat> getAllChartsForUser(String userId) {
        final String sql = "SELECT conversation_id, user_id, description FROM chat_memory WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, _) -> {
            String conversationId = rs.getString("conversation_id");
            String description = rs.getString("description");
            return new Chat(conversationId, description);
        }, userId);
    }

    public List<ChatMessage> getChatMessage(String chatId) {
        final String sql = "SELECT content, type FROM SPRING_AI_CHAT_MEMORY WHERE conversation_id = ? ORDER BY timestamp ASC";
        return jdbcTemplate.query(sql, (rs, _) ->
             new ChatMessage(rs.getString("content"), rs.getString("type")), chatId);
    }
}












































