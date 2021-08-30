<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<body>
    <h1>Conversao</h1>
    
    <h1> <%= new Date() %></h1>
    
    <% if minimo == "")
		{
			minimo = "-100";
		}

		if (maximo == "")
		{
			maximo = "-100";
		}

		if (incremento == "")
		{
			incremento = "5";
		}

		else {
			float F = 0;
			float C = Float.parseFloat(minimo);
			float maximo = Float.parseFloat(maximo);
			float incremento = Float.parseFloat(incremento);

			out.println("<table><tr><td>Celcius</td><td>Fahrenheit</td></tr>")

			while(celcius < max){
				fahrenheit = celcius * 1.80 + 32; 
				out.println("<tr><td>" + celcius + "</td><td>" + fahrenheit + "</td></tr>")				
				celcius = celcius + incremento;
			}

			out.println("</table>")
			}
		}
    %>

    
</body>

</html>
