package servlets;
import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FrontServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getRessource(request, response);
    }
    private void getRessource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        boolean ressourceExists = getServletContext().getResourceAsStream(path) != null;
        if (ressourceExists) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } else {
            response.getWriter().print(path);
        }
    }
}