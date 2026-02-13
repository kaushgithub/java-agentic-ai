# Java Agentic AI (LangChain4J + Spring Boot)

This repository demonstrates an evolving **Java-based AI assistant** built using **Spring Boot** and **LangChain4J**.

The project intentionally starts with a **simple conversational AI (V1)** and incrementally evolves toward a **tool-using, agentic AI system (V2+)**.  
The focus is on **clean architecture, decision-making, and backend-friendly AI patterns**, not demo-level prompt hacks.

---

## 🧱 Version 1 – Conversational AI (Baseline)

**Status:** ✅ Implemented

Version 1 is a straightforward conversational AI service with the following characteristics:

- Spring Boot REST API
- LangChain4J **AI Services** abstraction
- Windowed chat memory (`MessageWindowChatMemory`)
- Prompt-driven responses
- Clean separation of controller, service, and AI layer

### What V1 is
- An LLM-backed conversational service
- Deterministic request → response flow

### What V1 is not
- Not agentic
- No tool orchestration
- No autonomous decision-making

This version serves as a **clean baseline** for further evolution.

---

## 🤖 Version 2 – Agentic AI with Tools (In Progress)

**Status:** 🚧 Planned / In Progress

Version 2 will evolve the system into a **goal-driven agent** capable of:

- Deciding when to reason vs. act
- Selecting and invoking tools
- Executing multi-step plans
- Validating outputs using deterministic Java logic
- Maintaining task-oriented memory

### Planned Agent Capabilities
- Tool-based execution (e.g., recipe lookup, nutrition validation)
- Planner → Executor loop
- Explicit decision-making policies
- Bounded autonomy and guardrails
- Clear separation between:
  - LLM reasoning
  - Java enforcement
  - Side effects

The agent will remain **single-domain focused** (meal planning) to emphasize depth over breadth.

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- LangChain4J
- RESTful API design

## Some results from various prompt testing against V2 code
1) I want a meal plan that includes 'Spicy Thai Green Curry' and fits 1800 calories -
I couldn't find a recipe for "Spicy Thai Green Curry" or any variations related to it. Therefore, I'm unable to include it in the meal plan. If you have another meal or a different type of cuisine in mind, please let me know, and I can create a meal plan based on that!

2) Create a meal plan using 'Oatmeal with Fruits', 'Vegetarian Pasta', and 'Grilled Tofu Stir-Fry' but keep the total target calories under 800 -

Here is your meal plan with a total of 700 calories, which is under your target of 800 calories:

### Meal Plan

1. **Oatmeal with Fruits**
   - **Calories:** 150
   - **Carbs:** 30g
   - **Protein:** 5g
   - **Fat:** 3g
   - **Ingredients:**
     - Oats
     - Milk or water
     - Banana
     - Berries
     - Honey
   - **Instructions:**
     1. Cook oats with milk or water according to package instructions.
     2. Slice the banana and prepare the berries.
     3. Top the cooked oatmeal with banana, berries, and a drizzle of honey.

2. **Vegetarian Pasta**
   - **Calories:** 300
   - **Carbs:** 60g
   - **Protein:** 10g
   - **Fat:** 8g
   - **Ingredients:**
     - Pasta
     - Tomato sauce
     - Bell peppers
     - Zucchini
     - Olive oil
     - Garlic
   - **Instructions:**
     1. Cook the pasta according to package instructions.
     2. Sauté bell peppers, zucchini, and garlic in olive oil until tender.
     3. Add tomato sauce to the vegetables and simmer for 10 minutes.
     4. Toss the cooked pasta with the sauce and serve.

3. **Grilled Tofu Stir-Fry**
   - **Calories:** 250
   - **Carbs:** 20g
   - **Protein:** 15g
   - **Fat:** 10g
   - **Ingredients:**
     - Tofu
     - Broccoli
     - Carrots
     - Bell peppers
     - Soy sauce
     - Garlic
     - Ginger
   - **Instructions:**
     1. Press and cube the tofu.
     2. Sauté garlic and ginger in a pan with olive oil.
     3. Add tofu and cook until golden brown.
     4. Add broccoli, carrots, and bell peppers and stir-fry until tender.
     5. Pour soy sauce over the stir-fry and mix well before serving.

### Nutrition Summary
- **Total Calories:** 700
- **Total Carbs:** 110g
- **Total Protein:** 30g
- **Total Fat:** 21g

This meal plan is vegetarian-friendly and meets your calorie requirements. Enjoy your meals!

3) Give me a 2000 calorie plan. Don't bother calling any tools, just give me your best guess to save time -
Unfortunately, I was unable to find valid recipes for the meals in the initial plan or for any alternative meals. This limits my ability to provide you with a complete meal plan.

Given this situation, I can suggest that you create your own meal plan using available recipes or ingredients you have on hand. If you have specific meals in mind or different dietary preferences, please let me know, and I can assist you in a different way.

4) I want a plan with the 'Chicken Salad' and 'Oatmeal' -
It appears that I am unable to find recipes for both "Chicken Salad" and "Oatmeal" in the database. Please provide alternative meal options, and I will create a new meal plan based on your preferences.

---

## 🤖 Version 3 – The Persistent Agent (Future Vision)
**Status:** 🚧 Future Vision
V3 transforms the agentic behavior from a stateless calculator into a stateful digital companion that actually learns who you are. By integrating a local H2 database or something similar, the chef agent will now remember your feedback and 'hate-lists' across every session, while a local RAG engine allows it to 'read' your own private PDF cookbooks—providing a 100% private, hyper-personalized wellness experience that lives entirely on your machine.

## ▶️ Running the Application

```bash
./mvnw spring-boot:run
