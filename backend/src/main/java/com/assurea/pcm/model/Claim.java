package com.assurea.pcm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    @NotNull(message = "La police est obligatoire")
    private Policy policy;

    @NotNull(message = "La date est obligatoire")
    private LocalDate date;

    @NotBlank(message = "La description est obligatoire")
    private String description;

    @NotNull(message = "Le statut est obligatoire")    
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        OPEN, IN_PROGRESS, CLOSED
    }
}