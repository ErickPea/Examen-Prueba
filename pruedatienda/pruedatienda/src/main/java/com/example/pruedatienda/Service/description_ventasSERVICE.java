package com.example.pruedatienda.Service;

import com.example.pruedatienda.Entity.descripcion_ventas;
import com.example.pruedatienda.IRepository.IBaseRepository;
import com.example.pruedatienda.IRepository.descripcion_ventaREPOSITORY;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.descripcion_ventanasDTO;
import com.example.pruedatienda.IService.descripcion_ventaISERVICE;

@Service
public class description_ventasSERVICE extends ABaseService<descripcion_ventas> implements descripcion_ventaISERVICE {

	@Override
	public List<descripcion_ventanasDTO> getdescripcion_ventasDTO() {
		// TODO Auto-generated method stub
		return repository.getdescripcion_ventasDTO();
	}

	@Autowired
	public descripcion_ventaREPOSITORY repository;

	@Override
	protected IBaseRepository<descripcion_ventas, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		;

	}

}
