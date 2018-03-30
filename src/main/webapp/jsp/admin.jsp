    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page session="true"%>
    <html>
        <body>
            <h1>Title : ${title}</h1>
            <h1>Message : ${message}</h1>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <h2>
                    Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/page/logout" />">Logout</a><br>
                    csrf.token: ${_csrf.parameterName} / ${_csrf.token} <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </h2>
            </c:if>
        </body>
    </html>