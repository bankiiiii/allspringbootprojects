package com.newassessor.newassessor.repository;

import com.newassessor.newassessor.model.NewAssessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<NewAssessor, Long>{
}
