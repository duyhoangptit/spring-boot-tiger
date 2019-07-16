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

# Spring AOP(Spring Aspect Oriented Programming)

1. Spring AOP là `một thành phần chính trong Spring FW. Lập trình hướng khía cạnh APE đòi hỏi phải vỡ logic chương trình thành
các thành phần riêng biệt. AOP phát triển dựa trên OOP chứ không phải ra đời để thay thế OOP.`

+ Aspect<br>
    `Một Aspect là một class mà nó có thể cắt xuyên qua nhiều class, ví dụ như Transaction Manager. Chúng ta có thể tạo ra 
    class Aspect bằng cách thông thường là config trong xml hoặc dùng Ann @Aspect annotation. Đây chính là class mà chúng ta
    muốn tạo ra, và nó sẽ được liên kết với các class khác trong project tùy theo cách implement của mình.`

+ Join point<br>
    `Việc class Aspect liên kết với các class khác thì sẽ bằng cách nào. Join point là một phần trong đó, với mỗi class 
    thì sẽ có các function, thì những func mà sẽ được dùng để liên kết với class Aspect chính là các joinpoin.`
  
+ Advice<br>
    `Khi mà class Aspect liên kết với các kết khác thì chắc chắn nó sẽ thực thi một việc gì đó tương ứng khi một liên kết
    với joinPoint được thực hiện.`

+ PointCut<br>
    `Ở các concept trên ta có thể hình dung đơn giản như sau. 1 class aspect nó sẽ có các function ở tại class đó(Chính là các
    Advice) và nó muốn liên kết với các class khác bằng cách thông qua việc liên kết tới các function ở các class đó(chính
    là các funcPoint). Nhưng làm cách nào để có thể liên kết tới được các JoinPoint? Thì PointCut sẽ thưc hiện công việc
    này. PointCut thực ra chính là các hiểu thức, nó giống như là một câu lệnh để cho chương trình hiểu việc nó muốn liên kết 
    tới class nào, func nào.`

+ Introduction<br>
    ``

+ Target object<br>
    ``

+ Weaving<br>
    ``
    
### Một số kiểu Advice trong AOP

+ Before Advice
    `Những advice này sẽ được chạy trước khi thực thi các JoinPoint method`
    
+ After (finally) Advice

    `Nó giống như finally trong try catch vậy. Tức là sau khi các Joinpoint method được thực thi, bất kể nó có thành công
    , hay bị exception thì cuối cùng các advice này vẫn được chạy qua.`
    
+ After Returning Advice

    `Trong trường hợp chúng ta chỉ muốn thực hiện advice sau khi các joinPoint thực thi bình thường, không bị lỗi exception
    thì sẽ dùng tới loại này`
    
+ After Throwing Advice
    `Tương tự ở trên nhưng trường hợp này chúng ta chỉ thực hiện advice sau khi các JointPoint thực thi mà throw ra exception.`

+ Around Advice
    `Đây là loại Advice quan trọng nhất cũng như mạnh mẽ nhất. Advice này sẽ được thực thi bao quanh JoiPoint, khi đó 
    chúng ta có thể đưa ra quyết định có thực thi JoinPoint hay không. Chúng ta cũng có thể viết code để cho advice có thể chạy trước hoặc sau JoinPoint tùy thích. 
    Có thể nói nó có chức năng của tất cả các loại Advice khác có thể làm được.`