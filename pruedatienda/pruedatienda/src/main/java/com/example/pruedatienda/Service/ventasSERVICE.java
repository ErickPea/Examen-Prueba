package com.example.pruedatienda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.ventaDTO;
import com.example.pruedatienda.Entity.ventas;
import com.example.pruedatienda.IRepository.IBaseRepository;
import com.example.pruedatienda.IRepository.ventasREPOSITORY;
import com.example.pruedatienda.IService.ventaISERVICE;

@Service
public class ventasSERVICE extends ABaseService<ventas> implements ventaISERVICE {

	@Override
	public List<ventaDTO> getListventaDTO() {
		// TODO Auto-generated method stub
		return repository.getListventaDTO();
	}

	@Autowired
	public ventasREPOSITORY repository;

	@Override
	protected IBaseRepository<ventas, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

}
