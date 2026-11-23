import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SystemPropertyServlet_Test05 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/plain");
        try {
            throw new RuntimeException("Forced failure");
        } catch (Exception e) {

            response.getWriter().println("Error occurred: " + e.getMessage());
        }
    }
}
