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

---

## ▶️ Running the Application

```bash
./mvnw spring-boot:run
