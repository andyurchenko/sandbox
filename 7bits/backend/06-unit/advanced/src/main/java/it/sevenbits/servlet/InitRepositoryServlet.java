package it.sevenbits.servlet;

import it.sevenbits.servlet.repository.Repository;
import it.sevenbits.servlet.repository.RepositoryImpl;
import javax.servlet.http.HttpServlet;

/**
 * The type Init repository servlet.
 */
public class InitRepositoryServlet extends HttpServlet {
    @Override
    public void init() {
        Repository repository = new RepositoryImpl();
        this.getServletContext().setAttribute("repository", repository);
    }
}
