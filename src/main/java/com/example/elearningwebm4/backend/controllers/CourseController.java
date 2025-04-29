package com.example.elearningwebm4.backend.controllers;


import com.example.elearningwebm4.backend.dto.CourseEditDto;
import com.example.elearningwebm4.backend.dto.CoursesDto;
import com.example.elearningwebm4.backend.models.Courses;
import com.example.elearningwebm4.backend.services.CoursesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class CourseController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("/")
    public String showCoursesList(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                  Model model) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<Courses> coursesList = coursesService.findAllCourses(pageable);
        model.addAttribute("coursesList", coursesList);
        return "course/course-list";
    }

    @GetMapping("admin/show-add-course-page")
    public String showAddCoursesPage(Model model) {
        CoursesDto coursesDto = new CoursesDto();
        model.addAttribute("coursesDto", coursesDto);
        return "course/add-course-page";
    }

    @GetMapping("admin/show-edit-course/{id}")
    public String showEditCoursePage(@PathVariable(name = "id") Long id, Model model) {
        Courses courses = coursesService.findCoursesById(id);
        CourseEditDto courseEditDto = new CourseEditDto();
        BeanUtils.copyProperties(courses, courseEditDto);
        model.addAttribute("courseEditDto", courseEditDto);
        return "course/edit-course-page";
    }

    @GetMapping("user/my-course")
    public String showMyCourses(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                Model model) {
        Pageable pageable = PageRequest.of(page, 6);

//        chưa xử lý logic ở đay
        return "course/my-course";
    }

    @GetMapping("show-course-detail/{id}")
    public String showCourseDetailPage(@PathVariable(name = "id") Long id, Model model) {
        Courses courses = coursesService.findCoursesById(id);
        model.addAttribute("courses", courses);
        return "course/course-detail";
    }

    @PostMapping("add-course")
    public String addCourse(@ModelAttribute("courseDto") CoursesDto coursesDto,
                            RedirectAttributes redirectAttributes,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "course/add-course-page";
        }
        Courses courses = new Courses();
        BeanUtils.copyProperties(coursesDto, courses);
        coursesService.saveCourses(courses);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/";
    }

    @PostMapping("edit-course")
    public String editCourse(@ModelAttribute("courseEditDto") CourseEditDto courseEditDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "course/edit-course-page";
        }
        Courses courses = coursesService.findCoursesById(courseEditDto.getCourseId());
        courses.setTitle(courseEditDto.getTitle());
        courses.setDescription(courseEditDto.getDescription());
        courses.setPrice(courseEditDto.getPrice());
        coursesService.saveCourses(courses);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công khoá học " + courseEditDto.getTitle() + "!");
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteCourse(@PathVariable(name = "id") Long id,
                               RedirectAttributes redirectAttributes) {
        String name = coursesService.findCoursesById(id).getTitle();
        coursesService.deleteCoursesById(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công khóa học " + name + "!");
        return "redirect:/";
    }

    @GetMapping("/search-course")
    public String searchCourses(@RequestParam(name = "search") String title,
                                @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                Model model) {
        Pageable pageable = PageRequest.of(page, 6);
        if (title.trim().isEmpty()) {
            Page<Courses> coursesList = coursesService.findAllCourses(pageable);
            model.addAttribute("coursesList", coursesList);
        } else {
            Page<Courses> coursesList = coursesService.findCoursesByTitle(title.trim(), pageable);
            model.addAttribute("coursesList", coursesList);
        }
        return "course/course-list";
    }
}
