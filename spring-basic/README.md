# SOLID

- Single Responsibility Principle(nguyên tắc)
    `1 trong những nguyên lý thiết kế OOP. Là nguyên lý đơn trách nhiệm. Nội dung như sau:
    Một class chỉ nên giữ một trách nhiệm duy nhất. Như vậy khi thay đổi requiment thì giúp chúng ta dễ dàng maintain hơn.
    Tốn ít chi phí sửa chữa và bảo trì hơn.`

- Open/Closed Principle
    `Có thể thoải mái mở rộng 1 module, nhưng hạn chế sửa đổi bên trong module đó. Cần kế thừa những phần sẵn có để mở rộng
    thay vì update nó.`

- Liskov substitution(thay thế) Principle
    `Trong một chương trình, các object của class con có thể thay thế class cha mà không làm thay đổi tính đúng đắn của chương trình`

- Interface Segregation(phân chia) Principle
    `Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với nhiều mục đích cụ thể.
    Để thiết kế một hệ thống linh hoạt, dễ dàng thay đổi, các module của hệ thống nên giao tiếp thông qua interface.
    Mỗi module sẽ gọi chức năng của module khác thông qua interface mà ko quan tâm tới implementation bên dưới`
    
- Dependency inversion Principle
    1. Các module cấp cao không nên phụ thuộc vào các module cấp thấp. Cả 2 nên phụ thuộc vào abstraction
    
    2. Interface (abstraction) không nên phụ thuộc vào chi tiết, mà ngược lại. Các class giao tiếp với nhau thông qua interface,
    không phải thông qua implementation.
    
    `Pattern Dependency Injection để đảm bảo nguyên lý dependency inversion principle` 


# Tight coupling & loosely coupled

 1. Tight coupling

    - Liên kết chặt chẽ.

 2. Loosely coupled
 
    - Liên kết lỏng lẻo hơn.
 
 
# Dependency injection

- Là một Design pattern...

- Các class không nên phụ thuộc vào các kế thừa cấp thấp, mà nên phụ thuộc vào Abstraction(lớp trừu tượng)
    
- Dependency Injection là việc các object nên phụ thuộc vào `Abstraction` và thể hiện chi tiết của chúng sẽ được
    load lúc `Inject`.
    
- Các cách inject dependency:
    + Contructor Injection
    + Setter injection
    + Interface injection
    
#Inversion Of Control

- `Dependency Injection` giúp chúng ta dễ dàng mở rộng code và giảm sự phụ thuộc giữa các dependency
    với nhau. Tuy nhiên việc lúc này chúng ta phải kiêm nhiệm vụ inject dependency(Tiêm sự phụ thuộc).
    
- Khi tình huống trên xảy ra, mình sẽ phải tính làm cách nào để định nghĩa chung nó ở một chỗ, lúc cần chỉ việc gọi nó ra
    + Vậy chúng ta cần định nghĩa toàn bộ các dependency trước rồi để nó vào một cái kho(container).
    + Vậy Invertion of control sinh ra để làm nhiệm vụ này. Nó sẽ hoạt động theo một khung dựng sẵn chứ không để cho 
    hệ thống kiểm sát.(Spring framework và Google guice).


# Interface
- Các đặc điểm của interface
    + You cannot instantiate an interface.
    + An interface does not contain any constructors.
    + All of the methods in an interface are abstract.
    + An interface cannot contain instance fields. The only fields that can appear in an interface must be declared both static and final.
    + An interface is not extended by a class; it is implemented by a class.
    + An interface can extend multiple interfaces.
    
# SOAP & REST

1. SOAP (Simple Object Access Protocol)
    - SOAP: XML, HTTP
    + là `giao thức` truy cập WebServices được sử dụng trong một thời gian và hưởng tất cả các lợi ích của việc sử dụng lâu dài.
    + SOAP thì `không thể sử dụng rest` bởi vì nó là một giao thức
    + SOAP cung cấp các `giao diện dịch vụ` cho các thành phần bên ngoài sử dụng.
    + SOAP định nghĩa các` chuẩn riêng, quy tắc nghiêm ngặt`.
    + SOAP định nghĩa `chuẩn bảo mật riêng nó`
    + SOAP chỉ hỗ trợ `định dạng dữ liệu là XML`
    + SOAP Ít người sử dụng hơn REST
    + Được thiết kế trong môi `trường tính toán phân tán`.
    + Tin cậy hơn dùng REST
    + Hỗ trợ hầu hết các `chuẩn bảo mật, tin cậy và giao dịch`
    + SOAP hỗ trợ 2 giao thức: SMTP, HTTP
    
    *** Ưu điểm
    + Sử dụng ngôn ngữ, nền tảng, phương tiện độc lập(Rest yêu cầu sử dụng giao thức http)
    + Hoạt động tốt trong các môi trường doanh nghiệp
    + Tiêu chuẩn hóa
    + Cung cấp khả năng mở rộng
    + Tích hợp xử lý lỗi
    + Tự động hóa khi sử dụng với

2. Rest (Representational State Transfer)
    + Là một cách thiết kế kiến trúc.
    + Rest có thẻ sử dụng WS sử dụng SOAP vì nó có thể sử dụng bất kỳ giao thức nào như http, SOAP
    + Sử dụng URI đẻ cung cấp các dịch vụ.
    + Không có các tiêu chuẩn như SOAP
    + Kế thừa chuẩn bảo mật tầng vận tải của giao thức mạng.
    + Định dạng dữ liệu đa dạng: XML, JSON, TEXT, HTML
    + Thường k áp dụng trong môi trường phân tán.
    + Ít tin cậy hơn nếu người dùng không kiểm soát nó. Ví dụ http delete có thể trả về ok ngay cả khi ko delete được dữ liệu.
    + Các phương thức DELETE và PUT thường bị vô hiệu hóa bởi tường lửa hoặc vấn đề bảo mật
    + Gắn với giao thức HTTP.
    
    - JSON, PO_XML, RSS/ ATOM, HTTP
    - Có 5 hình thái trên Rest: GET, POST, PUT, DELETE, PATCH
    
# Autowiring trong Spring, annotation @Autowired trong Spring, các kiểu autowiring

1. Các loại Auto-wiring trong Spring

- Có 5 loại Auto-wiring
    + Auto-wiring ‘no’
    + Auto-wiring ‘byName’
    + Auto-wiring ‘byType’
    + Auto-Wiring ‘constructor’
    + Auto-Wiring ‘autodetect’ -> từ spring 3 đã bỏ autodetect