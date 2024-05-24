package dev.nj.api.dictionaries;

public enum Status {
    NEW("NEW"),
    ASSIGNED("ASSIGNED"),
    IN_PROGRESS("IN PROGRESS"),
    CLOSED("CLOSED");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Status valueOfString(String value) {
        for (Status e : values()) {
            if (e.value.equalsIgnoreCase(value)) {
                return e;
            }
        }
        return null;
    }
}
