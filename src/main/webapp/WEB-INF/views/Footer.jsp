<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer Page</title>
    <style>
        /* CSS cho phần chân trang */
        .footer-top-line {
            width: 100%;
            height: 4px; /* Độ dày của đường viền */
            background-color: #000; /* Màu của đường viền */
            margin-bottom: 20px; /* Khoảng cách giữa đường viền và nội dung chân trang */
        }

        footer {
            background-color: rgb(33, 37, 41); /* Màu nền của footer */
            color: #fff; /* Màu chữ trong footer */
            padding: 20px 0; /* Padding cho chân trang */
        }

        footer .container {
            padding: 2rem 0; /* Padding cho container trong chân trang */
        }

        footer .row {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        footer .col-md-3, 
        footer .col-md-4 {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        footer .copyright {
            display: flex;
            justify-content: center;
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Nội dung trang web khác -->
	<br/>
	<br/>
    <footer class="text-light">
        <div class="footer-top-line"></div> <!-- Dòng đen ở đầu footer -->
        <div class="container">
            <div class="row justify-content-center">
                <!-- About Section -->
                <div class="col-md-3 col-lg-4 col-xl-3 text-center">
                    <h5>Giới thiệu</h5>
                    <hr class="mb-2 mt-0 d-inline-block mx-auto w-25">
                    <p class="mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phẩm giày nhập từ các brand nổi tiếng thế giới.</p>
                </div>

                <!-- Member List Section -->
                <div class="col-md-4 col-lg-3 col-xl-3 text-center">
                    <h5>Danh sách thành viên</h5>
                    <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                    <ul class="list-unstyled">
                        <li><i class="fa fa-envelope mr-2"></i> 18125059 - Văn Duy An</li>
                        <li><i class="fa fa-envelope mr-2"></i> 21125141 - Trần Thúc Minh Trí</li>
                        <li><i class="fa fa-envelope mr-2"></i> 1751101 - Ngô Hoàng Bảo Thạch</li>
                    </ul>
                </div>

                <!-- Copyright Section -->
                <div class="col-12 text-center mt-3">
                    <p class="float-left">
                        <a href="#">Back to top</a>
                    </p>
                    <p class="text-right text-muted">
                        created with <i class="fa fa-heart"></i> by <a href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a>
                        | <span>v. 1.0</span>
                    </p>
                </div>
            </div>
        </div>
    </footer>

    <!-- Các tập lệnh JS của bạn -->
</body>
</html>
