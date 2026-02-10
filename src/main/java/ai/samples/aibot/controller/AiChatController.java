package ai.samples.aibot.controller;

import ai.samples.aibot.model.ChatPayload;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public interface AiChatController {
    @PostMapping("/v1.0/chat")
    ResponseEntity<String> chat(
            @Parameter(required = true, schema = @Schema(implementation = ChatPayload.class))
            @RequestBody @Valid ChatPayload chatPayload);
}
