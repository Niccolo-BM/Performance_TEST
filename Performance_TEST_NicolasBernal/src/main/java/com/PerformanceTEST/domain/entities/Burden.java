package com.PerformanceTEST.domain.entities;

import com.PerformanceTEST.domain.enums.BurdenStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Entity(name = "Burdens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Burden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weight;
    private String dimensions;

    @Enumerated(EnumType.STRING)
    private BurdenStatus burdenStatus;

    @ManyToOne
    @JoinColumn(name = "palet_id")
    private Palet palet;

    public Palet getBurden() {
        return null;
    }
}
