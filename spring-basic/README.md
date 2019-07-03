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