package com.PerformanceTEST.domain.repositories;

import com.PerformanceTEST.domain.entities.Palet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaletRepository extends JpaRepository<Palet, Long> {
}
