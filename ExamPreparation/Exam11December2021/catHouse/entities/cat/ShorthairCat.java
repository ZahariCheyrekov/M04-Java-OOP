package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {

    private static final int KILOGRAMS = 7;
    private static final int INCREASE_PER_EAT = 1;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void eating() {
        super.setKilograms(KILOGRAMS + INCREASE_PER_EAT);
    }
}
