package TestJavaCode.AuthApp.exception;

public class JwtExpirationException extends RuntimeException {
    public JwtExpirationException(String message) {
        super(message);
    }
}
