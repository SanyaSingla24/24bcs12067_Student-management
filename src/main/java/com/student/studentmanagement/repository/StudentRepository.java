
package com.student.studentmanagement.repository;

import com.student.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    // Find students by course
    List<Student> findByCourse(String course);

}
