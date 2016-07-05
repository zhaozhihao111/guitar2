<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		
</head>
 
<body>
	<div class="main">
				 <!-----start-main---->
				 <div class="inset">
				 	<div class="social-icons">
		    			 <div class="span"><a href="#"><img src="" alt=""/><i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp查询结果</i><div class="clear"></div></a></div>
    					 <div class="clear"></div>
					</div>
				 </div>
				 			<br/>
				 			<br/>
		                    <table width="450" height="150">
		                    <font color="red" size="5">
								<center>
								<tr>
									<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</td>
									<td><font color="white" size="5">serialNumber</td>
									<td><font color="white" size="5">价格</td>
									<td><font color="white" size="5">生产商</td>
									<td><font color="white" size="5">型号</td>
									<td><font color="white" size="5">木质</td>
									</font>
								</tr>
								
								<c:forEach items="${requestScope.list}" var="p">
									<tr>
									<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									</td>
									<td><font color="white" size="5">${p.serialNumber}</td>
									<td><font color="white" size="5">${p.price }</td>
									<td><font color="white" size="5">${p.builder }</td>
									<td><font color="white" size="5">${p.model}</td>
									<td><font color="white" size="5">${p.bacwood}</td>
									</tr>
							
								</c:forEach>
								
								</center>
								</font>
								</table>
		                 	
		                     
					
									<div class="clear"> </div>
							 </form>
		<!-----//end-main---->
		</div>
		 <!-----start-copyright---->
				<!-----//end-copyright---->
	 
</body>
</html>