package org.api.apirestventa.repository;

import org.api.apirestventa.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
       List<Venta> findByCliente_IdCliente(Long id);
}
