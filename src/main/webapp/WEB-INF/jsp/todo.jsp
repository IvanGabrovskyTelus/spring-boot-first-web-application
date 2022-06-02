<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<HTML>

<head>
<title>First Web Application</title>
</head>

<body>
	<div class="container">		
		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:label path="">Description</form:label>
				<form:input path="desc" type="text" class="form-control" required="required"/>
			</fieldset>
 
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>

</HTML>