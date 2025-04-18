package dev.feryadialoi.fluenteither;

public class EitherException extends RuntimeException {
    public EitherException() {
        super();
    }

    public EitherException(String message) {
        super(message);
    }

    public EitherException(Throwable cause) {
        super(cause);
    }

    public EitherException(String message, Throwable cause) {
        super(message, cause);
    }
}
