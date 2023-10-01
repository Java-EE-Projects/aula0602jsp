package servlet;

import java.io.IOException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Properties;

@WebListener
public class ContextListenerServlet implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Properties.setServletContext(sc);
        // Agora você pode carregar propriedades
        try {
            Properties.loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
