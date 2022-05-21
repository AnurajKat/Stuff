package xyz.anuraj.common.CustomExceptions;

public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException(String errorProperty) {
        super(String.format("Property not found: %s",errorProperty));
    }
}
