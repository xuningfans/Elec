<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>国家电力监测中心首页</title>
<link href="/css/font.css" type="text/css" rel="stylesheet">

<style>
body {
	scrollbar-arrow-color: #ffffff; scrollbar-base-color: #dee3f7
}
</style>

<script type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}
</script>
</head>
<frameset border=0 framespacing=0 rows=82,* frameborder=0 id="mainparent">
	<frame name=topframe src="${pageContext.request.contextPath }/system/elecMenuAction_title.do" noresize scrolling=no>
	<frameset id="main" border="0" framespacing="0" frameborder="0" cols="153,1%,*">
		<frame name="leftframe" src="${pageContext.request.contextPath }/system/elecMenuAction_left.do" noresize>
		<frame name="changebutton" src="${pageContext.request.contextPath }/system/elecMenuAction_change.do" frameborder=0 marginheight=0 marginwidth=0 scrolling=no noresize>
		<frame name="mainframe" src="${pageContext.request.contextPath }/system/elecMenuAction_loading.do" >
	</frameset>
</frameset>

</html>
