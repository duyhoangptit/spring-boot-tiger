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
https://viblo.asia/p/aop-la-gi-uu-nhuoc-diem-cua-aop-aspect-oriented-programming-trong-java-3P0lPk2oZox

1. Spring AOP là `một thành phần chính trong Spring FW. Lập trình hướng khía cạnh APE đòi hỏi phải vỡ logic chương trình thành
các thành phần riêng biệt. AOP phát triển dựa trên OOP chứ không phải ra đời để thay thế OOP.`

+ Aspect<br>
    `Một Aspect là một class mà nó có thể cắt xuyên qua nhiều class, ví dụ như Transaction Manager. Chúng ta có thể tạo ra 
    class Aspect bằng cách thông thường là config trong xml hoặc dùng Ann @Aspect annotation. Đây chính là class mà chúng ta
    muốn tạo ra, và nó sẽ được liên kết với các class khác trong project tùy theo cách implement của mình.`

+ Join point<br>
    `Việc class Aspect liên kết với các class khác thì sẽ bằng cách nào. Join point là một phần trong đó, với mỗi class 
    thì sẽ có các function, thì những func mà sẽ được dùng để liên kết với class Aspect chính là các joinpoin.
    Join poin là một điểm của chương trình, nơi có thể chèn những custom action của bạn`
  
+ Advice<br>
    `Khi mà class Aspect liên kết với các kết khác thì chắc chắn nó sẽ thực thi một việc gì đó tương ứng khi một liên kết
    với joinPoint được thực hiện. Vậy Advice là những xử lý được thêm vào xử lý chính.`

+ PointCut<br>
    `Ở các concept trên ta có thể hình dung đơn giản như sau. 1 class aspect nó sẽ có các function ở tại class đó(Chính là các
    Advice) và nó muốn liên kết với các class khác bằng cách thông qua việc liên kết tới các function ở các class đó(chính
    là các funcPoint). Nhưng làm cách nào để có thể liên kết tới được các JoinPoint? Thì PointCut sẽ thưc hiện công việc
    này. PointCut thực ra chính là các biểu thức, nó giống như là một câu lệnh để cho chương trình hiểu việc nó muốn liên kết 
    tới class nào, func nào. Việc Point cut là cách dùng để xác định join poin.`

+ Introduction<br>
    ``

+ Target object<br>
    ``

+ Weaving<br>
    ``
    
*** Ưu điểm:<br>
    + Thiết kế đơn giản: "You aren't gonna need it" chúng ta chỉ cài đặt những thứ chúng ta thực sự cần mà không bao h cài đặt
    trước
    + Cài đặt chương trình một cách trong sáng: Mỗi module chỉ cần làm cái mà nó càn phải làm, giải quyết được hai vấn đề code tangling
    và code scattering.
    
    + Tái sử dụng dễ dàng
    
*** Nhược điểm<br>
    + Khái niệm khá trừu trượng, độ trừu tượng của chương trình cao
    + Luồng chương trình phức tạp
    
`(new Constants(CustomizableTraceInterceptor.class)).getValues("PLACEHOLDER_");`
### Một số kiểu Advice trong AOP

+ Before Advice<br>
    `Những advice này sẽ được chạy trước khi thực thi các JoinPoint method`
    
+ After (finally) Advice<br>

    `Nó giống như finally trong try catch vậy. Tức là sau khi các Joinpoint method được thực thi, bất kể nó có thành công
    , hay bị exception thì cuối cùng các advice này vẫn được chạy qua.`
    
+ After Returning Advice<br>

    `Trong trường hợp chúng ta chỉ muốn thực hiện advice sau khi các joinPoint thực thi bình thường, không bị lỗi exception
    thì sẽ dùng tới loại này`
    
+ After Throwing Advice<br>
    `Tương tự ở trên nhưng trường hợp này chúng ta chỉ thực hiện advice sau khi các JointPoint thực thi mà throw ra exception.`

+ Around Advice<br>
    `Đây là loại Advice quan trọng nhất cũng như mạnh mẽ nhất. Advice này sẽ được thực thi bao quanh JoiPoint, khi đó 
    chúng ta có thể đưa ra quyết định có thực thi JoinPoint hay không. Chúng ta cũng có thể viết code để cho advice có thể chạy trước hoặc sau JoinPoint tùy thích. 
    Có thể nói nó có chức năng của tất cả các loại Advice khác có thể làm được.`

# Một số cách thực hiện AOP
    AspectJ
    Spring AOP
    JBoss AOP


# Using annotation AspectJ 
[https://docs.spring.io/spring/docs/3.0.x/reference/aop.html]
 
    + @Before: Chạy trước khi method được thực thi
    + @After: Chạy sau khi method trả về một kết quả
    + @AfterReturning: Chạy sau khi method trả về một kết quả, lọc lấy kết quả trả về
    + @AfterThrowing: Chạy khi method xảy ra exception
    + @Around: Gồm các tất cả các advice trên
    + @Aspect: Đánh dấu đây là 1 aspect
    
`Tất cả các phần ngoại trừ mẫu kiểu trả về (kiểu ret-type trong đoạn trích ở trên), 
mẫu tên và mẫu tham số là tùy chọn. Mẫu kiểu trả về xác định kiểu trả về của phương thức phải là gì để điểm nối được khớp.
 Thường xuyên nhất bạn sẽ sử dụng * làm mẫu kiểu trả về, khớp với bất kỳ kiểu trả về nào.
  Tên loại đủ điều kiện sẽ chỉ khớp khi phương thức trả về loại đã cho. Mẫu tên khớp với tên phương thức.
   Bạn có thể sử dụng ký tự đại diện * như tất cả hoặc một phần của mẫu tên. Mẫu tham số phức tạp hơn một chút:
    () khớp với phương thức không có tham số, trong khi (..) khớp với bất kỳ số lượng tham số nào (không hoặc nhiều hơn).
     Mẫu (*) khớp với một phương thức lấy một tham số thuộc bất kỳ loại nào, (*, Chuỗi) khớp với một phương thức lấy
      hai tham số, đầu tiên có thể là bất kỳ loại nào, thứ hai phải là Chuỗi. Tham khảo phần Ngữ nghĩa ngôn ngữ của
       Hướng dẫn lập trình AspectJ để biết thêm thông tin.`
       
the execution of any public method:

- execution(public * *(..))
the execution of any method with a name beginning with "set":

- execution(* set*(..))
the execution of any method defined by the AccountService interface:

- execution(* com.xyz.service.AccountService.*(..))
the execution of any method defined in the service package:

- execution(* com.xyz.service.*.*(..))
the execution of any method defined in the service package or a sub-package:

- execution(* com.xyz.service..*.*(..))
- any join point (method execution only in Spring AOP) within the service package:

within(com.xyz.service.*)
- any join point (method execution only in Spring AOP) within the service package or a sub-package:

within(com.xyz.service..*)
- any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:

this(com.xyz.service.AccountService)

'this' is more commonly used in a binding form :- see the following section on advice for how to make the proxy object available in the advice body.

- any join point (method execution only in Spring AOP) where the target object implements the AccountService interface:

target(com.xyz.service.AccountService)

'target' is more commonly used in a binding form :- see the following section on advice for how to make the target object available in the advice body.

- any join point (method execution only in Spring AOP) which takes a single parameter, and where the argument passed at runtime is Serializable:

args(java.io.Serializable)
'args' is more commonly used in a binding form :- see the following section on advice for how to make the method arguments available in the advice body.

Note that the pointcut given in this example is different to execution(* *(java.io.Serializable)): the args version matches if the argument passed at runtime is Serializable, the execution version matches if the method signature declares a single parameter of type Serializable.

- any join point (method execution only in Spring AOP) where the target object has an @Transactional annotation:

@target(org.springframework.transaction.annotation.Transactional)

'@target' can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.

- any join point (method execution only in Spring AOP) where the declared type of the target object has an @Transactional annotation:

@within(org.springframework.transaction.annotation.Transactional)

'@within' can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.

- any join point (method execution only in Spring AOP) where the executing method has an @Transactional annotation:

@annotation(org.springframework.transaction.annotation.Transactional)

'@annotation' can also be used in a binding form :- see the following section on advice for how to make the annotation object available in the advice body.

- any join point (method execution only in Spring AOP) which takes a single parameter, and where the runtime type of the argument passed has the @Classified annotation:

@args(com.xyz.security.Classified)

'@args' can also be used in a binding form :- see the following section on advice for how to make the annotation object(s) available in the advice body.

- any join point (method execution only in Spring AOP) on a Spring bean named 'tradeService':

bean(tradeService)
- any join point (method execution only in Spring AOP) on Spring beans having names that match the wildcard expression '*Service':

bean(*Service)