package com.example.elearningwebm4.backend.tools.lessonUpdater;

import com.example.elearningwebm4.backend.repositories.ILessonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LessonContentSeederPython implements CommandLineRunner {

    private final ILessonRepository lessonRepository;

    public LessonContentSeederPython(ILessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        updateLessonContent(19L, """
<h2>Bài 1: Chương trình đầu tiên và chú thích</h2>
<h3>1.1 Giới thiệu Python</h3>
<p>Python là một ngôn ngữ lập trình bậc cao, thông dịch và hướng đối tượng. Với cú pháp đơn giản, dễ học, Python được sử dụng rộng rãi trong nhiều lĩnh vực như khoa học dữ liệu, trí tuệ nhân tạo, phát triển web, tự động hóa và phát triển phần mềm. Một đặc điểm nổi bật của Python là cú pháp gần với ngôn ngữ tự nhiên, giúp người học dễ đọc và hiểu code.</p>
<p>Python được phát triển bởi Guido van Rossum và lần đầu phát hành vào năm 1991. Ngày nay, Python là một trong những ngôn ngữ lập trình phổ biến nhất trên thế giới.</p>

<h3>1.2 Viết chương trình đầu tiên</h3>
<pre><code>print("Xin chào, Python!")</code></pre>
<p>Hàm <code>print()</code> được sử dụng để xuất thông tin ra màn hình. Đây là bước đầu tiên để kiểm tra khả năng chạy của chương trình Python.</p>

<h3>1.3 Chú thích trong Python</h3>
<p>Chú thích là các dòng văn bản không được thực thi trong chương trình, dùng để giải thích hoặc ghi chú lại ý nghĩa của đoạn mã. Có hai cách tạo chú thích trong Python:</p>
<ul>
  <li>Dùng dấu <code>#</code> cho chú thích một dòng</li>
  <li>Dùng dấu <code>''' ... '''</code> cho chú thích nhiều dòng</li>
</ul>
<pre><code># Đây là một chú thích một dòng
'''
        Chú thích nhiều dòng
        Dùng khi cần mô tả đoạn mã dài
        '''</code></pre>
        <p>Chú thích giúp tăng khả năng đọc hiểu mã nguồn, đặc biệt khi làm việc nhóm hoặc bảo trì về sau.</p>
        """);

        updateLessonContent(20L, """
<h2>Bài 2: Kiểu dữ liệu, biến và ép kiểu</h2>
<h3>2.1 Biến trong Python</h3>
<p>Biến là vùng nhớ để lưu trữ dữ liệu. Trong Python, bạn không cần khai báo kiểu biến trước khi sử dụng. Trình thông dịch sẽ tự xác định kiểu biến dựa trên giá trị được gán.</p>
<pre><code>name = "Alice"
age = 30
height = 1.65
is_student = True</code></pre>

<h3>2.2 Các kiểu dữ liệu cơ bản</h3>
<ul>
  <li><code>int</code>: số nguyên (e.g., 10, -3)</li>
  <li><code>float</code>: số thực (e.g., 3.14, -0.1)</li>
  <li><code>str</code>: chuỗi ký tự (e.g., "Hello")</li>
  <li><code>bool</code>: giá trị logic (True hoặc False)</li>
</ul>
<p>Dùng hàm <code>type()</code> để kiểm tra kiểu dữ liệu của biến.</p>
<pre><code>print(type(name))       # str
print(type(age))        # int
print(type(height))     # float
print(type(is_student)) # bool</code></pre>

<h3>2.3 Ép kiểu</h3>
<p>Python cho phép chuyển đổi kiểu dữ liệu bằng các hàm tích hợp như <code>int()</code>, <code>float()</code>, <code>str()</code>.</p>
<pre><code>x = "5"
y = int(x) + 10
print(y)  # 15</code></pre>
<p>Nên kiểm tra dữ liệu trước khi ép kiểu để tránh lỗi.</p>
""");

        updateLessonContent(21L, """
<h2>Bài 3: Đầu vào</h2>
<h3>3.1 Hàm input()</h3>
<p>Hàm <code>input()</code> cho phép người dùng nhập dữ liệu từ bàn phím. Kết quả trả về luôn là chuỗi (str).</p>
<pre><code>name = input("Nhập tên: ")
print("Chào bạn,", name)</code></pre>

<h3>3.2 Ép kiểu sau khi nhập</h3>
<pre><code>age = int(input("Nhập tuổi: "))
print("Năm sau bạn sẽ", age + 1)</code></pre>
<p>Vì <code>input()</code> luôn trả về chuỗi, bạn cần ép kiểu nếu muốn xử lý như số.</p>
""");

        updateLessonContent(22L, """
<h2>Bài 4: Toán tử cơ bản</h2>
<h3>4.1 Toán tử số học</h3>
<p>Python hỗ trợ nhiều toán tử số học:</p>
<ul>
  <li><code>+</code>: cộng</li>
  <li><code>-</code>: trừ</li>
  <li><code>*</code>: nhân</li>
  <li><code>/</code>: chia (trả về float)</li>
  <li><code>//</code>: chia lấy phần nguyên</li>
  <li><code>%</code>: chia lấy dư</li>
  <li><code>**</code>: lũy thừa</li>
</ul>
<pre><code>x = 10
y = 3
print(x + y, x ** y)</code></pre>

<h3>4.2 Toán tử so sánh và logic</h3>
<p>Dùng để so sánh hai giá trị hoặc kết hợp điều kiện:</p>
<pre><code>print(x > y)
print(x == 10 and y < 5)
print(not x < 5)</code></pre>
""");

        updateLessonContent(23L, """
<h2>Bài 5: Câu lệnh lựa chọn (if-elif-else)</h2>
<h3>5.1 Cấu trúc điều kiện</h3>
<p>Dùng để điều khiển luồng chương trình theo điều kiện:</p>
<pre><code>score = 85
if score >= 90:
    print("Xuất sắc")
elif score >= 70:
    print("Khá")
elif score >= 50:
    print("Trung bình")
else:
    print("Yếu")</code></pre>
<p>Các khối lệnh phải thụt đầu dòng (indent) để Python hiểu.</p>
""");

        updateLessonContent(24L, """
<h2>Bài 6: Vòng lặp</h2>
<h3>6.1 for</h3>
<p>Dùng để lặp lại một khối lệnh theo số lần xác định hoặc duyệt qua danh sách.</p>
<pre><code>for i in range(5):
    print("Lần:", i)</code></pre>

<h3>6.2 while</h3>
<p>Lặp khi điều kiện còn đúng:</p>
<pre><code>count = 0
while count < 3:
    print("Đếm:", count)
    count += 1</code></pre>
<p>Cẩn thận để tránh vòng lặp vô hạn.</p>
""");

        updateLessonContent(25L, """
<h2>Bài 7: Danh sách (List)</h2>
<h3>7.1 Khởi tạo và truy cập</h3>
<pre><code>fruits = ["táo", "cam", "chuối"]
print(fruits[0])</code></pre>

<h3>7.2 Duyệt danh sách</h3>
<pre><code>for fruit in fruits:
    print(fruit)</code></pre>

<h3>7.3 Thêm/Xóa/Sắp xếp</h3>
<pre><code>fruits.append("xoài")
fruits.remove("cam")
fruits.sort()</code></pre>
<p>List là kiểu dữ liệu linh hoạt và phổ biến trong Python.</p>
""");

        updateLessonContent(26L, """
<h2>Bài 8: Chuỗi (String)</h2>
<h3>8.1 Khái niệm</h3>
<p>Chuỗi là một tập hợp các ký tự, được bao bởi dấu nháy đơn hoặc kép.</p>
<pre><code>text = "Hello, Python"</code></pre>

<h3>8.2 Các phương thức xử lý chuỗi</h3>
<pre><code>print(text.upper())
print(text.lower())
print(text.split(","))
print(text.replace("Python", "World"))</code></pre>
<p>Chuỗi là bất biến – mọi thao tác sẽ tạo chuỗi mới.</p>
""");

        updateLessonContent(27L, """
<h2>Bài 9: Hàm (Function)</h2>
<h3>9.1 Định nghĩa hàm</h3>
<p>Hàm là khối lệnh có thể tái sử dụng, giúp chia nhỏ chương trình và tăng tính tổ chức.</p>
<pre><code>def greet(name):
    print("Xin chào,", name)</code></pre>

<h3>9.2 Hàm có trả về</h3>
<pre><code>def add(a, b):
    return a + b

print(add(3, 5))</code></pre>

<h3>9.3 Tham số mặc định và không xác định</h3>
<pre><code>def hello(name="bạn"):
    print("Xin chào", name)</code></pre>
<p>Hàm giúp viết code ngắn gọn, dễ bảo trì, dễ kiểm thử.</p>
""");
    }

    private void updateLessonContent(Long lessonId, String newContent) {
        lessonRepository.findById(lessonId).ifPresent(lesson -> {
            lesson.setContent(newContent);
            lessonRepository.save(lesson);
            System.out.println("Đã cập nhật bài học Python ID: " + lessonId);
        });
    }
}
