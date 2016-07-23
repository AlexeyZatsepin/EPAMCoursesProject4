<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP Timing</title>
  </head>
  <body>
      <h1>Timer</h1>
      <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
      <form name="simple" action="timeaction" method="POST">
        <input type="hidden" name="time" value="${calendar.timeInMillis}">
        <input type="submit" name="button" value="time value">
      </form>
      <p>Pressed about ${res} sec</p>
  </body>
</html>
