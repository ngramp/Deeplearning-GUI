package client;

/**
 * Created by gram on 28/03/16.
 */
public enum Status {
    NOT_CONFIGURED ("Not configured."),
    CONFIGURED ("Configured."),
    CONFIGURING ("Configuring.");

    private final String name;

    Status(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
