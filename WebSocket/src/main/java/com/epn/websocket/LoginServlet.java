
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String REST_URL = "http://localhost:8081/clase-rest/api/auth/login";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Construir JSON
        JsonObject json = Json.createObjectBuilder()
                .add("usuario", username.trim())
                .add("password", password.trim())
                .build();

        
        
        // Crear cliente
        Client client = ClientBuilder.newClient();

        // Hacer POST asegurando UTF-8 y cabeceras correctas
        Response response = client.target(REST_URL)
                .request(MediaType.APPLICATION_JSON) // header Accept
                .post(Entity.entity(json.toString(), MediaType.APPLICATION_JSON_TYPE.withCharset("UTF-8")));

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (response.getStatus() == 200) {
            String token = response.readEntity(String.class);
            out.println("<h3>Login exitoso</h3>");
            out.println("<p>Token: " + token + "</p>");
            
             req.getSession().setAttribute("token", token);
             resp.sendRedirect("index.html");
        } else {
            String error = response.readEntity(String.class);
            out.println("<h3>Error en login</h3>");
            out.println("<p>" + error + "</p>");
        }

        response.close();
        client.close();
    }
}

