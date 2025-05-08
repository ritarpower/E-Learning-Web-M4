package com.example.elearningwebm4.backend.services.serviceimpl;
import com.example.elearningwebm4.backend.models.Courses;
import com.example.elearningwebm4.backend.models.Enrollments;
import com.example.elearningwebm4.backend.models.Users;
import com.example.elearningwebm4.backend.repositories.ICoursesRepository;
import com.example.elearningwebm4.backend.repositories.IEnrollmentsRepository;
import com.example.elearningwebm4.backend.repositories.IUsersRepository;
import com.example.elearningwebm4.backend.services.EnrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentsServiceImpl implements EnrollmentsService {
    @Autowired
    private IEnrollmentsRepository enrollmentsRepository;

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private ICoursesRepository coursesRepository;

//    @Override
//    public boolean hasEnrollment(Long userId, Long courseId) {
//        Users user = usersRepository.findById(userId).orElse(null);
//        Courses course = coursesRepository.findById(courseId).orElse(null);
//        if (user == null || course == null){
//            return false;
//        }
//        return true;
//    }

    @Override
    public Enrollments getEnrollment(Long userId, Long courseId) {
        Users user = usersRepository.findById(userId).orElse(null);
        Courses course = coursesRepository.findById(courseId).orElse(null);
        return enrollmentsRepository.findByUserAndCourse(user, course);
    }
}
