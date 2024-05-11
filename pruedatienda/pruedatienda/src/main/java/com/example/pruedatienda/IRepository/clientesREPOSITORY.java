package com.example.pruedatienda.IRepository;

import com.example.pruedatienda.Entity.clientes;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pruedatienda.DTO.clientesDTO;

@Repository
public interface clientesREPOSITORY extends IBaseRepository<clientes, Long> {

	@Query(value = "SELECT" +

			"c.id," + "c.created_at," + "c.created_by," + "c.Estado" + "c.update_at" + "c.update_by" + "c.deleted_by"
			+ "c.deleted_at," + "c.tipo_identificacion" + "c.identificacion" + "c.nombre_cliente" + "c.apellido_cliente"
			+ "c.telefono" + "c.direccion" + "c.ciudad" + "FROM" + "pruebatienda.clientes as c", nativeQuery = true)

	List<clientesDTO> getlistClientesDTO();

}
