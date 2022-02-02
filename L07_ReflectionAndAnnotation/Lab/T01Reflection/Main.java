package M04_JavaOOP.L07_ReflectionAndAnnotation.Lab.T01Reflection;

import M04_JavaOOP.L07_ReflectionAndAnnotation.Lab.T02GettersAndSetters.Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            Class<Reflection> clazz = Reflection.class;
            System.out.println(clazz);
            System.out.println(clazz.getSuperclass());

            for (Class cl : clazz.getInterfaces())
                System.out.println(cl);
            Object object = clazz.getDeclaredConstructor().newInstance();

            System.out.println(object);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            System.out.println(ex.getMessage());
        }
    }
}