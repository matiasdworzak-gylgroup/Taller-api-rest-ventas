package org.api.apirestventa.exception;

public class ProductoFaltanteDeStockException extends RuntimeException {
    public ProductoFaltanteDeStockException(String message) {
        super(message);
    }
}
