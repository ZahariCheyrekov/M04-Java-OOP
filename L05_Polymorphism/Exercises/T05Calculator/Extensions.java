package M04_JavaOOP.L05_Polymorphism.Exercises.T05Calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new InputInterpreter(engine);
    }
}