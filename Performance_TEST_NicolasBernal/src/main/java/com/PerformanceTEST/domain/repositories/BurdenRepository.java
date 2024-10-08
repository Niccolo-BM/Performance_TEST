package com.PerformanceTEST.domain.repositories;

import com.PerformanceTEST.domain.entities.Burden;

import com.PerformanceTEST.domain.entities.Palet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BurdenRepository extends JpaRepository<Burden, Long> {

    static Burden save(Palet palet) {
        return null;
    }

    Optional<Object> findById();
}
