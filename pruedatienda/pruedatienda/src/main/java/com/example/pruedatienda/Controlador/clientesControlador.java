package com.example.pruedatienda.Controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruedatienda.DTO.clientesDTO;
import com.example.pruedatienda.DTO.ApiRespondeDTO;
import com.example.pruedatienda.Entity.ABaseEntity;
import com.example.pruedatienda.Entity.clientes;

import com.example.pruedatienda.IService.clientesISERVICE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/clientes")
public class clientesControlador extends ABasecontroller<clientes, clientesISERVICE> {

	public clientesControlador(clientesISERVICE service) {
		super(service, "clientes");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
	public ResponseEntity<ApiRespondeDTO<List<clientesDTO>>> show() {
		try {
			List<clientesDTO> entity = service.getlistClientesDTO();
			return ResponseEntity.ok(new ApiRespondeDTO<List<clientesDTO>>("Registro encontrado", entity, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(new ApiRespondeDTO<List<clientesDTO>>(e.getMessage(), null, false));

		}

	}

}
