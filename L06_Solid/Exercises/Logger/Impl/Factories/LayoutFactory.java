package M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Factories;

import M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Layouts.SimpleLayout;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Impl.Layouts.XmlLayout;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Factory;
import M04_JavaOOP.L06_Solid.Exercises.Logger.Interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if(input.equals("SimpleLayout")){
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")){
            layout = new XmlLayout();
        }

        return layout;
    }
}