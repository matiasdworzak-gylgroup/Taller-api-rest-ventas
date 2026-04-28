package org.api.apirestventa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Tipo_Productos")
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_tipo_producto;

    @Column(nullable = false, length =100)
    private String nombre;

    @Column(nullable = false, length =100)
    private String descripcion;
}
