package com.demo.spring.springcore;

import com.demo.spring.springcore.dao.StudentDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
    private StudentDAO studentDAO;

    @Bean(name = "student")
    public Student getStudent() {
        Student student = new Student();
        student.setName("Elise White");
        student.setId(1);

        return student;
    }

    @Bean(name = "consoleEventLogger")
    public ConsoleEventLogger getConsoleEventLogger() {
        return new ConsoleEventLogger();
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
}
