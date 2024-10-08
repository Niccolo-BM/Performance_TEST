package com.PerformanceTEST.domain.entities;

import com.PerformanceTEST.domain.enums.PaletStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity(name = "Palets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Palet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long maxCapacity;

    private String ubication;


    @Enumerated(EnumType.STRING)
    private PaletStatus status;

    @OneToMany(mappedBy = "palet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Burden> burden;

    public double calculateCurrentWeight() {
        return 0;
    }
}
