package com.example.pruedatienda.IService;

import com.example.pruedatienda.Entity.clientes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.clientesDTO;

@Service
public interface clientesISERVICE extends IBaseService<clientes> {

	List<clientesDTO> getlistClientesDTO();

}
