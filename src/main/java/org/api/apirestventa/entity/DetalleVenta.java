package org.api.apirestventa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Detalle_ventas")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_detalle_venta;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private BigDecimal precio_unitario;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

}
