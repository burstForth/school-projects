<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
		<title>百度地图单点标注</title>
		
 <script src="http://api.map.baidu.com/api?v=2.0&ak=nfHs8naySByE3o5fNGMqR5cVKzVkOjZl" type="text/javascript"></script> 		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="assets/map/js/jquery.baiduMap.min.js"></script>
		<style>
			* {
				margin: 0;
				padding: 0;
			}
			
			body {
				font-family: "微软雅黑";
				background: #eee;
			}
			
			.left,
			.right {
				width: 100%;
				height: 700px;
				padding: 0px  0px;
				box-sizing: border-box;
			}
			
			.left {
				height: 500px;
			}
			
			.container {
				width: 100%;
				height: 100%;
				float: left;
			}
			
		</style>
	</head>

	<body>
		
		<div class="right">
			<div id="container2" class="container"></div>
		</div>

		<script type="text/javascript">
			new BaiduMap({
				id: "container2",
				title: {
					text: "河南省",
					className: "title"
				},
				content: {
					className: "content",
					text: ["地址：郑州郑东新区金水东路88号楷林IFC-D座10F", "电话：0371-86092666"]
				},
				point: {
					lng: "113.663221",
					lat: "34.7568711"
				},
				level: 15,
				zoom: true,
				type: ["地图", "卫星", "三维"],
				width: 320,
				height: 70,
				icon: {
					url: "/HouseCms//FrontEnd/assets/images/icon.png",
					width: 36,
					height: 36
				}
			});
		</script>
	</body>

</html>