package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Properties;

import java.io.IOException;


public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String key = request.getParameter("key");
		
		if(key != null) {
			String value = Properties.getValue(key);
			
			request.setAttribute("key", key);
			request.setAttribute("value", value);
		}
		
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
		
	}

}
