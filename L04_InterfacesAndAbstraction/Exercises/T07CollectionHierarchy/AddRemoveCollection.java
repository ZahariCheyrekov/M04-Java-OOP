package M04_JavaOOP.L04InterfacesAndAbstraction.Exercises.T07CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {
  
    @Override
    public String remove() {
        int lastElementIndex = super.getItems().size() - 1;

      return super.getItems().remove(lastElementIndex);
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }
}
