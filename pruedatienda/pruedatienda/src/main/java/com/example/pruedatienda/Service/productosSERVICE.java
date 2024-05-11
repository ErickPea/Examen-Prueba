package com.example.pruedatienda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.productosDTO;
import com.example.pruedatienda.Entity.productos;
import com.example.pruedatienda.IRepository.IBaseRepository;
import com.example.pruedatienda.IRepository.productosREPOSITORY;
import com.example.pruedatienda.IService.productosISERVICE;

@Service
public class productosSERVICE extends ABaseService<productos> implements productosISERVICE {

	@Override
	public List<productosDTO> getlistproductosDTO() {
		// TODO Auto-generated method stub
		return repository.getlistproductosDTO();
	}

	@Autowired
	public productosREPOSITORY repository;

	@Override
	protected IBaseRepository<productos, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
