package com.example.pruedatienda.Controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruedatienda.IService.descripcion_ventaISERVICE;
import com.example.pruedatienda.Entity.descripcion_ventas;
import com.example.pruedatienda.DTO.ApiRespondeDTO;
import com.example.pruedatienda.DTO.descripcion_ventanasDTO;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/descripcion_ventas")
public class descripcion_ventasControlador extends ABasecontroller<descripcion_ventas, descripcion_ventaISERVICE> {

	public descripcion_ventasControlador(descripcion_ventaISERVICE service) {
		super(service, "descripcion_ventas");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
	public ResponseEntity<ApiRespondeDTO<List<descripcion_ventanasDTO>>> show() {

		try {
			List<descripcion_ventanasDTO> entity = service.getdescripcion_ventasDTO();
			return ResponseEntity
					.ok(new ApiRespondeDTO<List<descripcion_ventanasDTO>>("Registro agregado", entity, true));

		} catch (Exception e) {

			return ResponseEntity.internalServerError()
					.body(new ApiRespondeDTO<List<descripcion_ventanasDTO>>(e.getMessage(), null, false));
		}
	}

}
