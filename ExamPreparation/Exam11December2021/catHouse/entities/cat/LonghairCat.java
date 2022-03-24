package catHouse.entities.cat;

public class LonghairCat extends BaseCat {

    private static final int KILOGRAMS = 9;
    private static final int INCREASE_PER_EAT = 3;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        this.setKilograms(KILOGRAMS + INCREASE_PER_EAT);
    }
}
