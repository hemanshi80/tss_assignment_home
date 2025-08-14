<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>Feedback Form</title>
  <style>
    label { display:block; margin-top:8px; }
    input[type="number"] { width:60px; }
    .error { color: red; }
  </style>
  <script>
    function isIntInRange(val, min, max) {
      if (val === null || val === "") return false;
      // only digits
      if (!/^\d+$/.test(val)) return false;
      var n = parseInt(val, 10);
      return n >= min && n <= max;
    }
    function validateForm() {
      var fields = [
        "sessionContent", "queryResolution", "interactivity", "impactfulLearning", "contentDeliverySkills"
      ];
      for (var i=0;i<fields.length;i++) {
        var v = document.forms["fbForm"][fields[i]].value;
        if (!isIntInRange(v,1,10)) {
          alert("All ratings must be integer numbers between 1 and 10.");
          document.forms["fbForm"][fields[i]].focus();
          return false;
        }
      }
      var name = document.forms["fbForm"]["name"].value.trim();
      if (name.length === 0) {
        alert("Please enter your name.");
        document.forms["fbForm"]["name"].focus();
        return false;
      }
      var date = document.forms["fbForm"]["sessionDate"].value;
      if (date === "") {
        alert("Please choose session date.");
        return false;
      }
      return true;
    }
    // optional: prevent non-digit input
    function onlyDigits(e) {
      var key = e.key;
      if (!/^\d$/.test(key) && key !== "Backspace" && key !== "Tab" && key !== "ArrowLeft" && key !== "ArrowRight") {
        e.preventDefault();
      }
    }
  </script>
</head>
<body>
  <h2>Session Feedback</h2>

  <c:if test="${not empty errorMessage}">
    <div class="error">${errorMessage}</div>
  </c:if>

  <form name="fbForm" method="post" action="${pageContext.request.contextPath}/submitFeedback" onsubmit="return validateForm();">
    <label>Name:
      <input type="text" name="name" required maxlength="100" />
    </label>

    <label>Session Date:
      <input type="date" name="sessionDate" required />
    </label>

    <label>Session Content (1-10):
      <input type="number" name="sessionContent" min="1" max="10" onkeypress="onlyDigits(event)" required />
    </label>

    <label>Query Resolution/Feedback (1-10):
      <input type="number" name="queryResolution" min="1" max="10" onkeypress="onlyDigits(event)" required />
    </label>

    <label>Interactivity / Engagement (1-10):
      <input type="number" name="interactivity" min="1" max="10" onkeypress="onlyDigits(event)" required />
    </label>

    <label>Impactful learning (1-10):
      <input type="number" name="impactfulLearning" min="1" max="10" onkeypress="onlyDigits(event)" required />
    </label>

    <label>Content Delivery Skills (1-10):
      <input type="number" name="contentDeliverySkills" min="1" max="10" onkeypress="onlyDigits(event)" required />
    </label>

    <label>Comments (optional):
      <textarea name="comments" rows="3" cols="40" maxlength="500"></textarea>
    </label>

    <br/>
    <button type="submit">Submit Feedback</button>
  </form>
</body>
</html>
