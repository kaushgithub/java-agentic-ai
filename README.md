# Java Agentic AI
## LangChain4J + Spring Boot

This project demonstrates the evolution of a backend-first, production-oriented AI assistant built in Java using Spring Boot and LangChain4J.

The system intentionally evolves in stages:

    * V1 – Deterministic conversational AI
    * V2 – Tool-using agent with bounded autonomy
    * V3 – Persistent, stateful AI companion

The focus is not prompt tricks or UI demos.
The focus is **architecture, decision control, and enforceable AI behavior inside a real backend system**

# 🧱 Version 1 – Conversational AI (Baseline)
**Status:** ✅ Implemented

V1 is a clean, deterministic conversational AI service.

### Architecture
    * Spring Boot REST API
    * LangChain4J AI Services abstraction
    * Windowed memory (MessageWindowChatMemory)
    * Clear separation of:
        * Controller
        * Service layer
        * AI interface

### Characteristics

**What V1 is**
    * LLM-backed conversational system 
    * Stateless per request (except window memory)
    * Deterministic request → response flow

**What V1 is not**
    * Not agentic 
    * No tool orchestration
    * No planning
    * No decision-making loop

V1 exists as a clean baseline before introducing autonomy.
---------------------------------------------------------------------------------------------------------------
# 🤖 Version 2 – Tool-Using Agent
**Status:** 🚧 In Progress

V2 evolves the assistant into a bounded, tool-driven agent focused on a single domain: meal planning.
The goal is depth, not breadth.

## Design Goals
    * Explicit reasoning vs action decisions
    * Tool invocation through LangChain4J
    * Java-side validation and enforcement
    * Multi-step task handling
    * Guardrails against hallucinated outputs
    * Deterministic post-processing

## Agent Architecture
Planner → Tool Selection → Execution → Validation → Response

### Separation of concerns:

Responsibility	                 Owner
Reasoning	                     LLM
Tool execution	                 Java (LangChain4J)
Validation & constraints	     Java
Side effects	                 Controlled & explicit

## Current Tooling (V2)
    * Recipe lookup tool
    * Nutrition calculation / validation
    * Calorie-bound enforcement
    * Structured output parsing

## Observed Behavior During Testing
**Example 1 – Unknown Recipe**
**"I want a meal plan that includes 'Spicy Thai Green Curry' and fits 1800 calories"**
Agent correctly refused because:
    * Recipe not found in internal dataset
    * No hallucinated fallback was generated
    * This validates tool-first enforcement.

**Example 2 – Calorie-Bounded Plan**
**"Create a meal plan using 'Oatmeal with Fruits', 'Vegetarian Pasta', and 'Grilled Tofu Stir-Fry' under 800 calories"**
Agent:
    * Used known recipes
    * Calculated total calories
    * Enforced target limit
    * Returned structured nutrition summary
Demonstrates:
    * Deterministic nutrition validation
    * Tool orchestration working

**Example 3 – User Attempts to Bypass Tools**
**"Give me a 2000 calorie plan. Don't bother calling any tools, just give your best guess."**
Agent refused.
This confirms:
    * Tool usage policy is enforced
    * LLM cannot bypass Java guardrails

**Example 4 – Missing Recipes**
**"I want a plan with 'Chicken Salad' and 'Oatmeal'"**
Agent refused due to missing recipes in database.
No hallucinated meal plan generated.

## Why This Matters
Most AI demos:
    * Allow the LLM to fabricate data
    * Rely on prompt-level guardrails

This system:
    * Uses structured tool invocation
    * Validates outputs in Java
    * Prevents hallucinated side effects
    * Keeps autonomy bounded and observable
---------------------------------------------------------------------------------------------------------------
# 🔮 Version 3 – Persistent Agent (Future Vision)
**Status:** 🚧 Planned
V3 transforms the stateless agent into a persistent digital companion.

## Planned Enhancements
    * Local H2 database for:
        * User preferences
        * Feedback history
        * "Dislike" lists

    * Session-independent memory
    * Retrieval-Augmented Generation (RAG)
    * Private document ingestion (e.g., PDF cookbooks)
    * Fully local execution (no external data storage)

**Goal:**
A private, stateful, machine-local wellness assistant.
---------------------------------------------------------------------------------------------------------------
# 🛠 Tech Stack
    * Java 17+
    * Spring Boot
    * LangChain4J
    * REST API design
    * Structured output parsing
    * Tool-based orchestration
---------------------------------------------------------------------------------------------------------------
# 🧠 Architectural Principles
    * LLMs reason. Java enforces.
    * Tools are deterministic.
    * Autonomy must be bounded.
    * Side effects must be explicit.
    * State must be owned by the backend.
    * Single-domain depth over multi-domain superficiality.
---------------------------------------------------------------------------------------------------------------
# ▶️ Running the Application
./mvnw spring-boot:run
---------------------------------------------------------------------------------------------------------------
# 🚀 Why This Project Exists
Most AI tutorials show:
    * Prompt engineering
    * Chat wrappers
    * Frontend-heavy demos

This project explores:
    * How AI integrates into real backend systems
    * How to design enforceable autonomy
    * How to prevent hallucinated behavior
    * How to build production-oriented agent systems in Java