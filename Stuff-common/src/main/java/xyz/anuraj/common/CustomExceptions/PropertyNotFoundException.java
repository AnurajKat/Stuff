package xyz.anuraj.common.CustomExceptions;

public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException(String errorProperty) {
        super(String.format("Property not found: %s",errorProperty),
                new Throwable(String.format("Failure due to missing property %s",errorProperty)));
    }
}
