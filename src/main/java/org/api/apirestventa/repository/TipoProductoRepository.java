package org.api.apirestventa.repository;

import org.api.apirestventa.entity.Cliente;
import org.api.apirestventa.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    List<TipoProducto> findByNombre(String nombre);
}
