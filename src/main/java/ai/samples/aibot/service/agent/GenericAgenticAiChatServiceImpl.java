package ai.samples.aibot.service.agent;

import ai.samples.aibot.service.MealPlanningAgent;
import ai.samples.aibot.service.agent.tools.MealPlanValidationTool;
import ai.samples.aibot.service.agent.tools.NutritionTool;
import ai.samples.aibot.service.agent.tools.RecipeLookupTool;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.springframework.stereotype.Service;

@Service
public class GenericAgenticAiChatServiceImpl implements GenericAgenticAiChatService{
    private final MealPlanningAgent mealPlanningAgent;

    public GenericAgenticAiChatServiceImpl(ChatLanguageModel chatLanguageModel,
                                           NutritionTool nutritionTool,
                                           MealPlanValidationTool mealPlanValidationTool,
                                           RecipeLookupTool recipeLookupTool) {
        this.mealPlanningAgent = AiServices.builder(MealPlanningAgent.class)
                .chatLanguageModel(chatLanguageModel)
                .tools(nutritionTool, mealPlanValidationTool, recipeLookupTool)
                .build();
    }

    @Override
    public String getAiAssistantResponse(String message) {
        return mealPlanningAgent.plan(message);
    }
}
