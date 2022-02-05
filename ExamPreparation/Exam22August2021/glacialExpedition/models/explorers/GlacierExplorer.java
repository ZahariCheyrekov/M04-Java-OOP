package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer {
    private static final double GLACIER_EXPLORER_ENERGY = 40;

    public GlacierExplorer(String name) {
        super(name, GLACIER_EXPLORER_ENERGY);
    }
}
