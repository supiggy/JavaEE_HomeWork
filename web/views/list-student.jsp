<%@ page import="java.util.List" %>
<%@ page import="com.scu.adminWeb.common.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>查看学员</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
    <script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>

</head>
<body class="hold-transition sidebar-mini">
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
<!-- AdminLTE App -->
<div class="wrapper">
    <%-- 导航部分--%>
    <jsp:include page="/views/common/head.jsp"/>
    <%--左侧菜单--%>
    <jsp:include page="/views/common/menu.jsp"/>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">学员列表</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body p-0">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                       <%-- <th>序号</th>--%>
                                        <th>姓名</th>
                                        <th>学号</th>
                                        <th>性别</th>
                                        <th >操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%--<jsp:useBean id="pageInfo" scope="request" type="com.scu.adminWeb.common.utils.PageInfo"/>--%>
                                    <c:forEach items="${pageInfo.data}" var="stu" varStatus="status">
                                    <tr id="${stu.id}">

                                        <td> ${stu.name}</td>
                                        <td> ${stu.stuNo}</td>
                                        <td> ${stu.sex}</td>
                                        <td>
                                            <button class="btn btn-outline-success btn-xs btn-flat btn_update" >更改</button>
                                            <%--<a class="btn btn-outline-danger btn-xs btn-flat"  href="${pageContext.request.contextPath}/delstu?id=${stu.id}&pageNo=${pageInfo.pageNo}&pageSize=10">删除</a>--%>
                                            <button class="btn btn-outline-danger btn-xs btn-flat btn_del" >删除</button>
                                        </td>
                                    </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->

                            <div class="card-footer clearfix">
                                <ul class="pagination pagination-sm m-0">
                                    <c:if test="${!pageInfo.first}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/listStudent?pageNo=${pageInfo.pre}&pageSize=10">上一页</a></li>
                                    </c:if>
                                    <li class="page-item"><a class="page-link" href="javascript:;">${pageInfo.pageNo}/${pageInfo.pageCount}</a></li>
                                    <c:if test="${!pageInfo.last}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/listStudent?pageNo=${pageInfo.next}&pageSize=10">下一页</a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
    </div>

   <%-- <jsp:include page="/views/common/footer.jsp"/>--%>

</div>
</body>
<script>
    $(function () {
        $(".btn_del").click(function () {
          var $tr = $(this).parents("tr");
            var $tdName = $tr.find("td:eq(0)");
          var id = $tr.attr("id");
          var text = "确认要删除 "+$.trim($tdName.html())+" 吗?"
          if(confirm(text)){
              window.location.href="${pageContext.request.contextPath}/delstu?id="+id+"&pageNo=${pageInfo.pageNo}&pageSize=10";
          }
        });


        $(".btn_update").click(function () {
            var $tr = $(this).parents("tr");
            var id = $tr.attr("id");
            window.location.href="${pageContext.request.contextPath}/toupdatestu?id="+id;
        });
    });

</script>
</html>

