<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=0.5, minimal-scale=0.5">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Europe</title>
<script>
var i = 0
function diapo() {
	var imgs = [ "img/europe1.jpg", "img/europe2.jpg",
		"img/europe3.jpg", "img/europe4.jpg" ]
	var img = document.querySelector("img")
	
	img.setAttribute("src", imgs[i % 4])
	i++
}
setInterval(diapo, 2000)
</script>

</head>

<body style="text-align:center">

<div class="container">

<h1>Europe</h1>

<p><img src="img/europe1.jpg"/></p>

<nav>
		<ul class="nav nav-tabs">
			<li><a href="irelande/index">Irelande</a></li>
			<li><a href="england/index">Angleterre</a></li>
			<li><a href="spain/proposal">Espagne</a></li>
			<li><a href="italy/index">Italie</a></li>
			<li><a href="croatia/index">Croatie</a></li>
		</ul>
</nav>

</div>
</body>
</html>