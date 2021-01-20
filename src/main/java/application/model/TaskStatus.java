package application.model;

public enum TaskStatus {

    CREATED("CREATED"),

    RUNNING("RUNNING"),

    DONE("DONE"),

    CANCELED("CANCELED");

    private final String literal;

    TaskStatus(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }
}
