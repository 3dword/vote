<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>投票</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/script.js"  ></script>
<script type="text/javascript">
$(function(){ 
	var count = 0;
	$(".artist_l li .cvote").click(function(){
		var fal = ${sessionScope.flag};
		count++;
		if(fal==0){
			if(count<=3){
			var nowdo = $(this);
			var number = nowdo.parent().parent().find(".tag_name").html();
			var name = nowdo.parent().parent().find(".tag_txt").html();
			var url="${pageContext.request.contextPath}/VoteServlet";
			var args = {"number":number};
			$.post(url,args,function(data){
				nowdo.parent().find(".cvotenum b").html(data);
				alert("亲！您为征名【" + name + "】投了一票！谢谢您的投票！");
				nowdo.css({background:"#dadada",border:"1px solid #f3f3f3"});
				nowdo.unbind("click");
			})
			}else{
				alert("每个学号只能投三票！谢谢配合")
			}
		}else{
			alert("您已经投过票了，每个学号只能投一次，谢谢配合");
		}
	});
})

</script>

</head>
<body style=" background-color:#cb0000">
<div class="itagBox">
	<ul class="artist_l">
	<c:if test="${empty requestScope.studentList }">
		投票人信息加载失败！
	</c:if>
	<c:forEach items="${requestScope.studentList }" var="student">
		<li class="tag1">
           <div class="votetext">
			<div class="tag_txt">
			  	${student.name }
			</div>
			<div class="tag_name">
				${student.number}
			</div>
			<a href="#"> 
             13电商社会活动积极分子选取：${student.name }
            </a>
            </div>
            <div class="votedo">
              <div class="cvotenum"><b>${student.count}</b>票</div>
              <div class="cvote">投票</div>
            </div>
		</li>
		</c:forEach>
	</ul>

</div>
</body>
</html>
