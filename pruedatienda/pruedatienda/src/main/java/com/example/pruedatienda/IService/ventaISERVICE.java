package com.example.pruedatienda.IService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.ventaDTO;
import com.example.pruedatienda.Entity.ventas;

@Service
public interface ventaISERVICE extends IBaseService<ventas> {
	List<ventaDTO> getListventaDTO();

}
