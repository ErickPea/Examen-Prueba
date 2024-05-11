package com.example.pruedatienda.IRepository;

import com.example.pruedatienda.Entity.productos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pruedatienda.DTO.productosDTO;

@Repository
public interface productosREPOSITORY extends IBaseRepository<productos, Long> {

	@Query(value = "SELECT" +

			"p.id," + "p.created_at," + "p.created_by," + "p.Estado" + "p.update_at" + "p.update_by" + "p.deleted_by"
			+ "p.deleted_at," + "p.nombre_producto," + "p.descripcion," + "p.cantidad," + "p.precioDecimal,"
			+ "p.porcentaje_iva," + "p.porcentajeDescuento," +

			"FROM" + "pruebatienda.productos as p", nativeQuery = true)

	List<productosDTO> getlistproductosDTO();

}
