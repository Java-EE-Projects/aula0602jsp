package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Properties;

import java.io.IOException;

public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		
		Properties.save(key, value);
		
		response.sendRedirect("/Props/List");
	}

}
