package M04_JavaOOP.L07_ReflectionAndAnnotation.Lab.T04CreateAnnotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = TestClass.class.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName());

            Arrays.stream(annotation
                    .annotationType()
                    .getDeclaredMethods())
                    .forEach(field -> System.out.println(field.getName()));
        }

        System.out.println(TestClass.class.getAnnotation(Subject.class).categories()[0]);
        System.out.println(TestClass.class.getAnnotation(Subject.class).categories()[1]);
    }
}