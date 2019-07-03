# Thymeleaf vận hành + Expression
- Thymeleaf là một template engine. Có nhiệm vụ xử lý và gen ra các file html, xml...
- Expression:
    + ${...}: Giá trị của một biến lấy từ cục bộ hoặc model.
    + *{...}: Giá trị của một biến được chỉ định (sẽ giải thích ở dưới). Dấu * là asterisk syntax. sẽ lấy được các field được định nghĩa trong th:object
    + #{...}: Lấy message được định nghĩa trong file message.properties.
    + @{...}: Lấy đường dẫn URL dựa theo context của server

https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_todo
