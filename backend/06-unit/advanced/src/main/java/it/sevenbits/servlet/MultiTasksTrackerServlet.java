package it.sevenbits.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.sevenbits.servlet.dto.request.AddTaskRequestDto;
import it.sevenbits.servlet.model.Task;
import it.sevenbits.servlet.repository.Repository;

/**
 * The type Multi tasks tracker.
 */
public class MultiTasksTrackerServlet extends UpgradedServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Repository repository = (Repository) this.getServletContext().getAttribute("repository");
        List<Task> tasks = new ArrayList<>(repository.getAllTasks());
        ObjectMapper objectMapper = new ObjectMapper();
        String allTasksInJson = objectMapper.writeValueAsString(tasks);
        writer.print(allTasksInJson);
        response.setStatus(HttpStatus.CODE_200.getHttpStatus());
        writer.flush();
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse response) throws IOException {
        String bodyText = this.getBodyText(req);
        ObjectMapper objectMapper = new ObjectMapper();
        AddTaskRequestDto request = objectMapper.readValue(bodyText, AddTaskRequestDto.class);
        Repository repository = (Repository) this.getServletContext().getAttribute("repository");
        String id = repository.addTask(new Task(request.getText()));
        response.setStatus(HttpStatus.CODE_201.getHttpStatus());
        response.setHeader("Content-Location", req.getServletPath() + "/" + id);
    }


}
