package com.example.pruedatienda.IRepository;

import com.example.pruedatienda.Entity.descripcion_ventas;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pruedatienda.DTO.descripcion_ventanasDTO;

@Repository
public interface descripcion_ventaREPOSITORY extends IBaseRepository<descripcion_ventas, Long> {

	@Query(value = "SELECT" +

			"d.id," + "d.created_at," + 
			"d.created_by," +
			"d.Estado" + "d.update_at" + "d.update_by" + "d.deleted_by"
			+ "d.deleted_at," +
			"d.cantidad," +
			"d.precioDecimal,"+
			"d.descuentoDecimal,"+
			"d.Sub_total"+

			"FROM" + "pruebatienda.descripcion_ventas as d"+
			"inner join" +"ventas on v.id=d.ventas_id"+
			"inner join" +"productos on p.id=d.productos_id",
			nativeQuery = true)

	List<descripcion_ventanasDTO> getdescripcion_ventasDTO();

}
