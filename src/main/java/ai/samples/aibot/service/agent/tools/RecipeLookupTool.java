package ai.samples.aibot.service.agent.tools;

import ai.samples.aibot.service.agent.model.Recipe;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class RecipeLookupTool {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final Map<String, Recipe> recipeDB = Map.of(
        "Grilled Chicken Salad", new Recipe(
            "Grilled Chicken Salad",
            List.of("Chicken breast", "Lettuce", "Tomatoes", "Cucumbers", "Olive oil", "Lemon juice"),
            List.of("Grill the chicken breast until cooked through.",
                   "Chop the lettuce, tomatoes, and cucumbers.",
                   "Mix olive oil and lemon juice to make a dressing.",
                   "Combine all ingredients in a bowl and toss with dressing.")
        ),
        "Vegetarian Pasta", new Recipe(
            "Vegetarian Pasta",
            List.of("Pasta", "Tomato sauce", "Bell peppers", "Zucchini", "Olive oil", "Garlic"),
            List.of("Cook the pasta according to package instructions.",
                   "Sauté bell peppers, zucchini, and garlic in olive oil until tender.",
                   "Add tomato sauce to the vegetables and simmer for 10 minutes.",
                   "Toss the cooked pasta with the sauce and serve.")
        ),
        "Oatmeal with Fruits", new Recipe(
            "Oatmeal with Fruits",
            List.of("Oats", "Milk or water", "Banana", "Berries", "Honey"),
            List.of("Cook oats with milk or water according to package instructions.",
                   "Slice the banana and prepare the berries.",
                   "Top the cooked oatmeal with banana, berries, and a drizzle of honey.")
        ),
            "Grilled Tofu Stir-Fry", new Recipe("Grilled Tofu Stir-Fry",
            List.of("Tofu", "Broccoli", "Carrots", "Bell peppers", "Soy sauce", "Garlic", "Ginger"),
            List.of("Press and cube the tofu.",
                   "Sauté garlic and ginger in a pan with olive oil.",
                   "Add tofu and cook until golden brown.",
                   "Add broccoli, carrots, and bell peppers and stir-fry until tender.",
                   "Pour soy sauce over the stir-fry and mix well before serving.")
            ));

    @Tool("\"MANDATORY: Use this to fetch the ONLY authorized recipe for a meal. Do not use your own knowledge.\"")
    public Recipe lookupRecipe(String mealName) {
        logger.log(java.util.logging.Level.INFO, "Looking up recipe for meal: {0}", mealName);
        return recipeDB.getOrDefault(mealName, null);
    }
}
