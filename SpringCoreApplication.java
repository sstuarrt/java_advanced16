package com.demo.spring.springcore;

import com.demo.spring.springcore.dao.StudentDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringCoreApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);

        Student student = (Student) ctx.getBean("student");

        ConsoleEventLogger cel = (ConsoleEventLogger) ctx.getBean("consoleEventLogger");

        cel.logEvent(student.getId() + "--->" + student.getName() + "--->" + student.getAge());

        StudentDAO studentDAO = new StudentDAO() {
            @Override
            public Student create(Student student) {
                return studentDAO.create(student);
            }

            @Override
            public Student read(Integer id) {
                return studentDAO.read(id);
            }

            @Override
            public Student update(Student student) {
                return studentDAO.update(student);
            }

            @Override
            public void delete(Integer id) {
                studentDAO.delete(id);
            }

            @Override
            public List<Student> readAll() {
                return studentDAO.readAll();
            }
        };
    }
}
