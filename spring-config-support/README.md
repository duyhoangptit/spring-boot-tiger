# Spring config support

1. Spring security

- Giới thiệu: Spring security là một trong những core feature quan trọng của Spring FW, nó giúp chúng ta phần quyền xác
 thực người dùng trước khi cho họ truy cập vào tài nguyên của chúng ta.
 
- Có thể kích hoạt tính năng Web Security bằng cách sử dụng config annotation sau

`@EnableWebSecurity`

- Tạo một config security bằng cách implement WebSecurityConfigurerAdapter để giúp cài đặt dễ dàng hơn.

- Có 2 Bean cần quan tâm là UserDetailsService và @Override method configure.

`UserDetailsService` <br>
// Tạo ra user trong bộ nhớ
// lưu ý, chỉ sử dụng cách này để minh họa
// Còn thực tế chúng ta sẽ kiểm tra user trong csdl
InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
manager.createUser(
        User.withDefaultPasswordEncoder() // Sử dụng mã hóa password đơn giản
            .username("loda")
            .password("loda")
            .roles("USER") // phân quyền là người dùng.
            .build()
);
return manager;

`configure`<br>
http
    .authorizeRequests()
        .antMatchers("/", "/home").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
        .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
        .and()
    .formLogin() // Cho phép người dùng xác thực bằng form login
        .defaultSuccessUrl("/hello") // Trang sẽ redirect đến khi thực hiện login thành công.
        .permitAll() // Tất cả đều được truy cập vào địa chỉ này
        .and()
    .logout() // Cho phép logout
        .permitAll();

2. Cách sử dụng spring security

- Step 1: Tạo model User ứng với table User trong database

- Step 2: Tạo một Repo để load các thông tin từ bảng User theo username...

- Step 3: Tham chiếu model User với UserDetails của Spring Security

- Step 4: Tạo một class UserService implements từ UserDetailsService của Spring security
        Load thông tin user từ database tới User custom từ Step 1.
- Step 5: Cấu hình và phân quyền.