package M04_JavaOOP.L07_ReflectionAndAnnotation.Lab.T05CodingTracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    public String name();
}