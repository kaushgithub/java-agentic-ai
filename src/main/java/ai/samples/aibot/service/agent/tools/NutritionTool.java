package ai.samples.aibot.service.agent.tools;

import ai.samples.aibot.service.agent.model.Meal;
import ai.samples.aibot.service.agent.model.MealPlanDraft;
import ai.samples.aibot.service.agent.model.NutritionSummary;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class NutritionTool {
    private final Logger logger = Logger.getLogger(getClass().getName());
        @Tool("calculate nutrition totals for a meal plan")
        public NutritionSummary calculateNutritionSummary(MealPlanDraft draft) {
            logger.info("Calculating nutrition summary for meal plan draft");
            int totalCalories = draft.meals().stream()
                    .mapToInt(Meal::calories)
                    .sum();
            int totalCarbs = draft.meals().stream()
                    .mapToInt(Meal::carbs)
                    .sum();
            int totalProtein = draft.meals().stream()
                    .mapToInt(Meal::protein)
                    .sum();
            int totalFat = draft.meals().stream()
                    .mapToInt(Meal::fat)
                    .sum();

            return new NutritionSummary(totalCalories, totalCarbs, totalProtein, totalFat);
        }
}
