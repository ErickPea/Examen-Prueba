package com.example.pruedatienda.IRepository;

import com.example.pruedatienda.Entity.ventas;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pruedatienda.DTO.ventaDTO;

@Repository
public interface ventasREPOSITORY extends IBaseRepository<ventas, Long> {

	@Query(value = "SELECT" +

			"v.id," + "v.created_at," + "v.created_by," + "v.Estado" + "v.update_at" + "v.update_by" + "v.deleted_by"
			+ "v.deleted_at," + "v.total," + "v.fecha_venta," + "c.nombre_cliente," + "c.tipo_identificacion,"+
			"c.identificacion,"+ "c.telefono," +"c.direccion,"+
			"c.ciudad"+

			"FROM" + "pruebatienda.ventas as v" + 
			"INNER JOIN" + "cliente on c.id= v.clientes.id", nativeQuery = true)

	List<ventaDTO> getListventaDTO();
}
