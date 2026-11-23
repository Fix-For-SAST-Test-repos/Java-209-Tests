import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class StackTraceServlet_Test01 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String num = req.getParameter("num");
            int result = 100 / Integer.parseInt(num);
            resp.getWriter().println("Result: " + result);
        } catch (Exception e) {

            e.printStackTrace(resp.getWriter());
        }
    }
}
