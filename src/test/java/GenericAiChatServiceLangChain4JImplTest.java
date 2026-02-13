import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ai.samples.aibot.service.GenericAiChatServiceLangChain4JImpl;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GenericAiChatServiceLangChain4JImplTest {
    private GenericAiChatServiceLangChain4JImpl aiChatService;
    @Mock
    private ChatLanguageModel chatLanguageModel;

    private static final String VALID_PROMPT = "I need a keto meal plan.";
    private static final String AI_RESPONSE_TEXT = "Here is your keto meal plan...";
    private static final String INVALID_MESSAGE_FALLBACK = "Please provide a valid message.";
    private static final int METHOD_CALLED_ONCE = 1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // LangChain4j's AiServices builder is called in the constructor
        aiChatService = new GenericAiChatServiceLangChain4JImpl(chatLanguageModel);
    }

    @Test
    @Disabled
    @DisplayName("Should return AI response when a valid message is provided")
    void returnsAiResponseForValidMessage() {
        //Given
        when(chatLanguageModel.chat(VALID_PROMPT)).thenReturn(AI_RESPONSE_TEXT);

        //when
        String result = aiChatService.getAiAssistantResponse(VALID_PROMPT);

        //then
        assertNotNull(result);
        assertEquals(AI_RESPONSE_TEXT, result);
        verify(chatLanguageModel, times(METHOD_CALLED_ONCE)).chat(anyList());
    }

    @Test
    @DisplayName("Should return fallback message when input message is null")
    void returnsFallbackForNullMessage() {
        //when
        String result = aiChatService.getAiAssistantResponse(null);

        //then
        assertEquals(INVALID_MESSAGE_FALLBACK, result);
        verifyNoInteractions(chatLanguageModel);
    }

    @Test
    @DisplayName("Should return fallback message when input message is blank")
    void returnsFallbackForBlankMessage() {
        //when
        String result = aiChatService.getAiAssistantResponse("   ");

        //then
        assertEquals(INVALID_MESSAGE_FALLBACK, result);
        verifyNoInteractions(chatLanguageModel);
    }
}