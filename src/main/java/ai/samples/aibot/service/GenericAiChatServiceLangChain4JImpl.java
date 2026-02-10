package ai.samples.aibot.service;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GenericAiChatServiceLangChain4JImpl implements GenericAiChatService {
    private final GenericAiAssistant assistant;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public GenericAiChatServiceLangChain4JImpl(ChatLanguageModel chatModel) {
        this.assistant = AiServices.builder(GenericAiAssistant.class)
                .chatLanguageModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }
    @Override
    public String getAiAssistantResponse(String message) {
        if(message == null || message.isBlank()){
            return "Please provide a valid message.";
        }
        var chatResponse = assistant.chat(message);
        logger.log(Level.INFO,  "AI Response: {0}", chatResponse);
        return chatResponse;
    }
}
