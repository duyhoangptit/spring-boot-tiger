# HikariCP là JDBC connection pool có hiệu năng cao, rất nhẹ (chỉ khoảng 130kb),
    được phát triển bởi Brett Wooldridge (năm 2012) và vẫn đang được cập nhật liên tục.

    HikariCP có nhiều tính năng mà chính tác giả cũng đã ca ngợi:

       Kiểm tra các kết nối tại chính method getConnection()
       Đóng gói các internal pool query (bao gồm test query và initSQL query) trong transaction của chúng
       Theo dõi và đóng các đối tượng Statement (đã hết sử dụng) tại Connection.close()
       Thực hiện rollback() trên các Connection được trả về trong pool
       Xóa SQL warning trước khi trả một Connection về cho client
       Thiết lập mặc định auto-commit, mức cô lập cho transaction, catalog và trạng thái chỉ đọc (read-only)
       Kiểm tra các đối tượng SQLException để tìm ra các lỗi mất kết nối

#  H2database
https://viblo.asia/p/spring-boot-angularjs-spring-data-jpa-crud-app-example-3Q75wD8QKWb
https://o7planning.org/vi/11895/cai-dat-co-so-du-lieu-h2-va-su-dung-h2-console

#  Config JPA

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.6</version>
</dependency>

Version 5.1.6 thì đi vs config hibernate
    spring.datasource.config.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
và
    spring.datasource.config.driverClassName=com.mysql.jdbc.Driver

Nếu là bản
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.13</version>
</dependency>

thì đi với config hibernate
    spring.datasource.config.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
vả
    spring.datasource.config.url=jdbc:mysql://localhost:3306/db_todo_list?useLegacyDatetimeCode=false&serverTimezone=UTC
và
    spring.datasource.config.driverClassName=com.mysql.cj.jdbc.Driver

# Spring boot jpa auditing

###. Hibernate là gì?
- Là một thư viện ORM(object Relation Mapping) mà nguồn mở giúp các lập trình viên mapping data vs Object trong java
trong các hệ quản trị cở sở dữ liệu. Là một layer trung gian giữa database và ứng dụng. Giúp cho ứng dụng trong suốt với tầng DB. 

- Hibernate sinh ra để giải quyết các nhược điểm của JDBC như: 
    + Có nhiều code thừa chỉ phục vụ cho mục đích lấy dữ liệu
    + Mất nhiều thời gian mapping data với object Java
    + Sẽ tốn công sức khi hệ thống thay đổi CSDL.
    + Giao tiếp giữa các bảng thường khó, thiếu tính OOP trong đó.
    
- Nhược điểm
    + Vẫn chưa dễ dàng cho người sử dụng
    + Không hỗ trợ các câu lệnh truy vẫn phức tạp
    + Một số trường hợp vẫn phải dùng native sql do hibernate không thể cover tất cả các cú pháp của hệ quản trị CSDL
    + Bị hạn chế can thiệp vào sql do nó được tự động sinh ra.
    
###. Spring JPA là gì?
- Là một phần trong hệ sinh thái Spring Data, nó tạo ra một layer ở giữa tầng service và database, chúng giúp thao tác với DB
dễ dàng hơn, tự động config và giảm thiểu code thừa thãi,
- Spring JPA đã wrapper hibernate và tạo ra một interface mạnh mẽ. 
- Sử dụng interface `JpaRepository` ta cần cung cấp 2 thông tin sau:
    + Entity(Đối tượng ứng với table) 
    + Kiểu dữ liệu của khóa chính (primary key).
    
- Custom JPARepository.
    + Create interface custom repo
    + Create interface extends JpaRepository and custom repo.
    + Create implementation from interface custom and execute method of interface custom.

### Auditing
- Theo dõi và logging các event liên quan tới Entity như insert, update, delete hay thậm trí là thay đổi version Entity

- Using Auditing spring:
    + @EnableJpaAuditing
    + // Bạn phải đánh dấu class bởi @EntityListeners(AuditingEntityListener.class)
      // Đây là Một đối tượng Listener, lắng nghe sự kiện insert hoặc update của đối tượng
      // Để từ đó tự động cập nhật các trường @CreatedDate và @LastModifiedDate
      @EntityListeners(AuditingEntityListener.class)
      @CreatedDate
      @LastModifiedDate
      
### Paging Spring JPA
    // Lấy ra 5 user đầu tiên
    // PageRequest.of(0,5) tương đương với lấy ra page đầu tiên, và mỗi page sẽ có 5 phần tử
    Page<User> page = userRepository.findAll(PageRequest.of(0, 5));
    // In ra 5 user đầu tiên
    System.out.println("In ra 5 user đầu tiên: ");
    page.forEach(System.out::println);
    // Lấy ra 5 user tiếp theo
    page = userRepository.findAll(page.nextPageable());
    
    System.out.println("In ra 5 user tiếp theo: ");
    page.forEach(System.out::println);
    
    System.out.println("In ra số lượng user ở page hiện tại: " + page.getSize());
    System.out.println("In ra tổng số lượng user: " + page.getTotalElements());
    System.out.println("In ra tổng số page: " + page.getTotalPages());
    
    // Lấy ra 5 user ở page 1, sort theo tên
    page = userRepository.findAll(PageRequest.of(1, 5, Sort.by("name").descending()));
    System.out.println("In ra 5 user page 1, sắp xếp theo name descending:");
    page.forEach(System.out::println);
    
    // Custom method
    List<User> list = userRepository.findAllByNameLike("name-%", PageRequest.of(0, 5));
    System.out.println(list);