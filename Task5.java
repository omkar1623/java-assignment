import java.util.List;

public class Task5 {

    public ValidationResult validate(Document doc) {

        try {

            // FIX: Use IllegalArgumentException for expected validation failure
            if (doc == null) {
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            // FIX: Added null check before isEmpty()
            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {

            // FIX: Replaced printStackTrace with controlled logging
            System.out.println("Validation failed: " + e.getMessage());

            // FIX: Avoid returning null to prevent NullPointerException
            return new ValidationResult(false);

        } catch (Exception e) {

            // FIX: Log unexpected runtime exceptions properly
            System.out.println("Unexpected error: " + e.getMessage());

            return new ValidationResult(false);
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                // FIX: Added null check before calling isValid()
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {

                // FIX: Do not silently swallow exceptions
                System.out.println("Batch validation error: " + e.getMessage());
            }
        }
    }

    private ValidationResult runValidationRules(String content) {

        return new ValidationResult(true);
    }

    private void saveResult(ValidationResult result) {

        System.out.println("Result saved");
    }

    public static void main(String[] args) {

        System.out.println("Task5 compiled successfully");
    }
}

class Document {

    public String extractContent() {

        return "Sample Content";
    }
}

class ValidationResult {

    private boolean valid;

    public ValidationResult(boolean valid) {

        this.valid = valid;
    }

    public boolean isValid() {

        return valid;
    }
}