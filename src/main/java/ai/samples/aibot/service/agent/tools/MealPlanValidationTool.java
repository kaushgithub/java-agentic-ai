package ai.samples.aibot.service.agent.tools;

import ai.samples.aibot.service.agent.model.Meal;
import ai.samples.aibot.service.agent.model.MealPlanDraft;
import ai.samples.aibot.service.agent.model.ValidationResult;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Component
public class MealPlanValidationTool {
    private final Logger logger = Logger.getLogger(getClass().getName());
    @Tool("Validate a meal plan. You must provide the draft, the target calories (e.g. 2000), and if it must be vegetarian.")
    public ValidationResult validateMealPlan(MealPlanDraft mealPlan,
                                             int targetCalories,
                                             boolean isVegetarian) {
        logger.info("Validating meal plan draft with target calories: " + targetCalories + " and vegetarian: " + isVegetarian);
        boolean valid = true;
        List<String> errors = new java.util.ArrayList<>();
        int totalCalories = mealPlan.meals().stream()
                .mapToInt(Meal::calories)
                .sum();
        if(totalCalories > targetCalories) {
            valid = false;
            errors.add("Total calories exceed the target of " + targetCalories);
        }
        if(isVegetarian && mealPlan.meals().stream().anyMatch(meal -> !meal.isVegetarian())) {
            valid = false;
            errors.add("Meal plan contains non-vegetarian meals");
        }
        return new ValidationResult(valid, errors);
    }
}
