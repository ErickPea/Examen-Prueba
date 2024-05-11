package com.example.pruedatienda.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.pruedatienda.Entity.ABaseEntity;
import com.example.pruedatienda.IService.IBaseService;
import com.example.pruedatienda.DTO.ApiRespondeDTO;

public class ABasecontroller<T extends ABaseEntity, S extends IBaseService<T>> {

	protected S service;
	protected String entityName;

	protected ABasecontroller(S service, String entityName) {

		this.service = service;
		this.entityName = entityName;
	}

	@GetMapping
	public ResponseEntity<ApiRespondeDTO<List<T>>> finsByEstadoTrue() {
		try {
			return ResponseEntity.ok(new ApiRespondeDTO<List<T>>("Datos obtenidos", service.findByStateTrue(), true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiRespondeDTO<List<T>>(e.getMessage(), null, false));
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiRespondeDTO<Optional<T>>> show(@PathVariable Long id) {
		try {

			Optional<T> entity = service.findById(id);
			return ResponseEntity.ok(new ApiRespondeDTO<Optional<T>>("Registro encontrado", entity, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(new ApiRespondeDTO<Optional<T>>(e.getMessage(), null, false));
		}

	}

	@PostMapping
	public ResponseEntity<ApiRespondeDTO<T>> save(@RequestBody T entity) {
		try {

			return ResponseEntity.ok(new ApiRespondeDTO<T>("Datos guardados", service.save(entity), true));
		} catch (Exception e) {

			return ResponseEntity.internalServerError().body(new ApiRespondeDTO<T>(e.getMessage(), null, false));

		}

	}

	@DeleteMapping
	public ResponseEntity<ApiRespondeDTO<T>> delete(@PathVariable Long id) {

		try {
			service.delete(id);
			return ResponseEntity.ok(new ApiRespondeDTO<T>("Registro eliminado", null, true));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiRespondeDTO<T>(e.getMessage(), null, false));
		}

	}

}
