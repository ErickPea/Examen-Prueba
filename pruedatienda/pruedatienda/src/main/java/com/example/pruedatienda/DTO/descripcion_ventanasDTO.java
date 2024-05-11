package com.example.pruedatienda.DTO;

import com.example.pruedatienda.Entity.productos;
import com.example.pruedatienda.Entity.ventas;

public interface descripcion_ventanasDTO extends IGenericDTO {

	ventas getVenta();

	productos getProducto();

	Double getCantidad();

	Double getPrecioDecimal();

	Double getDescuentoDecimal();

	Double getSub_Total();

}
