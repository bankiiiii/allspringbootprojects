package com.newassessor.newassessor.repository;

import com.newassessor.newassessor.model.NewAssessor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HashMapRepository implements GeneralRepository<NewAssessor, Long> {

    private final Map<Long, NewAssessor> assessorHashMap = new HashMap<>();

    @Override
    public NewAssessor save(NewAssessor assessor) {

        assessorHashMap.put(assessor.getId(), assessor);
        return assessor;
    }

    @Override
    public NewAssessor findById(Long id) {
        return assessorHashMap.get(id);
    }

    @Override
    public void deleteById(Long id) {
        assessorHashMap.remove(id);
    }

    @Override
    public List<NewAssessor> findAll() {
        return List.copyOf(assessorHashMap.values());
    }

    @Override
    public NewAssessor update(NewAssessor assessor) {
        long id = assessor.getId();
        if (assessorHashMap.containsKey(id)) {
            assessorHashMap.put(id, assessor);
            return assessor;
        }
        return null; // If the assessor with the given ID does not exist
    }
}
