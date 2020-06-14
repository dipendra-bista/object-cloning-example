package com.punojsoft.cloneexample;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(1, "dipendra bista", 27);
        Department department = new Department(1, "IT");
        person.setDepartment(department);

        /**
         * Before Cloning
         */
        System.out.println(person);
        Person person1 = person;
        System.out.println("person1 :" + person1);
        /**
         * with == assignment ,original object will be changed since using == ,
         * we are assiging reference not the value
         */
        person1.setName("parisha khadka");
        person1.setDepartment(new Department(2, "Management"));

        System.out.println("Original object :" + person);
        //must be true because it should share same memeory address
        System.out.println(person == person1);


        Person person2 = (Person) person.clone();
        person2.setAge(30);
        /**
         * for primitives types object sallow copy working fine,it will not
         * affect the original class incase if reference object it will change
         * the original Object
         */
        person2.getDepartment().setName("Humanities");
        System.out.println("Original object : " + person);
        System.out.println("Modify object : " + person2);
        //must be false ,since it doesnot share same memory
        System.out.println(person == person2);
        /**
         * to avoid modification on original object for reference type
         * we should go for Deep copy [implement Cloneable for Department also
         * implement custom clone method]
         */
        Person person3 = (Person) person.clone();
        /**
         * i .As a programmer it is our responsibility to make sure
         *      to implement Cloneable interface to call clone method on
         *      given object .So it is a best practice to check instance
         *      of Cloneable.
         *
         * ii.clone method doesn't call constructor so its our responsibility
         * to set all the property of the object
         */
        if (person instanceof Cloneable) {
            person2.getDepartment().setName("Science");

        }
        System.out.println("Original object : " + person);
        System.out.println("Modify object : " + person2);
        //must be false ,since it doesnot share same memory
        System.out.println(person == person2);
        /**
         * Deep cloning using Serealization ( commons.lang3 SerializationUtils)
         * we just need to make object Serializable
         */
        Employee employee = new Employee(1, "puja khadka", new Department(1, "commerce"));
        if (employee instanceof Serializable) {
            Employee employee1 = (Employee) SerializationUtils.clone((Serializable) employee);
            employee1.setName("maiya bista");
            System.out.println("original object : " + employee);
            System.out.println("Modified object : " + employee1);
        }


    }
}
