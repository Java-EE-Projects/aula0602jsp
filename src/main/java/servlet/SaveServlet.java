package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Properties;

import java.io.IOException;

public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String key = request.getParameter("key");
			String value = request.getParameter("value");
			
			Properties.save(key, value);
			
			response.sendRedirect("/Props/List");
		} catch(Exception e) {
			// Logar erro e possivelmente retornar uma mensagem de erro ao usuário
			e.printStackTrace(); // Este é apenas um exemplo. Em um ambiente de produção, você deve logar erros de forma apropriada.
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar propriedade.");
		}
	}

}
