package ai.samples.aibot.service.agent.model;

import java.util.List;

public record Recipe(String mealName, List<String> ingredients, List<String> instructions) {
}
