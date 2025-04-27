package ir.java.generics.streams;

import java.lang.reflect.Constructor;

public class ReflectionConcepts {
    public static void main(String args[]) throws Exception{
        System.out.println("welcome to Reflections!");
        Class personClass = null;
        try {
            personClass = Class.forName("ir.java.generics.streams.Person");

        }catch (ClassNotFoundException exp){
            exp.printStackTrace();
        }
        System.out.println(personClass.getName());
        // to access private fields, we use getDeclaredFields() method and set them setAccessible(true)

        Constructor<Person> constructor = Person.class.getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
       Person person = constructor.newInstance();

        System.out.println(person);
    }
}
