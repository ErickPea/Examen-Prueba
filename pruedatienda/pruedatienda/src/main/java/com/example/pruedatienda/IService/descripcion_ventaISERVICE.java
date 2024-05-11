package com.example.pruedatienda.IService;

import com.example.pruedatienda.Entity.descripcion_ventas;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.descripcion_ventanasDTO;

@Service
public interface descripcion_ventaISERVICE extends IBaseService<descripcion_ventas> {

	List<descripcion_ventanasDTO> getdescripcion_ventasDTO();

}
