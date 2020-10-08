package org.example;

import org.example.data_access.StudentDao;
import org.example.model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    public static void main(String args[]){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao service = context.getBean("studentDao",StudentDao.class);
        Student student = new Student("ana1");
        service.save(student);
        service.save(new Student("ana2"));
        service.save(new Student("ana3"));
        System.out.println("student.toString() = " + student.toString());

        Student studentFind = service.find(student.getId());
        System.out.println("studentFind = " + studentFind);

        List<Student> findAll =service.findAll();
        System.out.println("findAll = " + findAll.toString());

        service.save(new Student(1, "ana4"));
        System.out.println("ana4 = " + service.save(new Student(1, "ana4")).toString());

    }
}
