package nl.hu.v1wac.firstapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/DynamicServletCalculator.do")
public class DynamicServletCalculator extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nummer1 = req.getParameter("number1");
		String nummer2 = req.getParameter("number2");
		
		double nummer11 = Double.parseDouble(nummer1);
		double nummer22 = Double.parseDouble(nummer2);
		
		double antwoord = 0.0;
		
		if (req.getParameter("knop").equals("Plus")) {
			antwoord = nummer11 + nummer22;
		}
		
		if (req.getParameter("knop").equals("Min")) {
			antwoord = nummer11 - nummer22;
		}
		
		if (req.getParameter("knop").equals("Keer")) {
			antwoord = nummer11 * nummer22;
		}
		
		if (req.getParameter("knop").equals("Delen")) {
			antwoord = nummer11 / nummer22;
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <title>Dynamic Example</title>");
		out.println(" <body>");
		out.println(" <h2>Dynamic webapplication example</h2>");
		out.println(" <h2>Het antwoord is: " + antwoord + "!</h2>");
		out.println(" </body>");
		out.println("</html>");
	}
}