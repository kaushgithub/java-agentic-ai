package ai.samples.aibot.config;

import dev.langchain4j.model.azure.AzureOpenAiChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GenerativeAiConfig {
    private static final String AZURE_OPEN_API_ENDPOINT = "***";
    private static final String AZURE_OPEN_API_KEY = "****";
    private static final String AZURE_OPEN_API_MODEL_DEPLOYMENT_NAME = "*****";
    @Bean
    public ChatLanguageModel azureChatModel() {
        return AzureOpenAiChatModel.builder()
                .endpoint(AZURE_OPEN_API_ENDPOINT)
                .apiKey(AZURE_OPEN_API_KEY)
                .deploymentName(AZURE_OPEN_API_MODEL_DEPLOYMENT_NAME)
                .logRequestsAndResponses(false)
                .build();
    }
}
