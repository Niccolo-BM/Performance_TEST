package com.PerformanceTEST.domain.service;


import com.PerformanceTEST.domain.entities.Palet;
import com.PerformanceTEST.domain.exception.PaletException;
import com.PerformanceTEST.domain.repositories.PaletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaletService {

    @Autowired
    private PaletRepository paletRepository;

    public Palet createPalet(Palet palet) {
        return paletRepository.save(palet);
    }

    public Palet paletUpDate(Long id, Palet paletToUpDate) {
        Optional<Palet> paletOpt = paletRepository.findById(id);
        if (paletOpt.isPresent()) {
            Palet palet = paletOpt.get();
            palet.setMaxCapacity(paletToUpDate.getMaxCapacity());
            palet.setUbication(paletToUpDate.getUbication());
            palet.setStatus(paletToUpDate.getStatus());
            return paletRepository.save(palet);
        }


        return null;
    }

    public void eliminarPalet(Long id) {
        paletRepository.deleteById(id);
    }

    public List<Palet> getAllPalet() {
        return paletRepository.findAll();
    }

    public Palet getPalletById(Long id) {
        return paletRepository.findById(id).orElse(null);
    }

    public void assignBurden(Palet palet, double burdenWeight)
        throws PaletException.PaletCapacityExceededException {
        double actualWeight = palet.calculateCurrentWeight();
        if (actualWeight + burdenWeight > palet.getMaxCapacity()) {
            throw new PaletException.PaletCapacityExceededException("has exceeded the maximum capacity");
        }

    }
}
