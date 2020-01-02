# spring-tiger-authen

Authorization Framework:<br>
    access_token<br>
    refresh_token<br>

1 - Hiểu mô hình xác thực giữa Client - Server.

Resource Owner: là chủ sở hữu của dữ liệu ta muốn chia sẻ. Chẳng hạn, bạn muốn chia sẻ thông tin email + username facebook của bạn cho Viblo để có thể đăng nhập Viblo qua facebook, thì ở đây, thông tin email + username này là tài nguyên cần chia sẻ (resource), còn bạn chính là resource owner.

Resource Server: là server nơi chứa thông tin dữ liệu cần chia sẻ. Server này phải có khả năng nhận và trả lời các yêu cầu (request) truy xuất dữ liệu. Như ở ví dụ trên của chúng ta thì resource server chính là facebook.

Client: Là những chương trình, ứng dụng có như cầu muốn sử dụng tài nguyên được chia sẻ. Như trong ví dụ trên thì client chính là ứng dụng Viblo.

Authorization Server: Là đối tượng quyết định việc cấp quyền truy cập vào dữ liệu cho client. Như trong ví dụ trên, đây chính là authorization server của facebook. Đôi khi resource server và authorization server có thể là một , nhưng về mặt chức năng mà nói, đây là 2 chức năng hoàn toàn riêng biệt.


2 - Hiểu The OAuth 2.0 Authorization Framework.

3 - Hiểu vì sao cần sử dụng OAuth 2.0 Authorization.