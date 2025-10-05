package com.assurea.pcm.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    @Column(nullable=false)
    private String name;

    @Email(message = "Email invalide")
    @Column(unique=true) 
    private String email;
    
    @Pattern(regexp = "^(\\+213|0)[5-7][0-9]{8}$", message = "Numéro de téléphone invalide")
    @Column(unique=true)
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Policy> policies;
}