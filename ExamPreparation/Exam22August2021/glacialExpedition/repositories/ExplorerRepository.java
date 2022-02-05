package M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.repositories;

import M04_JavaOOP.ExamPreparation.Exam22August2021.glacialExpedition.models.explorers.Explorer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExplorerRepository implements Repository<Explorer> {
    Map<String, Explorer> explorerMap;

    public ExplorerRepository() {
        explorerMap = new LinkedHashMap<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(this.explorerMap.values());
    }

    @Override
    public void add(Explorer explorer) {
        explorerMap.put(explorer.getName(), explorer);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorerMap.remove(entity.getName()) != null;
    }

    @Override
    public Explorer byName(String name) {
        return explorerMap.get(name);
    }
}
