<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>投票</title>
<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="./Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="./Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css" href="./Wopop_files/jquery.ui.all.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/script.js"  ></script>
<script type="text/javascript">
	$(function(){
		$("#username").blur(function(){
			var number = $(this).val();
			if(number==""){
				alert("学号不能为空！")
			}
			else{
				var url = "${pageContext.request.contextPath}/LoginServlet";
				var args = {"number":number};
				$.get(url,args,function(data){
					$("#userpwd").val(data);
					
				})
			}
			
		})
		
		
	})
</script>

</head>

<body class="login" mycollectionplug="bind">
<div class="login_m">
<div class="login_boder">

<div class="login_padding" id="login_model">
<form action="LoginServlet" method="post">
  <h2>学号</h2>
  <label>
    <input type="text" id="username" class="txt_input txt_input2" placeholder="请输入学号" name="number">
  </label>
  <h2>姓名</h2>
  <label>
    <input type="text" name="name" id="userpwd" class="txt_input" placeholder="姓名" name="name">
  </label>
  <div class="rem_sub" style="margin-top:5px">
    <label>
      <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;">
    </label>
  </div>
  </form>
</div>

<div id="forget_model" class="login_padding" style="display:none">
<br>

  <div class="rem_sub">
    <label>
     <input type="submit" class="sub_buttons" name="button" id="Retrievenow" value="Retrieve now" style="opacity: 0.7;">
     　　　
     <input type="submit" class="sub_button" name="button" id="denglou" value="Return" style="opacity: 0.7;">　　
    
    </label>
  </div>
</div>


<!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
<br><br>

</body></html>