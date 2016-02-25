<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
	<meta charset="utf-8">
	<title>智能联想功能测试</title>
	<script type="text/javascript" src="/minv2/js/jquery/jquery.js"></script>
	<script src="/minv2/js/jquery/jquery-ui.js"></script>
<body>

<h1>Welcome to jQuery UI!</h1>

<!-- Autocomplete -->
<h2 class="demoHeaders">Autocomplete</h2>
<input id="istags" type="hidden" value="${userNames }"/>
<div>
	<input id="autocomplete" title="type &quot;a&quot;">
</div>

<script>
//自定义智能联想数据
var availableTags = [
	"ActionScript",
	"AppleScript",
	"Asp",
	"BASIC",
	"C",
	"C++",
	"Clojure",
	"COBOL",
	"ColdFusion",
	"Erlang",
	"Fortran",
	"Groovy",
	"Haskell",
	"Java",
	"JavaScript",
	"Lisp",
	"Perl",
	"PHP",
	"Python",
	"Ruby",
	"Scala",
	"Scheme"
];
//读取数据库智能联想数据
var tagvalue = $("#istags").val().split(',');

$( "#autocomplete" ).autocomplete({
	source: tagvalue
});

</script>
</body>
</meta></html>
