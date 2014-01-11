<%--
  Created by IntelliJ IDEA.
  User: nasgor
  Date: 1/10/14
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Register new user</title>
  <meta name="layout" content="main"/>
</head>
<body>
    <h1>Register new user</h1>

        <dl>
        <g:uploadForm>
            <dt>User id</dt>
            <dd><g:textField name="userId" value="${user?.userId}"/></dd>

            <dt>Password</dt>
            <dd><g:passwordField name="password" value="${user?.password}"/></dd>
            <dt>(repeat)</dt>
            <dd><g:passwordField name="passwordRepeat" /></dd>

            <dt>Country</dt>
            <dd><g:countrySelect name="country" noSelection="['':'Choose your country...']"/></dd>

            <dt>Photo:</dt>
            <dd><input type="file" name="photo"/></dd>

            <dt>Timezone:</dt>
            <dd><g:timeZoneSelect name="timezone"/></dd>

            <dt>Who introduced you to Hubbub?</dt>
            <dd>
                <g:select name="referrer"
                          from="${com.grailsinaction.Profile.list()}"
                          optionKey="id"
                          noSelection="${['null':'Please Choose...']}"/>
            </dd>

            <dt>Spam me forever</dt>
            <dd><g:checkBox name="spamMe" checked="true"/></dd>

            <dt>Email</dt>
            <dd>
                <g:radioGroup name="emailFormat"
                              labels="['Plain','HTML']"
                              values="['P','H']"
                              value="H">
                    ${it.label} ${it.radio}
                </g:radioGroup>
            </dd>

            <dt>
                <g:actionSubmit value="Register"/>
            </dt>
            <dd>
                <g:actionSubmit value="Cancel" action="cancelRegister"/>
            </dd>
            </g:uploadForm>
        </dl>
</body>
</html>