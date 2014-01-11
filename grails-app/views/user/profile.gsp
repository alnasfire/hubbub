<%--
  Created by IntelliJ IDEA.
  User: nasgor
  Date: 1/10/14
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
    <div class="profilePic">
        <g:if test="${profile.photo}">
            <img src="
                <g:createLink controller='image' action='renderImage', id='${userId}'/>"/>
        </g:if>
        <p>Profile for <strong>${profile.fullName}</strong></p>
        <p>Bio: ${profile.bio}</p>
    </div>
</body>
</html>