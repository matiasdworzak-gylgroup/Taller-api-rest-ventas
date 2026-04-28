package org.api.apirestventa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_producto;

    @Column(nullable = false, length =100)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;


}
