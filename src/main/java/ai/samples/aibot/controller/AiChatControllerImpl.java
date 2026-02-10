package ai.samples.aibot.controller;

import ai.samples.aibot.model.ChatPayload;
import ai.samples.aibot.service.GenericAiChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AiChatControllerImpl implements AiChatController {

    private final GenericAiChatService genericAiChatService;

    public AiChatControllerImpl(GenericAiChatService weatherChatService) {
        this.genericAiChatService = weatherChatService;
    }
    @Override
    public ResponseEntity<String> chat(ChatPayload chatPayload) {
        return genericAiChatService.getAiAssistantResponse(chatPayload.message()) != null ?
                ResponseEntity.ok(genericAiChatService.getAiAssistantResponse(chatPayload.message())) :
                ResponseEntity.badRequest().body("Unable to get a response from the weather assistant.");
    }
}
