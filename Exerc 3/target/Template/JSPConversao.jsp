
<!DOCTYPE html>
<html>
<head>
<title>JSP Conversao</title>
</head>
<body>
            
            <%
            
			String minValue = request.getParameter("minValue");
			int min = (minValue == null || minValue.isEmpty()) ? -100 : Integer.parseInt(minValue);
			
			String maxValue = request.getParameter("maxValue");
			int max = (maxValue == null || maxValue.isEmpty()) ? 100 : Integer.parseInt(maxValue);
			
			String incValue = request.getParameter("incValue");
			int inc = (incValue == null || incValue.isEmpty()) ? 5 : Integer.parseInt(incValue);
			
			%>
			
			
			<table border	 = 1>
			<tr>
			<th>Celsius</th>
			<th>Fahrenheit</th>
			</tr>
			<%
			for (int celsius = min; celsius<=max; celsius += inc) {
				double fahr= 1.8 * celsius + 32;
				%>
				<tr>
				<td> <%=celsius%> </td>
				<td> <%=fahr%> </td>
				</tr>
			<%}%>
			</table>

            
            </body>
            </html>


