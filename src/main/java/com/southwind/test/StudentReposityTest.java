package com.southwind.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.southwind.entity.Student;
import com.southwind.repository.StudentReposity;

public class StudentReposityTest {
    private static StudentReposity studentReposity;
    static {
        studentReposity = (StudentReposity) new ClassPathXmlApplicationContext("classpath:spring.xml").getBean("studentReposity");
    }

    public static void main(String[] args) {
        findBySort();
    }

    public static void getCount() {
        long count = studentReposity.count();
        System.out.println(count);
    }

    public static void findById() {
        Student student = studentReposity.findById("5b62c6f55a41f60d93ffe6c2").get();
        System.out.println(student);
    }

    public static void findAll() {
        Iterator<Student> iterator = studentReposity.findAll().iterator();
        while(iterator.hasNext()) {
            Student Student = iterator.next();
            System.out.println(Student);
        }
    }

    public static void findAllById() {
        List<String> ids = new ArrayList<String>();
        ids.add("5b62c6f55a41f60d93ffe6c2");
        ids.add("5b62c6f55a41f60d93ffe6c3");
        ids.add("5b62c6f55a41f60d93ffe6c4");
        Iterator<Student> iterator = studentReposity.findAllById(ids).iterator();
        while(iterator.hasNext()) {
            Student Student = iterator.next();
            System.out.println(Student);
        }
    }

    public static void existsById() {
        boolean flag = studentReposity.existsById("5b62c6f55a41f60d93ffe6c2");
        System.out.println(flag);
    }

    public static void delete() {
        Student Student = studentReposity.findById("5b5193c5f872cb041d1caa4d").get();
        studentReposity.delete(Student);
    }

    public static void deleteById() {
        studentReposity.deleteById("5b62c6f55a41f60d93ffe6c2");
    }

    public static void deleteAllByIterable() {
        Student Student = studentReposity.findById("5b62c6f55a41f60d93ffe6c1").get();
        Student Student2 = studentReposity.findById("5b62c6f55a41f60d93ffe6c3").get();
        Student Student3 = studentReposity.findById("5b62c6f55a41f60d93ffe6c4").get();
        List<Student> list = new ArrayList<Student>();
        list.add(Student);
        list.add(Student2);
        list.add(Student3);
        studentReposity.deleteAll(list);
    }

    public static void deletAll() {
        studentReposity.deleteAll();
    }

    public static void findByName() {
        List<Student> list = studentReposity.findByName("张三1");
        for (Student Student : list) {
            System.out.println(Student);
        }
    }

    public static void findByNameAndAge() {
        List<Student> list = studentReposity.findByNameAndAge("张三1",16);
        for (Student Student : list) {
            System.out.println(Student);
        }
    }

    public static void findBySort() {
        List<Student> list = studentReposity.findAll(Sort.by(Direction.ASC,"age"));
        for (Student Student : list) {
            System.out.println(Student);
        }
    }
}