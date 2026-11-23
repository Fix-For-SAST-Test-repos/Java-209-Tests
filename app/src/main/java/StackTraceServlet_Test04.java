import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class StackTraceServlet_Test04 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/plain");
        try {
            int result = 1 / 0;
        } catch (Exception e) {

            e.printStackTrace(response.getWriter());
        }
    }
}
