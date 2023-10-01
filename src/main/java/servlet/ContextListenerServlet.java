package servlet;

import java.io.IOException;
import java.io.InputStream;

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

        try (InputStream input = sc.getResourceAsStream("/WEB-INF/props.txt")) {
            if (input == null) {
                throw new IOException("Não foi possível obter o stream para /WEB-INF/props.txt");
            }
            Properties.loadProperties(input);

        } catch (Exception e) {
            sc.log("Erro ao inicializar as propriedades", e);
        }

    }
}
