package com.example.pruedatienda.IService;

import com.example.pruedatienda.Entity.productos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pruedatienda.DTO.productosDTO;

@Service
public interface productosISERVICE extends IBaseService<productos> {

	List<productosDTO> getlistproductosDTO();
}
