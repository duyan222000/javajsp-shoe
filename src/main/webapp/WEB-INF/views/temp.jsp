<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group category_block">
			<c:forEach items="${listCC}" var="o">
				<li class="list-group-item text-white ${tag == o.cid ? "active" : "" }">
					<a href="category?cid=${o.cid}"
					class="${tag == o.cid ? 'text-white' : ''}">${o.cname}</a>
				</li>
			</c:forEach>

		</ul>
	</div>

    <div>
    <div class="card bg-light mb-3" style="border: 0; width: 260px; height: 560px;">
    <div class="card-header bg-warning text-white text-uppercase" style="padding: 0.75rem; text-align: center;">
        Advertisement
    </div>
    <div class="card-body p-0" style="display: flex; align-items: center; justify-content: center; overflow: hidden; height: calc(100% - 2.5rem);">
        <a href="https://www.thecloroxcompany.com/brands/" target="_blank">
            <img src="https://www.wordstream.com/wp-content/uploads/2021/07/persuasive-ads-trusted-by-moms.jpg" alt="Ads of Clorox product" style="width: 100%; height: 100%; object-fit: cover;">
        </a>
    </div>
    </div>
    </div>
    
    <div class="card bg-light mb-3" style="border: 0; width: 260px; height: 520px;">
    <div class="card-header bg-warning text-white text-uppercase" style="padding: 0.75rem; text-align: center;">
        Advertisement
    </div>
    <div class="card-body p-0" style="display: flex; align-items: center; justify-content: center; overflow: hidden; height: calc(100% - 2.5rem);">
        <a href="https://www.bk.com" target="_blank">
            <img src="https://www.gourmetads.com/wp-content/uploads/2019/05/fast-food-ads-burger-king-300x600.jpg" alt="Ads of BurgerKing" style="width: 100%; height: 100%; object-fit: cover;">
        </a>
    </div>
</div>

    
</div>
