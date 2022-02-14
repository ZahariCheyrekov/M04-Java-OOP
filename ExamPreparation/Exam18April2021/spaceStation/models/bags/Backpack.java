package M04_JavaOOP.ExamPreparation.Exam18April2021.spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag {
    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}