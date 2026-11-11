package com.student.studentmanagement.service;
import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 1. Add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // 2. Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 3. Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Student not found with ID: " + id));
    }

    // 4. Update student details
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = getStudentById(id);

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setAge(updatedStudent.getAge());

        return studentRepository.save(existingStudent);
    }

    // 5. Delete student
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        studentRepository.delete(student);
    }

    // 6. Get students by course
    public List<Student> getStudentsByCourse(String course) {
        return studentRepository.findByCourse(course);
    }
}
