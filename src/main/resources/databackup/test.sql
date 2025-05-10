INSERT INTO `e-learning-web`.courses (course_id, create_at, description, price, title, update_at)
VALUES (1, '2025-05-09 11:41:00.682402',
        'Khóa học Java cung cấp kiến thức từ cơ bản đến nâng cao về ngôn ngữ lập trình Java, bao gồm cú pháp, lập trình hướng đối tượng (OOP), xử lý ngoại lệ, làm việc với cơ sở dữ liệu và xây dựng ứng dụng Java thực tế. Phù hợp cho người mới bắt đầu hoặc lập trình viên muốn nâng cao kỹ năng.',
        1000000, 'Java', '2025-05-09 11:41:00.682402'),
       (2, '2025-05-09 11:41:00.682402',
        'Khóa học JavaScript giúp học viên nắm vững kiến thức nền tảng về ngôn ngữ lập trình JavaScript, bao gồm cú pháp cơ bản, thao tác với DOM, xử lý sự kiện, lập trình bất đồng bộ và xây dựng các ứng dụng web tương tác. Phù hợp cho người mới bắt đầu và những ai muốn phát triển kỹ năng lập trình front-end.',
        800000, 'JS', '2025-05-09 11:41:00.682402'),
       (3, '2025-05-09 11:41:00.682402',
        'Khóa học Python cung cấp kiến thức từ cơ bản đến nâng cao về lập trình với Python, bao gồm cú pháp, cấu trúc dữ liệu, lập trình hướng đối tượng, xử lý tệp và xây dựng ứng dụng thực tế. Phù hợp cho người mới bắt đầu và những ai muốn ứng dụng Python vào công việc.',
        1000000, 'Python', '2025-05-09 11:41:00.682402'),
       (4, '2025-05-09 11:41:00.682402',
        'Khóa học HTML & CSS dành cho người mới bắt đầu, giúp học viên hiểu và xây dựng được cấu trúc và thiết kế giao diện website cơ bản. Bao gồm thực hành xây dựng các trang web tĩnh và responsive.',
        500000, 'HTML & CSS', '2025-05-09 11:41:00.682402'),
       (5, '2025-05-09 11:41:00.682402',
        'Khóa học ReactJS tập trung vào việc xây dựng giao diện người dùng hiện đại với thư viện React. Bao gồm JSX, components, state, props, hooks và routing. Phù hợp với những ai đã có nền tảng JavaScript.',
        1200000, 'ReactJS', '2025-05-09 11:41:00.682402'),
       (6, '2025-05-09 11:41:00.682402',
        'Khóa học Node.js giới thiệu về phát triển backend với JavaScript, bao gồm Express, REST API, xử lý tệp, middleware và kết nối cơ sở dữ liệu. Dành cho những ai muốn trở thành lập trình viên full-stack.',
        1100000, 'Node.js', '2025-05-09 11:41:00.682402'),
       (7, '2025-05-09 11:41:00.682402',
        'Khóa học SQL từ cơ bản đến nâng cao giúp học viên hiểu rõ về cơ sở dữ liệu quan hệ, cách viết truy vấn SQL hiệu quả, tạo bảng, thiết kế database và tối ưu hóa truy vấn.',
        600000, 'SQL', '2025-05-09 11:41:00.682402'),
       (8, '2025-05-09 11:41:00.682402',
        'Khóa học Flutter hướng dẫn xây dựng ứng dụng di động đa nền tảng với giao diện hiện đại, sử dụng Dart. Bao gồm widgets, state management, navigation và kết nối backend.',
        1300000, 'Flutter', '2025-05-09 11:41:00.682402');

INSERT INTO `e-learning-web`.lessons (lesson_id, content, order_index, title, topic_name, video_url, course_course_id)
VALUES (1, 'Nội dung bài học 1', 1, 'Bài 1: Lớp và Đối tượng', 'Java', 'https://video.url/1', 1),
       (2, 'Nội dung bài học 2', 2, 'Bài 2: Biến tĩnh và Phương thức tĩnh', 'Java', 'https://video.url/2', 1),
       (3, 'Nội dung bài học 3', 3, 'Bài 3: Tính đóng gói', 'Java', 'https://video.url/3', 1),
       (4, 'Nội dung bài học 4', 4, 'Bài 4: Tính kế thừa', 'Java', 'https://video.url/4', 1),
       (5, 'Nội dung bài học 5', 5, 'Bài 5: Tính đa hình và Tính trừu tượng', 'Java', 'https://video.url/5', 1),
       (6, 'Nội dung bài học 6', 6, 'Bài 6: Mối quan hệ giữa các đối tượng', 'Java', 'https://video.url/6', 1),
       (7, 'Nội dung bài học 7', 7, 'Bài 1: Tổng quan, console.log và chú thích', 'JS', 'https://video.url/7', 2),
       (8, 'Nội dung bài học 8', 8, 'Bài 2: Biến', 'JS', 'https://video.url/8', 2),
       (9, 'Nội dung bài học 9', 9, 'Bài 3: Các toán tử', 'JS', 'https://video.url/9', 2),
       (10, 'Nội dung bài học 10', 10, 'Bài 4: Các hàm', 'JS', 'https://video.url/10', 2),
       (11, 'Nội dung bài học 11', 11, 'Bài 5: Lệnh If - Else và Switch - Case', 'JS', 'https://video.url/11', 2),
       (12, 'Nội dung bài học 12', 12, 'Bài 6: Vòng lặp', 'JS', 'https://video.url/12', 2),
       (13, 'Nội dung bài học 13', 13, 'Bài 7: Phương thức object', 'JS', 'https://video.url/13', 2),
       (14, 'Nội dung bài học 14', 14, 'Bài 8: Phương thức mảng', 'JS', 'https://video.url/14', 2),
       (15, 'Nội dung bài học 15', 15, 'Bài 9: Phương thức chuỗi', 'JS', 'https://video.url/15', 2),
       (16, 'Nội dung bài học 16', 16, 'Bài 10: Phương thức dữ liệu', 'JS', 'https://video.url/16', 2),
       (17, 'Nội dung bài học 17', 17, 'Bài 11: Phương thức toán học', 'JS', 'https://video.url/17', 2),
       (18, 'Nội dung bài học 18', 18, 'Bài 12: Phương thức số', 'JS', 'https://video.url/18', 2),
       (19, 'Nội dung bài học 19', 19, 'Bài 1: Chương trình đầu tiên và chú thích', 'Python', 'https://video.url/19',
        3),
       (20, 'Nội dung bài học 20', 20, 'Bài 2: Kiểu dữ liệu, biến và ép kiểu', 'Python', 'https://video.url/20', 3),
       (21, 'Nội dung bài học 21', 21, 'Bài 3: Đầu vào', 'Python', 'https://video.url/21', 3),
       (22, 'Nội dung bài học 22', 22, 'Bài 4: Toán tử cơ bản', 'Python', 'https://video.url/22', 3),
       (23, 'Nội dung bài học 23', 23, 'Bài 5: Câu lệnh lựa chọn (if-elif-else)', 'Python', 'https://video.url/23', 3),
       (24, 'Nội dung bài học 24', 24, 'Bài 6: Vòng lặp', 'Python', 'https://video.url/24', 3),
       (25, 'Nội dung bài học 25', 25, 'Bài 7: Danh sách (List)', 'Python', 'https://video.url/25', 3),
       (26, 'Nội dung bài học 26', 26, 'Bài 8: Chuỗi (String)', 'Python', 'https://video.url/26', 3),
       (27, 'Nội dung bài học 27', 27, 'Bài 9: Hàm (Function)', 'Python', 'https://video.url/27', 3);

INSERT INTO `e-learning-web`.quizzes
VALUES (1, 'Bài Kiểm Tra Java', 100, NULL),
       (2, 'Bài Kiểm Tra JavaScript', 100, NULL),
       (3, 'Bài Kiểm Tra Python', 100, NULL);

INSERT INTO `e-learning-web`.quiz_attempts (attempt_id, user_id, quiz_id, score, attempt_date)
VALUES (1, 2, 1, 75, '2025-05-09 09:00:00'),
       (2, 2, 2, 50, '2025-05-09 10:00:00'),
       (3, 2, 3, 100, '2025-05-09 11:00:00'),
       (4, 1, 1, 0, '2025-05-09 21:04:22'),
       (5, 1, 1, 0, '2025-05-09 21:04:33'),
       (6, 1, 1, 60, '2025-05-10 08:14:55'),
       (7, 1, 1, 60, '2025-05-10 08:16:13'),
       (8, 1, 1, 30, '2025-05-10 08:31:48');

INSERT INTO `e-learning-web`.questions (quiz_id, content, option_a, option_b, option_c, option_d, correct_answer)
VALUES
    -- quiz_id = 1 (Java)
    (1, 'Kiểu dữ liệu nào dùng để lưu số nguyên trong Java?', 'String', 'int', 'double', 'boolean', 'B'),
    (1, 'Từ khóa nào dùng để kế thừa lớp trong Java?', 'extends', 'implements', 'super', 'this', 'A'),
    (1, 'Phương thức main có kiểu trả về là gì?', 'void', 'int', 'String', 'boolean', 'A'),
    (1, 'Gói nào chứa lớp Scanner trong Java?', 'java.io', 'java.util', 'java.lang', 'java.net', 'B'),
    -- quiz_id = 2 (JavaScript)
    (2, 'Hàm nào dùng để in ra console trong JavaScript?', 'print()', 'log()', 'console.log()', 'write()', 'C'),
    (2, 'Cách khai báo biến có giá trị không đổi trong JavaScript?', 'var', 'let', 'const', 'static', 'C'),
    (2, 'Phương thức nào thêm phần tử vào cuối mảng?', 'push()', 'pop()', 'shift()', 'unshift()', 'A'),
    (2, 'Toán tử nào kiểm tra giá trị và kiểu dữ liệu?', '==', '===', '!=', '!==', 'B'),
    -- quiz_id = 3 (Python)
    (3, 'Hàm nào dùng để in ra màn hình trong Python?', 'print()', 'echo()', 'write()', 'display()', 'A'),
    (3, 'Cấu trúc nào dùng để lặp trong Python?', 'for', 'while', 'do-while', 'A và B đều đúng', 'D'),
    (3, 'Kiểu dữ liệu nào lưu trữ danh sách trong Python?', 'tuple', 'list', 'set', 'dictionary', 'B'),
    (3, 'Hàm nào trả về độ dài của một chuỗi?', 'len()', 'size()', 'length()', 'count()', 'A');

INSERT INTO `e-learning-web`.questions (quiz_id, content, option_a, option_b, option_c, option_d, correct_answer)
VALUES
    -- Câu hỏi mới cho quiz_id = 1 (Java)
    (1, 'Lớp nào là lớp cơ sở của mọi lớp trong Java?', 'Object', 'Class', 'String', 'System', 'A'),
    (1, 'Từ khóa nào dùng để định nghĩa một hằng số trong Java?', 'final', 'static', 'const', 'volatile', 'A'),
    (1, 'Phương thức nào được gọi khi một đối tượng được tạo?', 'run()', 'main()', 'constructor()', 'start()', 'C'),
    (1, 'Câu lệnh nào dùng để ném ngoại lệ trong Java?', 'throw', 'throws', 'try', 'catch', 'A'),
    (1, 'Giao diện nào được dùng để đánh dấu một lớp có thể sao chép?', 'Serializable', 'Cloneable', 'Comparable',
     'Runnable', 'B'),
    (1, 'Phương thức nào trả về giá trị hash của một đối tượng?', 'hashCode()', 'toString()', 'equals()', 'getClass()',
     'A'),
    -- Câu hỏi mới cho quiz_id = 2 (JavaScript)
    (2, 'Phương thức nào dùng để loại bỏ phần tử cuối mảng?', 'pop()', 'shift()', 'splice()', 'slice()', 'A'),
    (2, 'Hàm nào chuyển đổi chuỗi thành số trong JavaScript?', 'parseInt()', 'toString()', 'Number()',
     'A và C đều đúng', 'D'),
    (2, 'Từ khóa nào khai báo hàm bất đồng bộ?', 'async', 'await', 'promise', 'function', 'A'),
    (2, 'Phương thức nào kiểm tra xem một mảng có chứa phần tử không?', 'includes()', 'contains()', 'has()',
     'indexOf()', 'A'),
    (2, 'Cú pháp nào dùng để khai báo mảng trong JavaScript?', '[1, 2, 3]', '{1, 2, 3}', '(1, 2, 3)',
     'new Array[1, 2, 3]', 'A'),
    (2, 'Hàm nào dùng để trì hoãn thực thi trong JavaScript?', 'setTimeout()', 'setInterval()', 'delay()', 'wait()',
     'A'),
    -- Câu hỏi mới cho quiz_id = 3 (Python)
    (3, 'Hàm nào dùng để lấy giá trị tuyệt đối trong Python?', 'abs()', 'fabs()', 'absolute()', 'math.abs()', 'A'),
    (3, 'Kiểu dữ liệu nào không thể thay đổi sau khi tạo?', 'list', 'tuple', 'dictionary', 'set', 'B'),
    (3, 'Câu lệnh nào dùng để thoát vòng lặp trong Python?', 'break', 'continue', 'pass', 'return', 'A'),
    (3, 'Hàm nào chuyển đổi số thành chuỗi trong Python?', 'str()', 'int()', 'float()', 'chr()', 'A'),
    (3, 'Thư viện nào dùng để làm việc với biểu thức chính quy?', 're', 'regex', 'regexp', 'pattern', 'A'),
    (3, 'Cú pháp nào khai báo hàm trong Python?', 'def function():', 'function():', 'func function():',
     'lambda function:', 'A');