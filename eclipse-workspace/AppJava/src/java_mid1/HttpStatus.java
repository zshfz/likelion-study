package java_mid1;

public enum HttpStatus {
	OK(200, "OK"), BAD_REQUEST(400, "Bad Request"), NOT_FOUND(404, "Not found"),
	INTERNAL_SERVER_ERROR(500, "internal server error");

	private int code;
	private String message;

	HttpStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static HttpStatus findByCode(int code) {
		for (HttpStatus status : values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		return null;
	}

	public boolean isSuccess() {
		return code >= 200 && code <= 299;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
