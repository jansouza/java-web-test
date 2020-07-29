<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<h1>${msg} - NEW</h1>
<h2>Today is <fmt:formatDate value="${today}" pattern="yyy-MM-dd" /></h2>

  <h2>maxMemory ${maxMemory} MB</h2>
  <h2>freeMemory ${freeMemory} MB</h2>
  <h2>totalMemory ${totalMemory} MB</h2>

  <a href="/oom">SimulateOutOfMemoryError</a>
</body>
</html>
