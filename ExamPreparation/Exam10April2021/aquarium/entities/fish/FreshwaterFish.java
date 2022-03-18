package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish {

    private static final int SIZE = 3;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        this.setSize(SIZE + 3);
    }
}
