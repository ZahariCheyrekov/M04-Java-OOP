package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T07CollectionHierarchy;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        super.getItems().add(item);
        return super.getItems().indexOf(item);
    }
}