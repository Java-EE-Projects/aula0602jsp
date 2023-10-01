package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Properties;

import java.io.IOException;
import java.util.Map;


public class ListServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map<String, String> props = Properties.getProperties();
		request.setAttribute("props", props);
		
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
	}

}
