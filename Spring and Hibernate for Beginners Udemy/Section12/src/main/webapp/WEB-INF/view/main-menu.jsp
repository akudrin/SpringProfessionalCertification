<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>
<h2>hello</h2>
<img src="${pageContext.request.contextPath}/resources/images/logo.svg" />
    <hr>
    <a href="hello/showForm">Hello World Form</a>
    <br><br>
	<a href="student/showForm">Student Form</a>
	<br><br>
	<input type="button" onclick="doSomeWork()" value="Click Me"/>
	<br><br>
	<a href="customer/showForm">Customer Form</a>
</body>
</html>