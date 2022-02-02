package M04_JavaOOP.L06_Solid.Lab.T02OpenClosedPrinciples.DrawingShape;

import M04_JavaOOP.L06_Solid.Lab.T01SingleRepository.Interfaces.DrawingManager;
import M04_JavaOOP.L06_Solid.Lab.T01SingleRepository.Interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {


    @Override
    public void draw(Shape shape) {
        if (shape instanceof Circle)
        {
            this.drawCircle((Circle)shape);
        }
            else if (shape instanceof Rectangle)
        {
            this.drawRectangle(((Rectangle)shape));
        }
    }
    public void drawCircle(Circle circle)
    {
        // Draw Circle
    }

    public void drawRectangle(Rectangle rectangle)
    {
        // Draw Rectangle
    }
}
