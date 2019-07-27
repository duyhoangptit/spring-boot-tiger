# Thymeleaf vận hành + Expression
- Thymeleaf là một template engine. Có nhiệm vụ xử lý và gen ra các file html, xml...
- Expression:
    + ${...}: Giá trị của một biến lấy từ cục bộ hoặc model.
    + *{...}: Giá trị của một biến được chỉ định (sẽ giải thích ở dưới). Dấu * là asterisk syntax. sẽ lấy được các field được định nghĩa trong th:object
    + #{...}: Lấy message được định nghĩa trong file message.properties.
    + @{...}: Lấy đường dẫn URL dựa theo context của server

https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_todo


# Using redis save data in memory

# Using jasypt encrypt password, username in file config db.
https://www.baeldung.com/spring-boot-jasypt

Lưu ý: Có nhiều cách thực hiện

- Config theo encrypt mặc định của jasypt

- Config custom sử dụng bean tự định nghĩa khác name `jasyptStringEncryptor` thì cần định nghĩa vào file properties là bean nào được sử dụng<br> 

    `@Bean(name = "encryptorBean")
    public StringEncryptor stringEncryptor() {`
    
    File .properties: <br>
    `jasypt.encryptor.bean=encryptorBean`
- Nếu sử dụng bean có name `jasyptStringEncryptor` thì phải sử dụng annotation `@EnableEncryptableProperties` để enable config encrypt lên.
