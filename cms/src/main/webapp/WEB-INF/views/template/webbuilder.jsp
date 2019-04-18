<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Gramateria</title>
    <!-- <link rel="stylesheet" href="/css/demos.css"> -->
    <link rel="stylesheet" href="/css/grapesjs/grapes.min.css">
    <link rel="stylesheet" href="/css/gramateria/gram.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/js/grapesjs/grapes.min.js"></script>
    <script src="/js/split.min.js"></script>
    <style type="text/css">
		.code-panel {
			text-align: left;
			font-size: 1rem;
			height: 100%;
		}
		
		.code-panel section {
			height: 50%;
		}
		
		.code-panel section>div:not (.CodeMirror ) {
			line-height: 20px;
			font-size: 13px;
			padding-left: 0.6rem;
			color: #aaa;
			/* user-select: none;
		  cursor: ns-resize; */
		}
		
		.gutter {
			cursor: ns-resize;
			position: relative;
			background-color: rgba(0, 0, 0, 0.2);
		}
		
		.gutter:after {
			content: "";
			display: block;
			height: 8px;
			width: 100%;
			position: absolute;
			top: -3px;
			z-index: 150;
		}
		
		.code-panel .CodeMirror {
			height: calc(100% - 20px);
		}
		
		.gjs-pn-views {
			border-left: 1px solid rgba(0, 0, 0, 0.2);
			border-bottom: 0;
		}
		
		.gjs-pn-views-container {
			box-shadow: initial;
			border-top: 2px solid rgba(0, 0, 0, 0.2);
			top: 40px;
			padding-top: 0;
			height: calc(100vh - 40px);
		}
		
		.gjs-pn-views-container, .gjs-cv-canvas {
			transition: width 0.3s ease-in-out;
		}
    	
    </style>
</head>
<body>
<div id="gjs" style="height:0px; overflow:hidden;">
    <style> </style>
</div>
<script src="/js/gramateria/gramateria.js"></script>
</body>
</body>
</html>