package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{
    private static final double ANIMAL_EXPLORER_ENERGY = 100;

    public AnimalExplorer(String name) {
        super(name, ANIMAL_EXPLORER_ENERGY);
    }
}
