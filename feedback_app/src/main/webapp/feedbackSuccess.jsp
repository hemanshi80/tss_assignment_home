<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head><meta charset="utf-8"><title>Feedback Submitted</title></head>
<body>
  <h2>Feedback Submitted</h2>
  <p>Your feedback is submitted successfully.</p>

  <p>
    Name : <strong>${sessionScope.name}</strong><br/>
    Submitted on : <strong>${sessionScope.sessionDate}</strong>
  </p>

  <p><a href="${pageContext.request.contextPath}/submitFeedback">Submit another feedback</a></p>
</body>
</html>
