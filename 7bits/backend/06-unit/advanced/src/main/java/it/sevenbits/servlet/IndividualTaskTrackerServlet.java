package it.sevenbits.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.sevenbits.servlet.dto.request.UpdateTaskStatusRequestDto;
import it.sevenbits.servlet.model.Task;
import it.sevenbits.servlet.repository.Repository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The type Individual task tracker.
 */
public class IndividualTaskTrackerServlet extends UpgradedServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse response) throws IOException {
        String taskId = getIdFromPathInfo(req.getPathInfo());
        Repository repository = (Repository) getServletContext().getAttribute("repository");
        Task task = repository.getTaskById(taskId);
        if (task == null) {
            response.setStatus(HttpStatus.CODE_404.getHttpStatus());
        } else {
            response.setStatus(HttpStatus.CODE_200.getHttpStatus());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            writer.write(objectMapper.writeValueAsString(task));
        }
    }

    @Override
    protected void doDelete(final HttpServletRequest req, final HttpServletResponse resp) {
        Repository repository = (Repository) getServletContext().getAttribute("repository");
        String taskIdToDelete = getIdFromPathInfo(req.getPathInfo());
        if (!repository.deleteTask(taskIdToDelete)) {
            resp.setStatus(HttpStatus.CODE_404.getHttpStatus());
            return;
        }

        resp.setStatus(HttpStatus.CODE_200.getHttpStatus());

    }

    @Override
    protected void doPatch(final HttpServletRequest request, final HttpServletResponse response) {
        String taskIdToUpdate = getIdFromPathInfo(request.getPathInfo());
        Repository repository = (Repository) getServletContext().getAttribute("repository");
        Task taskToUpdate = repository.getTaskById(taskIdToUpdate);
        if (taskToUpdate == null) {
            response.setStatus(HttpStatus.CODE_404.getHttpStatus());
            return;
        }

        String bodyText = getBodyText(request);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UpdateTaskStatusRequestDto requestDto = objectMapper.readValue(bodyText, UpdateTaskStatusRequestDto.class);
            taskToUpdate.setStatus(requestDto.getStatus());
            response.setStatus(HttpStatus.CODE_200.getHttpStatus());
        } catch (JsonProcessingException e) {
            response.setStatus(HttpStatus.CODE_400.getHttpStatus());
        }
    }
}
