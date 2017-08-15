<html>
<body>

<%--单文件上传--%>
<form method="post" enctype="multipart/form-data" action="/demo010/user/uploadfile1">
    <input type="file" name="file"/>
    <input type="submit" value="Submit"/>
</form>

<%--多文件上传--%>
<form method="post" enctype="multipart/form-data" action="/demo010/user/uploadfile2">
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="submit" value="Submit"/>
</form>

<%--带参数的文件上传--%>
<form method="post" enctype="multipart/form-data" action="/demo010/user/uploadfile3">
    <input type="text" name="userid"/>
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
