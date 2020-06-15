<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Studio - Creative Photography Template | Blog</title>

<!-- Favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/core-style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/style.css">

<!-- Responsive CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/responsive.css"
	rel="stylesheet">

</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="showbox">
			<div class="loader">
				<svg class="circular" viewBox="25 25 50 50">
                    <circle class="path" cx="50" cy="50" r="20"
						fill="none" stroke-width="2" stroke-miterlimit="10" />
                </svg>
			</div>
		</div>
		<div class="questions-area text-center">
			<p>Did you know?</p>
			<ul>
				<li>The largest photography competition is 353,768 entries.</li>
				<li>Photography is the toughest profession in the world.</li>
				<li>The worldâs largest photo album by dimensions was 13 ft
					11.5 in x 17 ft.</li>
				<li>The worldâs largest photo mosaic featured 176,175
					pictures.</li>
				<li>The worldâs largest camera lens was a 5200mm lens
					attached to a canon.</li>
			</ul>
		</div>
	</div>

	<!-- Gradient Background Overlay -->
	<div class="gradient-background-overlay"></div>

	<!-- Header Area Start -->
	<header class="header-area bg-img" style="">
		<div class="container-fluid h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12 h-100">
					<div class="main-menu h-100">
						<nav class="navbar h-100 navbar-expand-lg">
							<!-- Logo Area  -->
							<a class="navbar-brand logo-style" href="javascript:;">YOU
								and I</a>

							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#studioMenu"
								aria-controls="studioMenu" aria-expanded="false"
								aria-label="Toggle navigation">
								<i class="fa fa-bars"></i> Menu
							</button>

							<div class="collapse navbar-collapse" id="studioMenu">
								<div class="name-tag-div">
									<a class="name-tag-a">${sessionScope.userName }</a>
								</div>
								<!-- Menu Area Start  -->
								<ul class="navbar-nav ml-auto">
									<li class="nav-item active"><a class="nav-link"
										href="boardlist">Home <span class="sr-only">(current)</span></a>
									</li>
									<!--<li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Pages</a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                            <a class="dropdown-item" href="index.html">Home</a>
                                            <a class="dropdown-item" href="about-me.html">About</a>
                                            <a class="dropdown-item" href="portfolio.html">Portfolio</a>
                                            <a class="dropdown-item" href="blog.html">Blog</a>
                                            <a class="dropdown-item" href="contact.html">Contact</a>
                                            <a class="dropdown-item" href="elements.html">Elements</a>
                                        </div>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="about-me.html">About</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="portfolio.html">Portfolio</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="blog.html">Blog</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="contact.html">contact</a>
                                    </li>-->
									<c:if test="${not empty sessionScope.userId }">
										<li class="nav-item"><a class="nav-link" href="logoutPro">Logout</a>
										</li>
									</c:if>
								</ul>
								<!-- Search Form -->
								<div class="header-search-form ml-auto">
									<form action="#">
										<input type="search" class="form-control"
											placeholder="Input your keyword then press enter..."
											id="search" name="search"> <input class="d-none"
											type="submit" value="submit">
									</form>
								</div>
								<!-- Search btn -->
								<div id="searchbtn">
									<img
										src="${pageContext.request.contextPath}/resources/img/core-img/search.png"
										alt="">
								</div>
							</div>
						</nav>

					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header Area End -->

	<!-- Social Sidebar Area Start -->
	<div class="social-sidebar-area">
		<!-- Social Area -->
		<!--<div class="social-info-area">
            <a href="#" data-toggle="tooltip" data-placement="right" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i> <span>Facebook</span></a>
            <a href="#" data-toggle="tooltip" data-placement="right" title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i> <span>Twitter</span></a>
            <a href="#" data-toggle="tooltip" data-placement="right" title="Pinterest"><i class="fa fa-pinterest" aria-hidden="true"></i> <span>Pinterest</span></a>
            <a href="#" data-toggle="tooltip" data-placement="right" title="Behance"><i class="fa fa-behance" aria-hidden="true"></i> <span>Behance</span></a>
        </div>-->
	</div>
	<!-- Social Sidebar Area End -->

	<!-- Blog Area Start -->
	<section class="blog-area section_padding_100 mt-100">
		<div class="container">
			<div class="row justify-content-center">
				<!-- Single Blog Area -->
				<div class="col-10">
					<div class="single-blog-area text-center mb-100 wow fadeInUpBig"
						data-wow-delay="100ms" data-wow-duration="1s">
						<div class="blog-thumbnail mb-100">
							<img src="/img/user-img/${img.stored_name }" alt="">
						</div>
						<div class="blog-content">
							<span></span>
							<h2>${detail.title }</h2>
							<a href="#" class="post-date">${detail.writedate }</a> <a
								href="#" class="post-author">By ${detail.name }</a>
							<p>${detail.content }</p>
							<c:if test="${sessionScope.userId eq detail.id }">
								<a href="boardmod?no=${detail.no }" class="btn studio-btn">MODIFY</a>
								<a href="boarddel?no=${detail.no }" class="btn studio-btn">DELETE</a>
							</c:if>
						</div>
					</div>
				</div>

			</div>
			<!-- Pagination -->
			<!-- <div class="row">
                <div class="col-12">
                    <nav aria-label="Page navigation" class="pagination-area mb-100">
                        <ul class="pagination justify-content-center">
                            <li class="page-item active"><a class="page-link" href="#">01.</a></li>
                            <li class="page-item"><a class="page-link" href="#">02.</a></li>
                            <li class="page-item"><a class="page-link" href="#">03.</a></li>
                            <li class="page-item"><a class="page-link" href="#">04.</a></li>
                        </ul>
                    </nav>
                </div>
            </div> -->
		</div>
	</section>
	<!-- Blog Area End -->

	<!-- Footer Area Start -->
	<footer class="footer-area">
		<div class="container-fluid h-100">
			<div class="row h-100">
				<div class="col-12 h-100">
					<div
						class="footer-content h-100 d-md-flex align-items-center justify-content-between">
						<!-- Single Footer Content -->
						<div class="single-footer-content">
							<img
								src="${pageContext.request.contextPath}/resources/img/core-img/map.png"
								alt=""> <a href="#">Blvd Libertad, 34 m05200 ArÃ©valo</a>
						</div>
						<!-- Single Footer Content -->
						<div class="single-footer-content">
							<img
								src="${pageContext.request.contextPath}/resources/img/core-img/smartphone.png"
								alt=""> <a href="#">0034 37483 2445 322</a>
						</div>
						<!-- Single Footer Content -->
						<div class="single-footer-content">
							<img
								src="${pageContext.request.contextPath}/resources/img/core-img/envelope-2.png"
								alt=""> <a href="#">hello@company.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Area End -->

	<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
	<!--<p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>-->
	<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->

	<!-- jQuery (Necessary for All JavaScript Plugins) -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script
		src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
	<!-- Active js -->
	<script src="${pageContext.request.contextPath}/resources/js/active.js"></script>

</body>

</html>