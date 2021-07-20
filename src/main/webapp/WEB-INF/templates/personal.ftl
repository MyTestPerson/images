<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal page</title>
</head>
<body>

<h1>Personal page</h1>

<br><br>

<a href="/"><b>Home</b></a>

<br><br>

<b>${msg!}</b>

<br><br>

<form method="post" action="/logout">
    <#--noinspection FtlReferencesInspection-->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Log out</button>
</form>

</body>
</html>