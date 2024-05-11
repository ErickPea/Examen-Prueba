package com.example.pruedatienda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.clientesDTO;
import com.example.pruedatienda.Entity.clientes;
import com.example.pruedatienda.IRepository.IBaseRepository;
import com.example.pruedatienda.IRepository.clientesREPOSITORY;
import com.example.pruedatienda.IService.clientesISERVICE;

@Service
public class clientesSERVICE extends ABaseService<clientes> implements clientesISERVICE {

	@Override
	public List<clientesDTO> getlistClientesDTO() {
		// TODO Auto-generated method stub
		return repository.getlistClientesDTO();
	}

	@Autowired
	public clientesREPOSITORY repository;

	@Override
	protected IBaseRepository<clientes, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);

	}

}
