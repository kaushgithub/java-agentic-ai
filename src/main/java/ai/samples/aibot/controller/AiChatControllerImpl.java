package ai.samples.aibot.controller;

import ai.samples.aibot.model.ChatPayload;
import ai.samples.aibot.service.GenericAiChatService;
import ai.samples.aibot.service.agent.GenericAgenticAiChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AiChatControllerImpl implements AiChatController {

    private final GenericAiChatService genericAiChatService;
    private final GenericAgenticAiChatService genericAgenticAiChatService;

    public AiChatControllerImpl(GenericAiChatService genericAiChatService, GenericAgenticAiChatService genericAgenticAiChatService){
        this.genericAiChatService = genericAiChatService;
        this.genericAgenticAiChatService = genericAgenticAiChatService;
    }
    @Override
    public ResponseEntity<String> chat(ChatPayload chatPayload) {
        return genericAiChatService.getAiAssistantResponse(chatPayload.message()) != null ?
                ResponseEntity.ok(genericAiChatService.getAiAssistantResponse(chatPayload.message())) :
                ResponseEntity.badRequest().body("Unable to get a response from the weather assistant.");
    }

    @Override
    public ResponseEntity<String> generateMealPlan(ChatPayload chatPayload) {
        String response = genericAgenticAiChatService.getAiAssistantResponse(chatPayload.message());
        return response != null ?
                ResponseEntity.ok(response) :
                ResponseEntity.badRequest().body("Unable to generate a meal plan.");
    }
}
