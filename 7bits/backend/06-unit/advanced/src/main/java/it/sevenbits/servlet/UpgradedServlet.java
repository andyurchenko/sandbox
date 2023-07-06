package it.sevenbits.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Upgraded servlet.
 */
public abstract class UpgradedServlet extends HttpServlet {

    @Override
    public void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equalsIgnoreCase("PATCH")) {
            doPatch(request, response);
        } else {
            super.service(request, response);
        }
    }

    /**
     * Do patch.
     *
     * @param request  the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException      the io exception
     */
    protected void doPatch(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Gets body text.
     *
     * @param req the req
     * @return the body text
     */
    protected String getBodyText(final HttpServletRequest req) {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            //TODO сделать обработку исключения
        }

        return sb.toString();
    }

    /**
     * Gets id from path info.
     *
     * @param path the path
     * @return the id from path info
     */
    protected String getIdFromPathInfo(final String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < path.length() && path.charAt(i) != '/'; i++) {
            sb.append(path.charAt(i));
        }

        return sb.toString();
    }
}
