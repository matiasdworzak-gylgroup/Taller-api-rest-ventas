package org.api.apirestventa.mapper;

import org.api.apirestventa.dto.ProductoRequestDto;
import org.api.apirestventa.dto.ProductoResponseDto;
import org.api.apirestventa.entity.Producto;

public class ProductoMapper {

    private ProductoMapper() {}

    public static Producto toEntity(ProductoRequestDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());

        return producto;
    }

    public static ProductoResponseDto toResponseDto(Producto producto) {
        return new ProductoResponseDto(
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getTipoProducto() != null ? producto.getTipoProducto().getIdTipoProducto() : null,
                producto.getTipoProducto() != null ? producto.getTipoProducto().getNombre() : null
        );
    }

    public static void updateEntity(Producto producto, ProductoRequestDto dto) {
        producto.setNombre(dto.nombre());
        producto.setPrecio(dto.precio());
        producto.setStock(dto.stock());
    }
}
