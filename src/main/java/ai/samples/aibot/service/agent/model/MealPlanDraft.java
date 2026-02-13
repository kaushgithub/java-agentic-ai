package ai.samples.aibot.service.agent.model;

import java.util.List;

public record MealPlanDraft(List<Meal> meals, Integer totalCalories, Integer totalCarbs, Integer totalProtein, Integer totalFat) {
}
