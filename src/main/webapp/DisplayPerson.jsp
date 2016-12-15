<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.8.2.min.js"></script>

</head>
<body>
	<form method="get">
		<p>
			<input type="submit" value="Display" id="display" />
		</p>
		<p>
		<div id="myOutput">Output Goes Here</div>
		<p>
	</form>
	<script type="text/javascript">
		
		$("#display")
				.click(
						function() {
							var artistURL = "http://localhost:8095/jersey/nuvizz/rest/fetch";
							var returnData = "";
							$
									.ajax({
										type : "GET",
										dataType : "json",
										async : false,
										url : artistURL,
										error : function(request, status, error) {
											alert(request.responseText)
										},
										success : function(data) {
											$("div#myOutput").html(" ");
											returnData = "<table style='font-size:8pt;'><tr><th>Name</th><th>Email</th></tr>";
											for (index in data) {
												/* if (!data.hasOwnProperty(prop)) {
													continue;
												} */
												

													returnData += "<tr><td>"
															+ data[index].name
															+ "</td><td>"
															+ data[index].email
															+ "</td></tr>";

												
											}
											returnData = returnData
													+ "</table>";
											$("div#myOutput").html(returnData);
										}
									});
							return (false);
						});
	</script>
</body>
</html>