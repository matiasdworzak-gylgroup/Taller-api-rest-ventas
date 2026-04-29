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
@Table(name="Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

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
