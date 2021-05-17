package dl.rest.com

public class TestException extends RuntimeException {
	TestException(String message) {
		super(message)
	}

	TestException(String message, Throwable cause) {
		super(message, cause)
	}

	TestException(Throwable cause) {
		super(cause)
	}
}
