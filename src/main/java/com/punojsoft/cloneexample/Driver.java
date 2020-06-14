package com.punojsoft.cloneexample;

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


    }
}