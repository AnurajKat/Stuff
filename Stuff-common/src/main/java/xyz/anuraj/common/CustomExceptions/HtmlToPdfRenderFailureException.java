package xyz.anuraj.common.CustomExceptions;

public class HtmlToPdfRenderFailureException extends Exception{

    public HtmlToPdfRenderFailureException(String message) {
        super(String.format("Unable to render document for %s",message));
    }

    public HtmlToPdfRenderFailureException(String message, Throwable cause) {
        super(String.format("Unable to render document for %s",message), cause);
    }
}
