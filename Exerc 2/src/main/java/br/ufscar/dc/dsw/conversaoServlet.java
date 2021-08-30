package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/conversaoServlet"})
public class conversaoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response, String metodo)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet conversaoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            String requestURL = request.getRequestURL().toString();
            String protocol = request.getProtocol();
            int port = request.getLocalPort();
            String queryString = request.getQueryString();
            
            Map<String, String[]> mapaDeParametros = request.getParameterMap();
            Set<Entry<String, String[]>> conjuntoDeParametros = mapaDeParametros.entrySet();
 
            
			String minValue = request.getParameter("minValue");
			int min = (minValue == null || minValue.isEmpty()) ? -100 : Integer.parseInt(minValue);
			
			String maxValue = request.getParameter("maxValue");
			int max = (maxValue == null || maxValue.isEmpty()) ? 100 : Integer.parseInt(maxValue);
			
			String incValue = request.getParameter("incValue");
			int inc = (incValue == null || incValue.isEmpty()) ? 5 : Integer.parseInt(incValue);
			
			out.println("<table border = 1>");
			out.println("<tr>");
			out.println("<th>Celsius</th>");
			out.println("<th>Fahrenheit</th>");
			out.println("</tr>");
			for (int celsius = min; celsius<=max; celsius += inc) {
				double fahr= 1.8 * celsius + 32;
				out.println("<tr>");
				out.println("<td>" + celsius + "</td>");
				out.println("<td>" + fahr + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");

            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response, "POST");
    }
}
