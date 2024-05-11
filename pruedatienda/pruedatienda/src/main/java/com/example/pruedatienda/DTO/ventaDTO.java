package com.example.pruedatienda.DTO;

import com.example.pruedatienda.Entity.clientes;

public interface ventaDTO extends IGenericDTO {

	clientes getCliente();

	String getFecha_venta();

	String getTotal();

}
