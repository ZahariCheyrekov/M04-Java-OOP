package fairyShop;

import fairyShop.core.interfaces.Engine;
import fairyShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}