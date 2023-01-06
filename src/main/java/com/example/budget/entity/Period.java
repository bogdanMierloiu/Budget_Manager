package com.example.budget.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(
            mappedBy = "period",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<ExpectedIncome> expectedIncome = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Period period = (Period) o;
        return id != null && Objects.equals(id, period.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}