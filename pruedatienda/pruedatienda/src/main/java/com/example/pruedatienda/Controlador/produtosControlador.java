package com.example.pruedatienda.Controlador;

import com.example.pruedatienda.Entity.productos;
import com.example.pruedatienda.DTO.productosDTO;
import com.example.pruedatienda.IService.productosISERVICE;
import com.example.pruedatienda.DTO.ApiRespondeDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/productos")
public class produtosControlador extends ABasecontroller<productos, productosISERVICE> {

	public produtosControlador(productosISERVICE service) {
		super(service, "productos");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
	public ResponseEntity<ApiRespondeDTO<List<productosDTO>>> show() {

		try {
			List<productosDTO> entity = service.getlistproductosDTO();
			return ResponseEntity.ok(new ApiRespondeDTO<List<productosDTO>>("Registro encontrado", entity, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(new ApiRespondeDTO<List<productosDTO>>(e.getMessage(), null, false));
		}

	}

}
