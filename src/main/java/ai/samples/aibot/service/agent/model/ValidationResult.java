package ai.samples.aibot.service.agent.model;

import java.util.List;

public record ValidationResult(boolean isValid, List<String> errors) {
}
