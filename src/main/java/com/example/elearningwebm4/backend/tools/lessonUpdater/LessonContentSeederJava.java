package com.example.elearningwebm4.backend.tools.lessonUpdater;

import com.example.elearningwebm4.backend.repositories.ILessonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LessonContentSeederJava implements CommandLineRunner {

    private final ILessonRepository lessonRepository;

    public LessonContentSeederJava(ILessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        updateLessonContent(1L, """
<h2>Bài 1: Lớp và Đối tượng (Class & Object)</h2>

<p><strong>Lớp (Class)</strong> là một <em>khuôn mẫu</em> (template/blueprint) dùng để mô tả <strong>thuộc tính</strong> (data fields) và <strong>hành vi</strong> (methods) của một nhóm đối tượng. Một lớp <em>không chiếm bộ nhớ</em> cho đến khi có đối tượng cụ thể được tạo từ nó.</p>

<p><strong>Đối tượng (Object)</strong> là <em>thực thể cụ thể</em> được tạo ra từ lớp, có trạng thái riêng và hành vi riêng biệt.</p>

<h3>Cấu trúc lớp trong Java:</h3>

<pre><code>class ClassName {
    // Thuộc tính
    // Phương thức
}</code></pre>

<h3>Ví dụ về lớp và đối tượng:</h3>

<pre><code>class Student {
    String name;
    int age;

    void study() {
        System.out.println(name + " is studying.");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "An";
        student1.age = 20;
        student1.study();
    }
}
</code></pre>

<h3>Mối liên hệ giữa Lớp và Đối tượng:</h3>

<table class="table table-bordered">
  <thead>
    <tr>
      <th>Lớp (Class)</th>
      <th>Đối tượng (Object)</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Khuôn mẫu thiết kế</td>
      <td>Thực thể cụ thể từ lớp</td>
    </tr>
    <tr>
      <td>Không chiếm bộ nhớ</td>
      <td>Chiếm bộ nhớ</td>
    </tr>
    <tr>
      <td>Định nghĩa chung thuộc tính & hành vi</td>
      <td>Chứa giá trị cụ thể, thực thi hành vi</td>
    </tr>
  </tbody>
</table>

<h3>Lợi ích khi sử dụng Lớp và Đối tượng:</h3>
<ul>
  <li>Code rõ ràng, dễ bảo trì.</li>
  <li>Hỗ trợ tái sử dụng, mở rộng.</li>
  <li>Gắn liền với các nguyên lý OOP: đóng gói, kế thừa, đa hình.</li>
</ul>

<h3>Ví dụ thực tế nhiều đối tượng:</h3>

<pre><code>class Student {
    String name;
    int age;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Entry {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Linh";
        student1.age = 24;

        Student student2 = new Student();
        student2.name = "Phong";
        student2.age = 22;

        student1.displayInfo();
        student2.displayInfo();
    }
}
</code></pre>

<h3>Tổng kết:</h3>
<p>
- <strong>Lớp</strong> là thiết kế chung.<br>
- <strong>Đối tượng</strong> là thực thể cụ thể từ lớp.<br>
- Sử dụng lớp và đối tượng giúp chương trình <em>dễ mở rộng</em> và <em>dễ bảo trì</em> hơn.
</p>
""");


        updateLessonContent(2L, """
<h2>Bài 2: Biến tĩnh và Phương thức tĩnh (Static Variables and Methods)</h2>

<p><strong>Static</strong> là từ khóa trong Java dùng để khai báo các thành phần mà không phụ thuộc vào đối tượng (instance) của lớp. Các thành phần static thuộc về lớp, chứ không thuộc riêng một đối tượng cụ thể.</p>

<h3>1. Biến tĩnh (Static Variables)</h3>

<p>- Một biến tĩnh được chia sẻ chung giữa tất cả các đối tượng của lớp.<br>
- Biến static chỉ được cấp phát bộ nhớ một lần duy nhất khi chương trình chạy, lúc lớp được nạp vào bộ nhớ JVM.</p>

<h4>Ví dụ:</h4>

<pre><code>class Student {
    int id;
    String name;
    static String school = "ABC University";

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name + " " + school);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "An");
        Student s2 = new Student(2, "Binh");

        s1.display();
        s2.display();
    }
}
</code></pre>

<p><em>Kết quả:</em></p>
<pre><code>1 An ABC University
2 Binh ABC University
</code></pre>

<h3>2. Phương thức tĩnh (Static Methods)</h3>

<p>- Phương thức static có thể được gọi trực tiếp từ tên lớp mà không cần tạo đối tượng.<br>
- Phương thức static chỉ có thể truy cập các biến static và gọi các phương thức static khác.</p>

<h4>Ví dụ:</h4>

<pre><code>class MathUtil {
    static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        int result = MathUtil.add(5, 10);
        System.out.println("Result: " + result);
    }
}
</code></pre>

<h3>3. Quy tắc khi sử dụng static</h3>
<ul>
  <li>Không thể sử dụng biến non-static trực tiếp trong phương thức static.</li>
  <li>Không thể sử dụng từ khóa <code>this</code> trong phương thức static.</li>
</ul>

<h3>4. Ứng dụng thực tế của static</h3>
<ul>
  <li>Quản lý tài nguyên chung (ví dụ: số lượng đối tượng đã tạo).</li>
  <li>Các hàm tiện ích như tính toán toán học (Math class).</li>
  <li>Chia sẻ hằng số giữa nhiều đối tượng (final static).</li>
</ul>

<h3>5. Một số lỗi phổ biến</h3>
<ul>
  <li>Gọi biến instance trong phương thức static (sẽ báo lỗi compile).</li>
  <li>Nhầm lẫn giữa biến static và biến non-static dẫn đến lỗi dữ liệu khi làm việc đa luồng.</li>
</ul>

<h3>6. Tips khi dùng static</h3>
<ul>
  <li>Chỉ nên dùng static khi thật sự cần thiết chia sẻ dữ liệu hoặc chức năng.</li>
  <li>Tránh lạm dụng static vì nó làm giảm tính mềm dẻo (flexibility) của lập trình hướng đối tượng.</li>
</ul>

<h3>Tổng kết:</h3>
<p>Static giúp chia sẻ dữ liệu hoặc phương thức chung giữa tất cả các đối tượng. Tuy nhiên cần cẩn thận sử dụng để đảm bảo đúng nguyên lý OOP và tránh lỗi thiết kế hệ thống.</p>
""");


        updateLessonContent(3L, """
<h2>Bài 3: Tính đóng gói (Encapsulation)</h2>

<p><strong>Encapsulation</strong> (đóng gói) là quá trình che giấu dữ liệu bên trong lớp và chỉ cho phép truy cập thông qua các phương thức công khai (getter/setter). Đây là một trong bốn nguyên lý cơ bản của lập trình hướng đối tượng (OOP).</p>

<h3>1. Mục đích của Encapsulation</h3>
<ul>
  <li>Giúp bảo vệ dữ liệu khỏi truy cập trái phép hoặc sửa đổi ngoài ý muốn.</li>
  <li>Kiểm soát cách dữ liệu được truy cập hoặc thay đổi.</li>
  <li>Tăng tính bảo mật và toàn vẹn cho đối tượng.</li>
</ul>

<h3>2. Cách thực hiện Encapsulation trong Java</h3>
<ul>
  <li>Khai báo các biến instance là <code>private</code>.</li>
  <li>Cung cấp các phương thức <code>public</code> (getter và setter) để truy cập và cập nhật giá trị của các biến này.</li>
</ul>

<h4>Ví dụ:</h4>

<pre><code>class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account acc = new Account();
        acc.deposit(500);
        acc.withdraw(200);
        System.out.println(\"Current Balance: \" + acc.getBalance());
    }
}
</code></pre>

<p><em>Kết quả:</em></p>
<pre><code>Current Balance: 300.0
</code></pre>

<h3>3. Tại sao nên đóng gói dữ liệu?</h3>
<ul>
  <li>Ngăn chặn việc gán giá trị sai cho biến (ví dụ như số âm cho số dư tài khoản).</li>
  <li>Giúp dễ dàng thay đổi nội bộ mà không ảnh hưởng đến code bên ngoài.</li>
  <li>Tăng khả năng bảo trì và phát triển phần mềm.</li>
</ul>

<h3>4. Quy tắc tốt khi đóng gói</h3>
<ul>
  <li>Biến dữ liệu nên để <code>private</code>.</li>
  <li>Getter chỉ trả về dữ liệu nếu thực sự cần thiết.</li>
  <li>Setter nên kiểm tra điều kiện trước khi cập nhật giá trị.</li>
</ul>

<h3>5. Một số lỗi hay gặp khi đóng gói</h3>
<ul>
  <li>Quên dùng private cho biến: dữ liệu có thể bị chỉnh sửa trực tiếp ngoài lớp.</li>
  <li>Không validate dữ liệu trong setter.</li>
</ul>

<h3>6. Ứng dụng thực tế của Encapsulation</h3>
<ul>
  <li>Hệ thống ngân hàng: đảm bảo tài khoản không thể bị chỉnh sửa số dư bất hợp pháp.</li>
  <li>Quản lý tài khoản người dùng: bảo vệ mật khẩu, thông tin cá nhân.</li>
  <li>Ứng dụng thương mại điện tử: kiểm soát thông tin đơn hàng, thanh toán.</li>
</ul>

<h3>Tổng kết:</h3>
<p>Đóng gói là kỹ thuật quan trọng để bảo vệ dữ liệu và tăng tính an toàn trong lập trình hướng đối tượng. Khi thực hiện đúng, nó giúp hệ thống trở nên mạnh mẽ, linh hoạt và bảo mật hơn.</p>
""");


        updateLessonContent(4L, """
<h2>Bài 4: Tính kế thừa (Inheritance)</h2>

<p><strong>Inheritance</strong> (kế thừa) là cơ chế trong lập trình hướng đối tượng cho phép một lớp <em>kế thừa</em> các thuộc tính (fields) và phương thức (methods) từ một lớp khác. Đây là một trong những nền tảng quan trọng nhất của OOP, giúp tái sử dụng mã nguồn và mở rộng chương trình.</p>

<h3>1. Các khái niệm cơ bản</h3>
<ul>
  <li><strong>Lớp cha (Superclass/Base Class):</strong> Lớp mà các thuộc tính và hành vi sẽ được kế thừa.</li>
  <li><strong>Lớp con (Subclass/Derived Class):</strong> Lớp kế thừa từ lớp cha và có thể thêm mới hoặc ghi đè hành vi.</li>
</ul>

<h4>Ví dụ đơn giản:</h4>

<pre><code>class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();  // từ lớp cha
        d.bark(); // từ lớp con
    }
}
</code></pre>

<p><em>Kết quả:</em></p>
<pre><code>This animal eats food.
The dog barks.
</code></pre>

---

<h3>2. Quy tắc trong kế thừa</h3>
<ul>
  <li>Lớp con kế thừa tất cả các thuộc tính và phương thức <em>không private</em> của lớp cha.</li>
  <li>Lớp con có thể:
    <ul>
      <li>Thêm mới thuộc tính/phương thức.</li>
      <li>Ghi đè (override) phương thức của lớp cha.</li>
    </ul>
  </li>
  <li>Java hỗ trợ kế thừa đơn (mỗi lớp chỉ kế thừa từ một lớp cha trực tiếp).</li>
</ul>

<h3>3. Từ khóa <code>super</code> trong kế thừa</h3>

<p><code>super</code> được dùng để:</p>
<ul>
  <li>Gọi constructor của lớp cha.</li>
  <li>Gọi phương thức hoặc thuộc tính của lớp cha.</li>
</ul>

<h4>Ví dụ sử dụng <code>super</code>:</h4>

<pre><code>class Animal {
    String type = "Animal";

    void displayType() {
        System.out.println("Type: " + type);
    }
}

class Dog extends Animal {
    String type = "Dog";

    void displayType() {
        System.out.println("Type: " + type); // In ra Dog
        System.out.println("Parent Type: " + super.type); // In ra Animal
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.displayType();
    }
}
</code></pre>

---

<h3>4. Ghi đè phương thức (Method Overriding)</h3>

<p>Lớp con có thể cung cấp cách cài đặt mới cho phương thức đã được khai báo trong lớp cha.</p>

<h4>Ví dụ:</h4>

<pre><code>class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}
</code></pre>

<p><strong>Chú ý:</strong> Khi override cần dùng annotation <code>@Override</code> để trình biên dịch kiểm tra tính chính xác.</p>

---

<h3>5. Các lợi ích của kế thừa</h3>
<ul>
  <li>Giảm trùng lặp mã.</li>
  <li>Dễ dàng mở rộng hệ thống phần mềm.</li>
  <li>Hỗ trợ tính đa hình trong OOP.</li>
</ul>

<h3>6. Một số lưu ý khi kế thừa</h3>
<ul>
  <li>Không phải lúc nào cũng nên sử dụng kế thừa; nếu không cẩn thận sẽ dẫn đến thiết kế khó bảo trì.</li>
  <li>Nếu hai lớp chỉ có điểm chung rất nhỏ, có thể xem xét <em>composition</em> thay cho kế thừa.</li>
</ul>

---

<h3>Tổng kết:</h3>
<p>Kế thừa là một trong những đặc trưng mạnh nhất của OOP, cho phép chúng ta tổ chức chương trình theo mô hình mở rộng tự nhiên, giảm thiểu sự trùng lặp và nâng cao khả năng tái sử dụng mã nguồn.</p>
""");


        updateLessonContent(5L, """
<h2>Bài 5: Tính đa hình và Tính trừu tượng (Polymorphism & Abstraction)</h2>

<h3>1. Tính đa hình (Polymorphism)</h3>

<p><strong>Đa hình</strong> cho phép cùng một hành động (method) có thể hoạt động theo nhiều cách khác nhau tùy thuộc vào đối tượng thực tế.</p>

<p>Ý tưởng của đa hình là một giao diện duy nhất nhưng nhiều cách triển khai khác nhau.</p>

<h4>Ví dụ đa hình (method overriding):</h4>

<pre><code>class Animal {
    void sound() {
        System.out.println("Some sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Cat();
        myAnimal.sound(); // Meow

        myAnimal = new Dog();
        myAnimal.sound(); // Woof
    }
}
</code></pre>

<h4>Kết quả:</h4>
<pre><code>Meow
Woof
</code></pre>

---

<h3>2. Lợi ích của đa hình</h3>
<ul>
  <li>Cho phép mở rộng chương trình dễ dàng.</li>
  <li>Giảm phụ thuộc chặt giữa các lớp.</li>
  <li>Hỗ trợ nguyên lý Liskov Substitution (LSP): đối tượng của lớp con có thể thay thế cho lớp cha mà không ảnh hưởng đến tính đúng đắn của chương trình.</li>
</ul>

---

<h3>3. Các loại đa hình trong Java</h3>
<ul>
  <li><strong>Compile-time Polymorphism (Method Overloading):</strong> Xảy ra khi nhiều phương thức cùng tên nhưng khác tham số.</li>
  <li><strong>Run-time Polymorphism (Method Overriding):</strong> Xảy ra khi lớp con ghi đè phương thức của lớp cha.</li>
</ul>

<h4>Ví dụ method overloading:</h4>

<pre><code>class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(3, 5));      // 8
        System.out.println(calc.add(2.5, 4.3));  // 6.8
    }
}
</code></pre>

---

<h2>4. Tính trừu tượng (Abstraction)</h2>

<p><strong>Trừu tượng</strong> là khả năng che giấu chi tiết cài đặt và chỉ hiển thị chức năng bên ngoài cho người dùng.</p>

<p>Trong Java, tính trừu tượng có thể đạt được thông qua:</p>
<ul>
  <li><strong>Abstract classes (Lớp trừu tượng)</strong></li>
  <li><strong>Interfaces (Giao diện)</strong></li>
</ul>

---

<h3>5. Abstract Class</h3>

<p>Một lớp abstract có thể có cả phương thức đã cài đặt và phương thức trừu tượng (chỉ khai báo mà không cài đặt).</p>

<h4>Ví dụ:</h4>

<pre><code>abstract class Animal {
    abstract void makeSound();

    void eat() {
        System.out.println("Eating food...");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.makeSound(); // Meow
        c.eat();       // Eating food...
    }
}
</code></pre>

---

<h3>6. Interface</h3>

<p>Interface định nghĩa bộ khung các hành động mà lớp triển khai phải thực hiện.</p>

<h4>Ví dụ interface:</h4>

<pre><code>interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Main {
    public static void main(String[] args) {
        Drawable d = new Circle();
        d.draw(); // Drawing Circle
    }
}
</code></pre>

---

<h3>7. Lợi ích của trừu tượng hóa</h3>
<ul>
  <li>Giảm sự phụ thuộc giữa các thành phần hệ thống.</li>
  <li>Tăng khả năng mở rộng và bảo trì phần mềm.</li>
  <li>Hướng người lập trình tập trung vào "cái gì" thay vì "như thế nào".</li>
</ul>

---

<h3>Tổng kết:</h3>
<p>
Tính đa hình và tính trừu tượng giúp hệ thống phần mềm linh hoạt, mở rộng dễ dàng và bảo trì hiệu quả. Đây là hai nguyên lý rất quan trọng của lập trình hướng đối tượng cần nắm vững khi phát triển các ứng dụng lớn.
</p>
""");


        updateLessonContent(6L, """
<h2>Bài 6: Mối quan hệ giữa các đối tượng (Association, Aggregation, Composition)</h2>

<p>Trong lập trình hướng đối tượng (OOP), các đối tượng không tồn tại đơn lẻ mà thường liên kết với nhau để thực hiện các chức năng phức tạp. Có ba loại mối quan hệ chính:</p>

---

<h3>1. Association (Quan hệ kết hợp)</h3>

<p>Association là mối quan hệ tổng quát giữa hai lớp, cho phép một đối tượng sử dụng các chức năng của đối tượng khác mà không sở hữu nhau.</p>

<h4>Đặc điểm:</h4>
<ul>
  <li>Quan hệ 1-1, 1-n hoặc n-n.</li>
  <li>Mỗi đối tượng vẫn có thể tồn tại độc lập.</li>
</ul>

<h4>Ví dụ:</h4>

<pre><code>class Teacher {
    String name;
}

class Department {
    String name;
}
</code></pre>

<p>Một giáo viên có thể làm việc cho nhiều khoa, và một khoa có thể có nhiều giáo viên.</p>

---

<h3>2. Aggregation (Quan hệ tổng hợp)</h3>

<p>Aggregation là một dạng đặc biệt của Association thể hiện quan hệ "has-a" (có một). Một lớp có thể chứa đối tượng của lớp khác nhưng không chịu trách nhiệm vòng đời của nó.</p>

<h4>Đặc điểm:</h4>
<ul>
  <li>Lớp chứa và lớp thành phần có vòng đời riêng biệt.</li>
  <li>Nếu lớp chứa bị hủy, lớp thành phần vẫn tồn tại.</li>
</ul>

<h4>Ví dụ:</h4>

<pre><code>class Engine {
    void start() {
        System.out.println("Engine Started...");
    }
}

class Car {
    Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void startCar() {
        engine.start();
        System.out.println("Car is moving...");
    }
}

public class Main {
    public static void main(String[] args) {
        Engine e = new Engine();
        Car car = new Car(e);
        car.startCar();
    }
}
</code></pre>

<p><em>Chú ý:</em> Engine có thể tồn tại độc lập với Car.</p>

---

<h3>3. Composition (Quan hệ hợp thành)</h3>

<p>Composition cũng là dạng "has-a" nhưng ràng buộc chặt hơn Aggregation. Một lớp hoàn toàn chịu trách nhiệm về vòng đời của lớp thành phần.</p>

<h4>Đặc điểm:</h4>
<ul>
  <li>Lớp thành phần không tồn tại nếu lớp chứa bị hủy.</li>
  <li>Quan hệ mạnh mẽ hơn Aggregation.</li>
</ul>

<h4>Ví dụ:</h4>

<pre><code>class Heart {
    void beat() {
        System.out.println("Heart beating...");
    }
}

class Human {
    private Heart heart;

    Human() {
        heart = new Heart();
    }

    void live() {
        heart.beat();
    }
}

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.live();
    }
}
</code></pre>

<p><em>Chú ý:</em> Heart không tồn tại độc lập bên ngoài Human.</p>

---

<h3>4. So sánh nhanh giữa Association, Aggregation và Composition</h3>

<table class="table table-bordered">
<thead>
<tr>
<th>Loại</th>
<th>Vòng đời đối tượng</th>
<th>Quan hệ</th>
</tr>
</thead>
<tbody>
<tr>
<td>Association</td>
<td>Độc lập</td>
<td>Liên kết lỏng lẻo</td>
</tr>
<tr>
<td>Aggregation</td>
<td>Độc lập</td>
<td>Liên kết \"has-a\" lỏng lẻo</td>
</tr>
<tr>
<td>Composition</td>
<td>Ràng buộc</td>
<td>Liên kết \"has-a\" chặt chẽ</td>
</tr>
</tbody>
</table>

---

<h3>5. Ứng dụng thực tế</h3>
<ul>
  <li>Aggregation: Một trường học chứa nhiều học sinh (School - Students).</li>
  <li>Composition: Một con người có một trái tim (Human - Heart).</li>
  <li>Association: Một nhân viên làm việc cho nhiều dự án (Employee - Project).</li>
</ul>

---

<h3>Tổng kết:</h3>
<p>Việc hiểu rõ các loại quan hệ giữa các đối tượng là nền tảng để thiết kế hệ thống phần mềm hợp lý, dễ bảo trì và mở rộng.</p>
""");

    }

    private void updateLessonContent(Long lessonId, String newContent) {
        lessonRepository.findById(lessonId).ifPresent(lesson -> {
            lesson.setContent(newContent);
            lessonRepository.save(lesson);
            System.out.println("Đã cập nhật bài học Java ID: " + lessonId);
        });
    }
}
