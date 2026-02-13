package ai.samples.aibot.service.agent.model;

public record Meal(String Name,
                   int calories,
                   int carbs,
                   int protein,
                   int fat,
                   boolean isVegetarian) {
}
