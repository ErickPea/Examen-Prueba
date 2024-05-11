package com.example.pruedatienda.DTO;

public interface productosDTO extends IGenericDTO {

	String getNombre_producto();

	String getCantidad();

	Double getPrecioDecimal();

	Double getPorcentaje_iva();

	Double getPorcentajeDescuento();

}
