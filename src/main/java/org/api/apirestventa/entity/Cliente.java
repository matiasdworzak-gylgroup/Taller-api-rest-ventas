package org.api.apirestventa.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length =100)
    private String nombre;

    @Column(nullable = false, length =100)
    private String apellido;

    @Column(nullable = false, length =100)
    private String correo;

    @Column(nullable = false, length =100)
    private String telefono;

    @Column(nullable = false, length =100)
    private String direccion;

}
