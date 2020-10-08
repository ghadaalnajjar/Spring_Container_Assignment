package org.example.data_access;

import org.example.model.Student;
import org.example.sequence.StudentSequence;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("studentDao")
public class StudentDaoListImp implements StudentDao {

    private List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(StudentSequence.nextStudentId());
            students.add(student);
        } else {
            Student findStudent = find(student.getId());
            if(findStudent.getId() == null){
                student.setId(StudentSequence.nextStudentId());
                students.add(student);
            }else {
                students.remove(findStudent);
                findStudent.setId(student.getId());
                findStudent.setName(student.getName());
                students.add(findStudent);
            }
        }
        return student;
    }

    @Override
    public Student find(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Student> findAll() {
        if (students == null) {
            throw new IllegalArgumentException();
        }
        return students;
    }

    @Override
    public void delete(int id) {
        Student student = find(id);
        students.remove(student);
    }
}
