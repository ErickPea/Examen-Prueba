package com.example.pruedatienda.Controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruedatienda.DTO.ApiRespondeDTO;
import com.example.pruedatienda.DTO.ventaDTO;

import com.example.pruedatienda.IService.ventaISERVICE;
import com.example.pruedatienda.Entity.ventas;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/ventas")
public class ventasControlador extends ABasecontroller<ventas, ventaISERVICE> {

	protected ventasControlador(ventaISERVICE service) {
		super(service, "ventas");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
	public ResponseEntity<ApiRespondeDTO<List<ventaDTO>>> show() {
		try {
			List<ventaDTO> entity = service.getListventaDTO();
			return ResponseEntity.ok(new ApiRespondeDTO<List<ventaDTO>>("Registro encontrado", entity, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(new ApiRespondeDTO<List<ventaDTO>>(e.getMessage(), null, false));

		}

	}

}
