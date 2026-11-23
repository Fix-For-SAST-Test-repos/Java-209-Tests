import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AuthServlet_Test02 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String user = req.getParameter("username");
            String pass = req.getParameter("password");

            if (!"admin".equals(user) || !"secret".equals(pass)) {
                throw new SecurityException("Invalid credentials for user=" + user);
            }
            resp.getWriter().println("Login successful!");
        } catch (SecurityException e) {

            resp.getWriter().println("Authentication failed: " + e.getMessage());
        }
    }
}
