<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style>
.gallery-wrap .img-big-wrap img {
	height: 450px;
	width: auto;
	display: inline-block;
	cursor: zoom-in;
}

.gallery-wrap .img-small-wrap .item-gallery {
	width: 60px;
	height: 60px;
	border: 1px solid #ddd;
	margin: 7px 2px;
	display: inline-block;
	overflow: hidden;
}

.gallery-wrap .img-small-wrap {
	text-align: center;
}

.gallery-wrap .img-small-wrap img {
	max-width: 100%;
	max-height: 100%;
	object-fit: cover;
	border-radius: 4px;
	cursor: zoom-in;
}

.img-big-wrap img {
	width: 100% !important;
	height: auto !important;
}
</style>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<br/>
	<br/>
	<div class="container">
		<div class="row">
			<jsp:include page="Left.jsp"></jsp:include>
			<div class="col-sm-9">
				<div class="container">
					<div class="card">
						<div class="row">
							<aside class="col-sm-5 border-right">
								<article class="gallery-wrap">
									<div class="img-big-wrap">
										<div>
											<a href="#"><img src="${detail.image}"></a>
										</div>
									</div>
									<!-- slider-product.// -->
									<div class="img-small-wrap"></div>
									<!-- slider-nav.// -->
								</article>
								<!-- gallery-wrap .end// -->
							</aside>
							<aside class="col-sm-7">
								<article class="card-body p-5">
									<h3 class="title mb-3">${detail.name}</h3>

									<p class="price-detail-wrap">
										<span class="price h3 text-warning"> <span
											class="currency">US $</span><span class="num">${detail.price}</span>
										</span>
									</p>
									<!-- price-detail-wrap .// -->
									<dl class="item-property">
										<dt>Description</dt>
										<dd>
											<p>${detail.description}</p>
										</dd>
										<p>Average Rating: <span style="color: red;">${avgRating}</span></p>
									</dl>

									<hr>
									<div class="row">
										<div class="col-sm-5">
											<dl class="param param-inline">
												<dt>Quantity:</dt>
												<dd>
													<select class="form-control form-control-sm"
														style="width: 70px;">
														<option>1</option>
														<option>2</option>
														<option>3</option>
													</select>
												</dd>
											</dl>
											<!-- item-property .// -->
										</div>
										<!-- col.// -->

									</div>
									<!-- row.// -->
									<hr>
									<a href="#" class="btn btn-lg btn-primary text-uppercase">
										Buy now </a> <a href="#"
										class="btn btn-lg btn-outline-primary text-uppercase"> <i
										class="fas fa-shopping-cart"></i> Add to cart
									</a>
								</article>
								<!-- card-body.// -->
							</aside>
							<!-- col.// -->
						</div>
						<!-- row.// -->
					</div>
					<!-- card.// -->
					<div>
						<br>
						<div>
						    <h3>Ratings</h3>
						    <c:forEach items="${ratings}" var="rating">
						    	<div>
						    		<span style="font-weight: bold;" >User ${rating.userId}:  </span>
						       	 	<span style="color: red;"> ${rating.rating} </span>
						    	</div> 
						    </c:forEach>
						</div>
						<br>
						
						<div>
						    <h3>Comments</h3>
						    <c:forEach items="${comments}" var="comment">
						        <%-- <p style="font-weight: bold;">User ${comment.userId} :</p>
						        <p>${comment.comment}</p> --%>
						        <div>
							        <span style="font-weight: bold;">User ${comment.userId}:</span>
	    							<span>${comment.comment}</span>
						        </div>
						        
						        <p style="font-style: italic;">${comment.createdDate}</p>
						    </c:forEach>
						</div>
						
						<br>
						
						<h3>Add comment and rating here</h3>
						<form action="addComment" method="post">
						    <input type="hidden" name="productId" value="${detail.id}">
						    <label for="rating">Rating:</label>
						    <select name="rating">
						        <option value="1">1</option>
						        <option value="2">2</option>
						        <option value="3">3</option>
						        <option value="4">4</option>
						        <option value="5">5</option>
						    </select>
						    <br>
						    <label for="comment">Comment:</label>
						    <textarea name="comment" rows="4" cols="50"></textarea>
						    <br>
						    <button type="submit">Submit</button>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
<%-- <body>
    <jsp:include page="Menu.jsp"></jsp:include>
    <div class="container">
        <div class="row">
            <jsp:include page="Left.jsp"></jsp:include>
            <div class="col-sm-9">
                <div class="container">
                    <div class="card">
                        <div class="row">
                            <aside class="col-sm-5 border-right">
                                <article class="gallery-wrap">
                                    <div class="img-big-wrap">
                                        <div>
                                            <a href="#"><img src="${detail.image}"></a>
                                        </div>
                                    </div>
                                    <div class="img-small-wrap"></div>
                                </article>
                            </aside>
                            <aside class="col-sm-7">
                                <article class="card-body p-5">
                                    <h3 class="title mb-3">${detail.name}</h3>
                                    <p class="price-detail-wrap">
                                        <span class="price h3 text-warning"> 
                                            <span class="currency">US $</span><span class="num">${detail.price}</span>
                                        </span>
                                    </p>
                                    <dl class="item-property">
                                        <dt>Description</dt>
                                        <dd><p>${detail.description}</p></dd>
                                    </dl>
                                    <hr>
                                    <p>Average Rating: <span style="color: red;">${avgRating}</span></p>
                                    <div class="row">
                                        <div class="col-sm-5">
                                            <dl class="param param-inline">
                                                <dt>Quantity:</dt>
                                                <dd>
                                                    <select class="form-control form-control-sm" style="width: 70px;">
                                                        <option>1</option>
                                                        <option>2</option>
                                                        <option>3</option>
                                                    </select>
                                                </dd>
                                            </dl>
                                        </div>
                                    </div>
                                    <hr>
                                    <a href="#" class="btn btn-lg btn-primary text-uppercase">Buy now</a> 
                                    <a href="#" class="btn btn-lg btn-outline-primary text-uppercase"> 
                                        <i class="fas fa-shopping-cart"></i> Add to cart
                                    </a>
                                </article>
                            </aside>
                        </div>
                    </div>
                </div>
                <div class="container mt-4">
                    <h4>Comments</h4>
                    <c:forEach var="comment" items="${listComment}">
                        <div class="comment-section">
                            <p><strong>${comment.account.user}</strong> - <span style="font-style: italic;">${comment.commentDate}</span></p>
                            <p style="color: red;">Rating: ${comment.rating}</p>
                            <p>${comment.content}</p>
                            <hr>
                        </div>
                    </c:forEach>
                    <form action="addComment" method="post">
                        <input type="hidden" name="pid" value="${detail.id}">
                        <textarea name="content" rows="4" cols="50" placeholder="Add your comment here..."></textarea>
                        <select name="rating">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body> --%>

</html>
