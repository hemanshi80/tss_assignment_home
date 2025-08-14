<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Error</title>

</head>
<body>
  <h2>Feedback Not Submitted</h2>
  <p style="color:red">${requestScope.errorMessage}</p>
  <p><a href="${pageContext.request.contextPath}/submitFeedback">Back to form</a></p>
</body>
</html>
