package it.sevenbits.servlet;

/**
 * The enum Http status.
 */
public enum HttpStatus {
    /**
     * Code 200 http status.
     */
    CODE_200(200),
    /**
     * Code 201 http status.
     */
    CODE_201(201),
    /**
     * Code 400 http status.
     */
    CODE_400(400),
    /**
     * Code 403 http status.
     */
    CODE_403(403),
    /**
     * Code 404 http status.
     */
    CODE_404(404),
    /**
     * Code 405 http status.
     */
    CODE_405(405),
    /**
     * Code 406 http status.
     */
    CODE_406(406),
    /**
     * Code 418 http status.
     */
    CODE_418(418),
    ;

    private final int httpStatus;

    /**
     *
     * @param httpStatus httpStatus
     */
    HttpStatus(final int httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * Gets http status.
     *
     * @return the http status
     */
    public int getHttpStatus() {
        return httpStatus;
    }
}
