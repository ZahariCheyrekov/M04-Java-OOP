package M04_JavaOOP.L07_ReflectionAndAnnotation.Exercises.T05BarracksWarsReturnOfTheDependencies;



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Inject {

}
