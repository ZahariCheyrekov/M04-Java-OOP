package M04_JavaOOP.L06_Solid.Lab.T01SingleRepository;

import M04_JavaOOP.L06_Solid.Lab.T01SingleRepository.Interfaces.DrawingManager;
import M04_JavaOOP.L06_Solid.Lab.T01SingleRepository.Interfaces.DrawingRepository;
import M04_JavaOOP.L06_Solid.Lab.T01SingleRepository.Interfaces.Rengerer;
import M04_JavaOOP.L06_Solid.Lab.T01SingleRepository.Interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Rengerer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Rengerer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        shape.draw(this.renderer, this.drawingRepository);
    }
}
