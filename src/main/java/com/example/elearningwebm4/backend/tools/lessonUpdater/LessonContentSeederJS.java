package com.example.elearningwebm4.backend.tools.lessonUpdater;

import com.example.elearningwebm4.backend.repositories.ILessonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LessonContentSeederJS implements CommandLineRunner {

    private final ILessonRepository lessonRepository;

    public LessonContentSeederJS(ILessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        updateLessonContent(7L, """
<h2>1. Tổng quan, console.log và chú thích</h2>
<p><strong>JavaScript</strong> là ngôn ngữ lập trình phía client, giúp tạo tương tác động cho web. Bạn dùng JS để thao tác DOM, xử lý sự kiện, validate form và nhiều hơn nữa.</p>
<h3>1.1 console.log()</h3>
<p>Dùng để in bất kỳ giá trị nào ra tab Console của trình duyệt. Rất hữu ích cho debug và kiểm tra biến.</p>
<pre><code>console.log("Hello, JavaScript!");
let x = 42;
console.log("Giá trị x =", x);</code></pre>
<h3>1.2 Chú thích (Comments)</h3>
<ul>
  <li><code>//</code> cho chú thích một dòng.</li>
  <li><code>/* … */</code> cho chú thích nhiều dòng.</li>
</ul>
<pre><code>// Đây là chú thích một dòng
/*
  Chú thích
  nhiều dòng
*/
console.log("Test comments");</code></pre>
<p>Chú thích giúp bạn giải thích logic, hoặc tạm vô hiệu hóa code.</p>
""");

        updateLessonContent(8L, """
<h2>2. Biến (Variables)</h2>
<p>Biến dùng để lưu trữ dữ liệu. ES6 giới thiệu <code>let</code> và <code>const</code>, thay thế <code>var</code> cũ.</p>
<h3>2.1 var, let, const</h3>
<ul>
  <li><code>var</code>: function scope, có hoisting.</li>
  <li><code>let</code>: block scope, không hoisting.</li>
  <li><code>const</code>: block scope, hằng số, phải gán khi khai báo.</li>
</ul>
<pre><code>var a = 1;
let b = 2;
const PI = 3.1415;</code></pre>
<h3>2.2 Scope và Hoisting</h3>
<pre><code>console.log(a); // undefined
var a = 5;

console.log(b); // ReferenceError
let b = 10;</code></pre>
<h3>2.3 So sánh var/let/const</h3>
<table class="table table-bordered">
<thead><tr><th>Đặc tính</th><th>var</th><th>let</th><th>const</th></tr></thead>
<tbody>
<tr><td>Scope</td><td>Function</td><td>Block</td><td>Block</td></tr>
<tr><td>Hoisting</td><td>Có</td><td>Không</td><td>Không</td></tr>
<tr><td>Gán lại</td><td>Có</td><td>Có</td><td>Không</td></tr>
</tbody>
</table>
""");

        updateLessonContent(9L, """
<h2>3. Các toán tử (Operators)</h2>
<p>Toán tử giúp thao tác số, so sánh, logic trên dữ liệu.</p>
<h3>3.1 Toán tử số học</h3>
<pre><code>+, -, *, /, %, ++, --</code></pre>
<h3>3.2 Toán tử so sánh</h3>
<pre><code>==, ===, !=, !==, &lt;, &gt;, &lt;=, &gt;=</code></pre>
<h3>3.3 Toán tử logic</h3>
<pre><code>&amp;&amp;, ||, !</code></pre>
<h3>3.4 Ví dụ kết hợp</h3>
<pre><code>let x = 10, y = 5;
console.log(x + y);      // 15
console.log(x === y);    // false
console.log(x &gt; 0 &amp;&amp; y &gt; 0); // true</code></pre>
""");

        updateLessonContent(10L, """
<h2>4. Các hàm (Functions)</h2>
<p>Hàm gói nhóm logic, có thể tái sử dụng. Có hai dạng chính:</p>
<ul>
  <li>Function Declaration</li>
  <li>Function Expression / Arrow Function</li>
</ul>
<h3>4.1 Function Declaration</h3>
<pre><code>function add(x, y) {
  return x + y;
}
console.log(add(2,3)); // 5</code></pre>
<h3>4.2 Function Expression & Arrow</h3>
<pre><code>const mul = function(a,b) { return a*b; };
const sub = (a,b) =&gt; a - b;
console.log(mul(2,3)); // 6
console.log(sub(5,2)); // 3</code></pre>
<h3>4.3 Tham số mặc định & Rest</h3>
<pre><code>function greet(name = "Guest") {
  console.log("Hello " + name);
}
greet();          // Hello Guest
function sum(...nums) {
  return nums.reduce((a,c) =&gt; a+c,0);
}
console.log(sum(1,2,3)); // 6</code></pre>
""");

        updateLessonContent(11L, """
<h2>5. If - Else và Switch - Case</h2>
<p>Điều kiện giúp đưa ra hướng xử lý khác nhau.</p>
<h3>5.1 If - Else</h3>
<pre><code>let score = 75;
if (score &gt;= 90) {
  console.log("Xuất sắc");
} else if (score &gt;= 70) {
  console.log("Khá");
} else {
  console.log("Trung bình");
}</code></pre>
<h3>5.2 Switch - Case</h3>
<pre><code>let role = "admin";
switch(role) {
  case "admin":
    console.log("Quản trị");
    break;
  case "user":
    console.log("Người dùng");
    break;
  default:
    console.log("Khác");
}</code></pre>
""");

        updateLessonContent(12L, """
<h2>6. Vòng lặp (Loops)</h2>
<p>Cho phép lặp lại khối lệnh nhiều lần.</p>
<h3>6.1 For</h3>
<pre><code>for (let i = 0; i &lt; 5; i++) {
  console.log(i);
}</code></pre>
<h3>6.2 While & Do-While</h3>
<pre><code>let i = 0;
while (i &lt; 3) {
  console.log(i++);
}

let j = 0;
do {
  console.log(j++);
} while (j &lt; 3);</code></pre>
<h3>6.3 Break & Continue</h3>
<pre><code>for (let k = 0; k &lt; 5; k++) {
  if (k === 3) break;
  if (k % 2 === 0) continue;
  console.log(k);
}</code></pre>
""");

        updateLessonContent(13L, """
<h2>7. Phương thức Object</h2>
<p>Objects lưu dữ liệu dạng cặp key: value, có thể chứa phương thức.</p>
<h3>7.1 Tạo và truy cập</h3>
<pre><code>let user = { name: "Anna", age: 28 };</code></pre>
<h3>7.2 Thêm & Xóa thuộc tính</h3>
<pre><code>user.email = "anna@example.com";
delete user.age;</code></pre>
<h3>7.3 Phương thức trong Object</h3>
<pre><code>let person = {
  name: "Bob",
  greet() {
    console.log("Hi " + this.name);
  }
};
person.greet();</code></pre>
""");

        updateLessonContent(14L, """
<h2>8. Phương thức Array</h2>
<p>Mảng có nhiều method để thao tác dữ liệu.</p>
<h3>8.1 Thêm & Xóa</h3>
<pre><code>let arr = [1,2,3];
arr.push(4);      // [1,2,3,4]
arr.pop();       // [1,2,3]
arr.shift();     // [2,3]
arr.unshift(0);  // [0,2,3]</code></pre>
<h3>8.2 Map, Filter, Reduce</h3>
<pre><code>let nums = [1,2,3,4];
let squares = nums.map(n =&gt; n*n);
let evens = nums.filter(n =&gt; n%2===0);
let sum = nums.reduce((a,c) =&gt; a+c, 0);
</code></pre>
<h3>8.3 Other Methods</h3>
<pre><code>nums.find(n =&gt; n&gt;2);
nums.some(n =&gt; n&gt;3);
nums.every(n =&gt; n&gt;0);</code></pre>
""");

        updateLessonContent(15L, """
<h2>9. Phương thức String</h2>
<p>Chuỗi hỗ trợ nhiều phương thức xử lý văn bản.</p>
<h3>9.1 Cơ bản</h3>
<pre><code>let s = "Hello, JS";
console.log(s.length);
console.log(s.toUpperCase());
console.log(s.toLowerCase());</code></pre>
<h3>9.2 Cắt và tìm kiếm</h3>
<pre><code>console.log(s.slice(0,5));       // Hello
console.log(s.indexOf("JS"));     // 7
console.log(s.replace("JS","World"));</code></pre>
""");

        updateLessonContent(16L, """
<h2>10. Phương thức Dữ liệu</h2>
<p>Chuyển đổi và kiểm tra kiểu dữ liệu.</p>
<h3>10.1 typeof</h3>
<pre><code>console.log(typeof 123);        // number
console.log(typeof "abc");      // string</code></pre>
<h3>10.2 parseInt & parseFloat</h3>
<pre><code>let str = "12.34";
console.log(parseInt(str));     // 12
console.log(parseFloat(str));   // 12.34</code></pre>
<h3>10.3 Number & isNaN</h3>
<pre><code>let n = Number("123");
console.log(isNaN("abc"));      // true</code></pre>
""");

        updateLessonContent(17L, """
<h2>11. Phương thức Toán học</h2>
<p>Đối tượng Math cung cấp hằng số và hàm toán học.</p>
<h3>11.1 random & rounding</h3>
<pre><code>console.log(Math.random());       // [0,1)
console.log(Math.round(4.6));       // 5
console.log(Math.floor(4.6));       // 4
console.log(Math.ceil(4.1));        // 5</code></pre>
<h3>11.2 max, min, abs, pow, sqrt</h3>
<pre><code>console.log(Math.max(1,5,3));   // 5
console.log(Math.min(1,5,3));   // 1
console.log(Math.abs(-10));     // 10
console.log(Math.pow(2,3));     // 8
console.log(Math.sqrt(9));      // 3</code></pre>
""");

        updateLessonContent(18L, """
<h2>12. Phương thức Số</h2>
<p>Các phương thức xử lý số nâng cao.</p>
<h3>12.1 toFixed & toPrecision</h3>
<pre><code>let x = 3.1415926;
console.log(x.toFixed(2));       // 3.14
console.log(x.toPrecision(4));   // 3.142</code></pre>
<h3>12.2 Number & parse</h3>
<pre><code>console.log(Number("123"));    // 123
console.log(parseInt("123px"));  // 123</code></pre>
<h3>12.3 isFinite & isSafeInteger</h3>
<pre><code>console.log(Number.isFinite(1/0));          // false
console.log(Number.isSafeInteger(9007199254740991)); // true</code></pre>
""");
    }

    private void updateLessonContent(Long lessonId, String newContent) {
        lessonRepository.findById(lessonId).ifPresent(lesson -> {
            lesson.setContent(newContent);
            lessonRepository.save(lesson);
            System.out.println("Đã cập nhật bài học JS ID: " + lessonId);
        });
    }
}
