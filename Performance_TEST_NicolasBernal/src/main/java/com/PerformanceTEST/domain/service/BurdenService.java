package com.PerformanceTEST.domain.service;

import com.PerformanceTEST.domain.entities.Burden;
import com.PerformanceTEST.domain.entities.Palet;
import com.PerformanceTEST.domain.repositories.BurdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurdenService {
    @Autowired
    private BurdenRepository burdenRepository;

    public Burden CreateBurden(Burden burden) {
        return burdenRepository.save(burden);
    }

    public Burden burdenStatusUpDate(Long id, Burden burdenUpDate) {
        return burdenRepository.findById(id)
                .map(burden-> {
                    burden.setBurdenStatus(burdenUpDate.getBurdenStatus());
                    return BurdenRepository.save(burden.getBurden());
                })
                .orElse(null);
    }

    public List<Burden> obtenerCargas() {
        return burdenRepository.findAll();
    }

    public Burden obtenerCargaPorId(Long id) {
        return burdenRepository.findById(id).orElse(null);
    }
}
