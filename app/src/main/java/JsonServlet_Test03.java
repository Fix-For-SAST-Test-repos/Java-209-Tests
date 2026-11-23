import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonServlet_Test03 extends HttpServlet {
    private final ObjectMapper mapper = new ObjectMapper();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Object obj = mapper.readTree(req.getReader());
            resp.getWriter().println("JSON parsed successfully");

        } catch (Exception e) {
            resp.getWriter().println("JSON parse failed: " + e.getMessage());
        }
    }
}
