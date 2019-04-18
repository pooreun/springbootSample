<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Website Page Builder</title>
		<meta content="Best Free Open Source Responsive Websites Builder" name="description">
		<link rel="stylesheet" href="/css/grapesjs/plugins/toastr.min.css">
		<link rel="stylesheet" href="/css/grapesjs/grapes.min.css">
		<link rel="stylesheet" href="/css/grapesjs/plugins/grapesjs-preset-webpage.min.css">
		<link rel="stylesheet" href="/css/grapesjs/plugins/grapesjs-plugin-filestack.css">
		<link rel="stylesheet" href="/css/grapesjs/plugins/tooltip.css">
		<link rel="stylesheet" href="/css/demos.css">
		
		
		<script src="//static.filestackapi.com/v3/filestack.js"></script>
		<!-- <script src="js/aviary.js"></script> old //feather.aviary.com/imaging/v3/editor.js -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="/js/toastr.min.js"></script>
		
		<script src="/js/grapesjs/grapes.min.js?v0.14.57"></script>
		<script src="/js/grapesjs/plugins/grapesjs-preset-webpage.min.js"></script>
		<script src="/js/grapesjs/plugins/grapesjs-lory-slider.min.js?0.1.5"></script>
		<script src="/js/grapesjs/plugins/grapesjs-tabs.min.js?0.1.1"></script>
		<script src="/js/grapesjs/plugins/grapesjs-touch.min.js?0.1.1"></script>
		<script src="/js/grapesjs/plugins/grapesjs-parser-postcss.min.js?0.1.1"></script>
		<script src="/js/grapesjs/plugins/grapesjs-tui-image-editor.min.js?0.1.2"></script>
		<script src="/js/grapesjs/plugins/grapesjs-blocks-avance.min.js"></script>
		<script src="/js/grapesjs/plugins/grapesjs-blocks-basic.min.js"></script>
		<script src="/js/grapesjs/plugins/grapesjs-mjml.min.js"></script>
		<script src="/js/split.min.js"></script>
	
	</head>
	<body>

		<div id="gjs" style="height: 0px; overflow: hidden">
	
	
			<style>
			.clearfix {
				clear: both
			}
			
			.header-banner {
				padding-top: 35px;
				padding-bottom: 100px;
				color: #ffffff;
				font-family: Helvetica, serif;
				font-weight: 100;
				background-image: url("//grapesjs.com/img/bg-gr-v.png"),
					url("//grapesjs.com/img/work-desk.jpg");
				background-attachment: scroll, scroll;
				background-position: left top, center center;
				background-repeat: repeat-y, no-repeat;
				background-size: contain, cover;
			}
			
			.container-width {
				width: 90%;
				max-width: 1150px;
				margin: 0 auto;
			}
			
			.logo-container {
				float: left;
				width: 50%;
			}
			
			.logo {
				background-color: #fff;
				border-radius: 5px;
				width: 130px;
				padding: 10px;
				min-height: 30px;
				text-align: center;
				line-height: 30px;
				color: #4d114f;
				font-size: 23px;
			}
			
			.menu {
				float: right;
				width: 50%;
			}
			
			.menu-item {
				float: right;
				font-size: 15px;
				color: #eee;
				width: 130px;
				padding: 10px;
				min-height: 50px;
				text-align: center;
				line-height: 30px;
				font-weight: 400;
			}
			
			.lead-title {
				margin: 150px 0 30px 0;
				font-size: 40px;
			}
			
			.sub-lead-title {
				max-width: 650px;
				line-height: 30px;
				margin-bottom: 30px;
				color: #c6c6c6;
			}
			
			.lead-btn {
				margin-top: 15px;
				padding: 10px;
				width: 190px;
				min-height: 30px;
				font-size: 20px;
				text-align: center;
				letter-spacing: 3px;
				line-height: 30px;
				background-color: #d983a6;
				border-radius: 5px;
				transition: all 0.5s ease;
				cursor: pointer;
			}
			
			.lead-btn:hover {
				background-color: #ffffff;
				color: #4c114e;
			}
			
			.lead-btn:active {
				background-color: #4d114f;
				color: #fff;
			}
			
			.flex-sect {
				background-color: #fafafa;
				padding: 100px 0;
				font-family: Helvetica, serif;
			}
			
			.flex-title {
				margin-bottom: 15px;
				font-size: 2em;
				text-align: center;
				font-weight: 700;
				color: #555;
				padding: 5px;
			}
			
			.flex-desc {
				margin-bottom: 55px;
				font-size: 1em;
				color: rgba(0, 0, 0, 0.5);
				text-align: center;
				padding: 5px;
			}
			
			.cards {
				padding: 20px 0;
				display: flex;
				justify-content: space-around;
				flex-flow: wrap;
			}
			
			.card {
				background-color: white;
				height: 300px;
				width: 300px;
				margin-bottom: 30px;
				box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.2);
				border-radius: 2px;
				transition: all 0.5s ease;
				font-weight: 100;
				overflow: hidden;
			}
			
			.card:hover {
				margin-top: -5px;
				box-shadow: 0 20px 30px 0 rgba(0, 0, 0, 0.2);
			}
			
			.card-header {
				height: 155px;
				background-image: url("//placehold.it/350x250/78c5d6/fff/image1.jpg");
				background-size: cover;
				background-position: center center;
			}
			
			.card-header.ch2 {
				background-image: url("//placehold.it/350x250/459ba8/fff/image2.jpg");
			}
			
			.card-header.ch3 {
				background-image: url("//placehold.it/350x250/79c267/fff/image3.jpg");
			}
			
			.card-header.ch4 {
				background-image: url("//placehold.it/350x250/c5d647/fff/image4.jpg");
			}
			
			.card-header.ch5 {
				background-image: url("//placehold.it/350x250/f28c33/fff/image5.jpg");
			}
			
			.card-header.ch6 {
				background-image: url("//placehold.it/350x250/e868a2/fff/image6.jpg");
			}
			
			.card-body {
				padding: 15px 15px 5px 15px;
				color: #555;
			}
			
			.card-title {
				font-size: 1.4em;
				margin-bottom: 5px;
			}
			
			.card-sub-title {
				color: #b3b3b3;
				font-size: 1em;
				margin-bottom: 15px;
			}
			
			.card-desc {
				font-size: 0.85rem;
				line-height: 17px;
			}
			
			.am-sect {
				padding-top: 100px;
				padding-bottom: 100px;
				font-family: Helvetica, serif;
			}
			
			.img-phone {
				float: left;
			}
			
			.am-container {
				display: flex;
				flex-wrap: wrap;
				align-items: center;
				justify-content: space-around;
			}
			/*
						.am-container{
							perspective: 1000px;
						}*/
			.am-content {
				float: left;
				padding: 7px;
				width: 490px;
				color: #444;
				font-weight: 100;
				margin-top: 50px;
				/*transform: rotateX(0deg) rotateY(-20deg) rotateZ(0deg) scaleX(1) scaleY(1) scaleZ(1);*/
			}
			
			.am-pre {
				padding: 7px;
				color: #b1b1b1;
				font-size: 15px;
			}
			
			.am-title {
				padding: 7px;
				font-size: 25px;
				font-weight: 400;
			}
			
			.am-desc {
				padding: 7px;
				font-size: 17px;
				line-height: 25px;
			}
			
			.am-post {
				padding: 7px;
				line-height: 25px;
				font-size: 13px;
			}
			
			.blk-sect {
				padding-top: 100px;
				padding-bottom: 100px;
				background-color: #222222;
				font-family: Helvetica, serif;
			}
			
			.blk-title {
				color: #fff;
				font-size: 25px;
				text-align: center;
				margin-bottom: 15px;
			}
			
			.blk-desc {
				color: #b1b1b1;
				font-size: 15px;
				text-align: center;
				max-width: 700px;
				margin: 0 auto;
				font-weight: 100;
			}
			
			.price-cards {
				margin-top: 70px;
				display: flex;
				flex-wrap: wrap;
				align-items: center;
				justify-content: space-around;
			}
			
			.price-card-cont {
				width: 300px;
				padding: 7px;
				float: left;
			}
			
			.price-card {
				margin: 0 auto;
				min-height: 350px;
				background-color: #d983a6;
				border-radius: 5px;
				font-weight: 100;
				color: #fff;
				width: 90%;
			}
			
			.pc-title {
				font-weight: 100;
				letter-spacing: 3px;
				text-align: center;
				font-size: 25px;
				background-color: rgba(0, 0, 0, 0.1);
				padding: 20px;
			}
			
			.pc-desc {
				padding: 75px 0;
				text-align: center;
			}
			
			.pc-feature {
				color: rgba(255, 255, 255, 0.5);
				background-color: rgba(0, 0, 0, 0.1);
				letter-spacing: 2px;
				font-size: 15px;
				padding: 10px 20px;
			}
			
			.pc-feature:nth-of-type(2n) {
				background-color: transparent;
			}
			
			.pc-amount {
				background-color: rgba(0, 0, 0, 0.1);
				font-size: 35px;
				text-align: center;
				padding: 35px 0;
			}
			
			.pc-regular {
				background-color: #da78a0;
			}
			
			.pc-enterprise {
				background-color: #d66a96;
			}
			
			.footer-under {
				background-color: #312833;
				padding-bottom: 100px;
				padding-top: 100px;
				min-height: 500px;
				color: #eee;
				position: relative;
				font-weight: 100;
				font-family: Helvetica, serif;
			}
			
			.led {
				border-radius: 100%;
				width: 10px;
				height: 10px;
				background-color: rgba(0, 0, 0, 0.15);
				float: left;
				margin: 2px;
				transition: all 5s ease;
			}
			
			.led:hover {
				background-color: #c29fca; /* #eac229 */
				box-shadow: 0 0 5px #9d7aa5, 0 0 10px #e6c3ee; /* 0 0 10px 0 #efc111 */
				transition: all 0s ease;
			}
			
			.copyright {
				background-color: rgba(0, 0, 0, 0.15);
				color: rgba(238, 238, 238, 0.5);
				bottom: 0;
				padding: 1em 0;
				position: absolute;
				width: 100%;
				font-size: 0.75em;
			}
			
			.made-with {
				float: left;
				width: 50%;
				padding: 5px 0;
			}
			
			.foot-social-btns {
				display: none;
				float: right;
				width: 50%;
				text-align: right;
				padding: 5px 0;
			}
			
			.footer-container {
				display: flex;
				flex-wrap: wrap;
				align-items: stretch;
				justify-content: space-around;
			}
			
			.foot-list {
				float: left;
				width: 200px;
			}
			
			.foot-list-title {
				font-weight: 400;
				margin-bottom: 10px;
				padding: 0.5em 0;
			}
			
			.foot-list-item {
				color: rgba(238, 238, 238, 0.8);
				font-size: 0.8em;
				padding: 0.5em 0;
			}
			
			.foot-list-item:hover {
				color: rgba(238, 238, 238, 1);
			}
			
			.foot-form-cont {
				width: 300px;
				float: right;
			}
			
			.foot-form-title {
				color: rgba(255, 255, 255, 0.75);
				font-weight: 400;
				margin-bottom: 10px;
				padding: 0.5em 0;
				text-align: right;
				font-size: 2em;
			}
			
			.foot-form-desc {
				font-size: 0.8em;
				color: rgba(255, 255, 255, 0.55);
				line-height: 20px;
				text-align: right;
				margin-bottom: 15px;
			}
			
			.form {
				border-radius: 3px;
				padding: 10px 15px;
				background-color: rgba(0, 0, 0, 0.2);
			}
			
			.input, .textarea, .select, .sub-input {
				width: 100%;
				margin-bottom: 15px;
				padding: 7px 10px;
				border-radius: 2px;
				color: #fff;
				background-color: #554c57;
				border: none;
			}
			
			
			
			.select {
				height: 30px;
			}
			
			.label {
				width: 100%;
				display: block;
			}
			
			.button, .sub-btn {
				width: 100%;
				margin: 15px 0;
				background-color: #785580;
				border: none;
				color: #fff;
				border-radius: 2px;
				padding: 7px 10px;
				font-size: 1em;
				cursor: pointer;
			}
			
			.sub-btn:hover {
				background-color: #91699a;
			}
			
			.sub-btn:active {
				background-color: #573f5c;
			}
			
			.blk-row::after {
				content: "";
				clear: both;
				display: block;
			}
			
			.blk-row {
				padding: 10px;
			}
			
			.blk1 {
				width: 100%;
				padding: 10px;
				min-height: 75px;
			}
			
			.blk2 {
				float: left;
				width: 50%;
				padding: 10px;
				min-height: 75px;
			}
			
			.blk3 {
				float: left;
				width: 33.3333%;
				padding: 10px;
				min-height: 75px;
			}
			
			.blk37l {
				float: left;
				width: 30%;
				padding: 10px;
				min-height: 75px;
			}
			
			.blk37r {
				float: left;
				width: 70%;
				padding: 10px;
				min-height: 75px;
			}
			
			.heading {
				padding: 10px;
			}
			
			.paragraph {
				padding: 10px;
			}
			
			.bdg-sect {
				padding-top: 100px;
				padding-bottom: 100px;
				font-family: Helvetica, serif;
				background-color: #fafafa;
			}
			
			.bdg-title {
				text-align: center;
				font-size: 2em;
				margin-bottom: 55px;
				color: #555555;
			}
			
			.badges {
				padding: 20px;
				display: flex;
				justify-content: space-around;
				align-items: flex-start;
				flex-wrap: wrap;
			}
			
			.badge {
				width: 290px;
				font-family: Helvetica, serif;
				background-color: white;
				margin-bottom: 30px;
				box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.2);
				border-radius: 3px;
				font-weight: 100;
				overflow: hidden;
				text-align: center;
			}
			
			.badge-header {
				height: 115px;
				background-image: url("//grapesjs.com/img/bg-gr-v.png"),
					url("//grapesjs.com/img/work-desk.jpg");
				background-position: left top, center center;
				background-attachment: scroll, fixed;
				overflow: hidden;
			}
			
			.blurer {
				filter: blur(5px);
			}
			
			.badge-name {
				font-size: 1.4em;
				margin-bottom: 5px;
			}
			
			.badge-role {
				color: #777;
				font-size: 1em;
				margin-bottom: 25px;
			}
			
			.badge-desc {
				font-size: 0.85rem;
				line-height: 20px;
			}
			
			.badge-avatar {
				width: 100px;
				height: 100px;
				border-radius: 100%;
				border: 5px solid #fff;
				box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.2);
				margin-top: -75px;
				position: relative;
			}
			
			.badge-body {
				margin: 35px 10px;
			}
			
			.badge-foot {
				color: #fff;
				background-color: #a290a5;
				padding-top: 13px;
				padding-bottom: 13px;
				display: flex;
				justify-content: center;
			}
			
			.badge-link {
				height: 35px;
				width: 35px;
				line-height: 35px;
				font-weight: 700;
				background-color: #fff;
				color: #a290a5;
				display: block;
				border-radius: 100%;
				margin: 0 10px;
			}
			
			.quote {
				color: #777;
				font-weight: 300;
				padding: 10px;
				box-shadow: -5px 0 0 0 #ccc;
				font-style: italic;
				margin: 20px 30px;
			}
			
			@media ( max-width : 768px) {
				.foot-form-cont {
					width: 400px;
				}
				.foot-form-title {
					width: autopx;
				}
			}
			
			@media ( max-width : 480px) {
				.foot-lists {
					display: none;
				}
			}
			
			</style>
		</div>
	
		<script type="text/javascript">
			var editor	= grapesjs.init({
				avoidInlineStyle: 1,
				height: '100%',
				container : '#gjs',
				allowScripts: 1,
				noticeOnUnload: 0,
				fromElement: 1,
				showOffsets: 1,
				/* canvas: { 
			        styles: ['/css/materialize.min.css'],
			    }, */
				storageManager: {
					type: 'remote',
					autosave: false,
					//urlStore: 'dragdrop/edit/id',
					urlLoad: '/template/loadHtmlCss?id=10',
					contentTypeJson: true,
				},
				assetManager: {
					storageType		: '',
					storeOnChange	: true,
					storeAfterUpload	: true,
					assets			: [ ],
					upload: '/upload/files',				//for temporary storage
				 	uploadFile: function(e) {
						var files = e.dataTransfer ? e.dataTransfer.files : e.target.files;
						var formData = new FormData();
						for(var i in files){
							formData.append('file', files[i]) //containing all the selected images from local
						}
		
						$.ajax({
							url: '/upload/multi_upload_image',
							type: 'POST',
							data: formData,
							contentType:false,
							crossDomain: true,
							dataType: 'json',
							mimeType: "multipart/form-data",
							processData:false,
							success: function(result){
								var myJSON = [];
								$.each( result['data'], function( key, value ) {
									myJSON[key] = value;		
								});
								var images = myJSON;		
								editor.AssetManager.add(images); //adding images to asset manager of GrapesJS
							}
						});
				 	},
				},
				styleManager: { clearProperties: 1 },
				plugins: [ 
					'gjs-preset-webpage',
					'gjs-blocks-basic',
					'grapesjs-lory-slider',
					'grapesjs-parser-postcss',
					'gjs-plugin-ckeditor',
					'gjs-blocks-avance',
					
				],
				pluginsOpts: {
					'grapesjs-lory-slider': {
						sliderBlock: {
							category: 'Basic'
						}
				 	},
				 	'gjs-blocks-avance': {},
				 	
				},
	
			});
	
			/* EDIT 모듈 추가*/
			var pfx = editor.getConfig().stylePrefix;
			var pn = editor.Panels;
			var modal = editor.Modal;
			var codeViewer = editor.CodeManager.getViewer('CodeMirror').clone();
			var cmdm = editor.Commands;
			var blockManager = editor.BlockManager;

			blockManager.add('table', {
                label: 'Table',
                category: 'Basic',
                attributes: {
                    class: 'fa fa-table'
                },
                content: '<table class="responsive-table centered striped highlight bordered">'
                + '<thead>'
                + '<tr>'
                + '<th>Name</th>'
                + '<th>Item Name</th>'
                + '<th>Item Price</th>'
                + '</tr>'
                + '</thead>'
                + '<tbody>'
                + '<tr>'
                + '<td>Alvin</td>'
                + '<td>Eclair</td>'
                + '<td>$0.87</td>'
                + '</tr>'
                + '<tr>'
                + '<td>Alan</td>'
                + '<td>Jellybean</td>'
                + '<td>$3.76</td>'
                + '</tr>'
                + '<tr>'
                + '<td>Jonathan</td>'
                + '<td>Lollipop</td>'
                + '<td>$7.00</td>'
                + '</tr>'
                + '</tbody>'
                + '</table>',
            }); 
			

			function buildCodeEditor(type) {
				var codeEditor = editor.CodeManager.getViewer('CodeMirror').clone();
				codeEditor.set({
					codeName: type === 'html' ? 'htmlmixed' : 'css',
					readOnly: false,
					theme: 'hopscotch',
					autoBeautify: true,
					autoCloseTags: true,
					autoCloseBrackets: true,
					styleActiveLine: true,
					smartIndent: true,
				});
				return codeEditor;
			}

			function setupHtmlAutoUpdates(htmlCodeEditor) {
				function update() {
					const htmlCode = htmlCodeEditor.editor.getValue()
					if (!htmlCode) return;
					editor.setComponents(htmlCode);
				}
				var delay;
				htmlCodeEditor.editor.on('change', function() {
					clearTimeout(delay);
					delay = setTimeout(update, 300);
				});
				  htmlCodeEditor.editor.refresh();
			}

			function setupCssAutoUpdates(cssCodeEditor) {
				function update() {
					const cssCode = cssCodeEditor.editor.getValue()
					if (!cssCode) return;
					editor.setStyle(cssCode);
			 	}
				var delay;
			  	cssCodeEditor.editor.on('change', function() {
					clearTimeout(delay);
					delay = setTimeout(update, 300);
			  	});
			  	cssCodeEditor.editor.refresh();
			}

			function buildCodePanel(panel) {
				const codePanel = document.createElement('div');
				codePanel.classList.add('code-panel');

				const htmlSection = document.createElement('section');
				const cssSection = document.createElement('section');
				htmlSection.innerHTML = '<div>HTML</div>'
				cssSection.innerHTML = '<div>CSS</div>'

				const htmlCodeEditor = buildCodeEditor('html');
				const cssCodeEditor = buildCodeEditor('css');
				const htmlTextArea = document.createElement('textarea');
				const cssTextArea = document.createElement('textarea');
				htmlSection.appendChild(htmlTextArea);
				cssSection.appendChild(cssTextArea);

				codePanel.appendChild(htmlSection);
				codePanel.appendChild(cssSection);
				panel.set('appendContent', codePanel).trigger('change:appendContent');
				htmlCodeEditor.init(htmlTextArea);
				cssCodeEditor.init(cssTextArea);
				htmlCodeEditor.setContent(editor.getHtml());
				cssCodeEditor.setContent(editor.getCss({ avoidProtected: true }));

				Split([htmlSection, cssSection], {
					direction: 'vertical',
					sizes: [50, 50],
					minSize: 100,
					gutterSize: 2,
					onDragEnd: () => {
						htmlCodeEditor.editor.refresh();
						cssCodeEditor.editor.refresh();
					}
				});

				setupHtmlAutoUpdates(htmlCodeEditor);
				setupCssAutoUpdates(cssCodeEditor);

				  // make sure editor is aware of width change after the 300ms effect ends
				setTimeout(() => {
					htmlCodeEditor.editor.refresh();
					cssCodeEditor.editor.refresh();
				}, 320)

				return codePanel
			}

			cmdm.add('canvas-clear', function() {
				if(confirm('Areeee you sure to clean the canvas?')) {
					var comps = editor.DomComponents.clear();
					setTimeout(function(){ localStorage.clear()}, 0)
				}
			});
	
			pn.addButton(
				'options',
				[{
					id: 'saveFile',
					className: 'fa fa-floppy-o',
					command: 'saveFile',
					attributes: {title: 'Save'}
				}]
			);
			
			cmdm.add('saveFile',
			{
				run: function(editor, sender)
				{
					sender && sender.set('active', 0); // turn off the button
					editor.store();
					saveContent();
				}
			});
			 
			// Show borders by default 
			pn.getButton('options', 'sw-visibility').set('active', 1);
			
			pn.addButton('views',
				[
					{
						id: 'open-code',
						className : 'fa fa-edit',
						command: 'open-code',
						attributes: { title: 'Open Code' }
					}
				]
			);
			cmdm.add('set-device-desktop', {
				run: ed => ed.setDevice('Desktop'),
				stop() {},
			});
			cmdm.add('set-device-tablet', {
				run: ed => ed.setDevice('Tablet'),
				stop() {},
			});
			cmdm.add('set-device-mobile', {
				run: ed => ed.setDevice('Mobile portrait'),
				stop() {},
			});
	
			// Add info command
			var mdlClass = 'gjs-mdl-dialog-sm';
			
			// Simple warn notifier
			var origWarn = console.warn;
			toastr.options = {
				closeButton: true,
				preventDuplicates: true,
				showDuration: 250,
				hideDuration: 150
			};
			console.warn = function (msg) {
				if (msg.indexOf('[undefined]') == -1) {
					toastr.warning(msg);
				}
				origWarn(msg);
			};
	
			// Add and beautify tooltips
			[['sw-visibility', 'Show Borders'], ['preview', 'Preview'], ['fullscreen', 'Fullscreen'],
			 ['export-template', 'Export'], ['undo', 'Undo'], ['redo', 'Redo'],
			 ['canvas-clear', 'Clear canvas'], ['saveFile', 'saveFile']]
			.forEach(function(item) {
				pn.getButton('options', item[0]).set('attributes', {title: item[1], 'data-tooltip-pos': 'bottom'});
			});
			[['open-sm', 'Style Manager'], ['open-tm', 'Trait Manager'],['open-layers', 'Layers'], ['open-blocks', 'Blocks'], ['open-code', 'code']]
			.forEach(function(item) {
				pn.getButton('views', item[0]).set('attributes', {title: item[1], 'data-tooltip-pos': 'bottom'});
			});
	
			// Store and load events
			editor.on('storage:load', function(e) { console.log('Loaded ', e) });
			editor.on('storage:store', function(e) { console.log('Stored ', e) });
	
			// Do stuff on load
			editor.on('load', function() {
				var $ = grapesjs.$;
	
				// Load and show settings and style manager
				var openSm = pn.getButton('views', 'open-sm');
				openSm && openSm.set('active', 1);
	
	
				$(".fa-download").hide(); 
	
				// Open block manager
				var openBlocksBtn = editor.Panels.getButton('views', 'open-blocks');
				openBlocksBtn && openBlocksBtn.set('active', 1);

				cmdm.add('open-code', {
					run: function(editor, senderBtn) {
						const pn = editor.Panels;
						const id = 'views-container';
						const panel = pn.getPanel(id) || pn.addPanel({ id });
						if (!this.codePanel) this.codePanel = buildCodePanel(panel)
						this.codePanel.style.display = 'block';
						editor.$('.gjs-pn-views-container').get(0).style.width = '35%';
						editor.$('.gjs-cv-canvas').get(0).style.width = '65%';
					},
					stop: function(editor, senderBtn) {
						if (this.codePanel) this.codePanel.style.display = 'none';
						editor.$('.gjs-pn-views-container').get(0).style.width = '15%';
						editor.$('.gjs-cv-canvas').get(0).style.width = '85%';
					}
				});

				
			});
			
			function saveContent() {
				var html = editor.getHtml(); //get html content of document
				var css = editor.getCss(); //get css content of document
	
				$.ajax({
					url: "/template/saveHtmlCss",
					data :{'html':html,'css':css},
					async:true,
					type:'POST',
					success: function(result) {
						alert(result);
					},
					error:function(data) {
					}
				});
			}
			</script>
	</body>
</html>
