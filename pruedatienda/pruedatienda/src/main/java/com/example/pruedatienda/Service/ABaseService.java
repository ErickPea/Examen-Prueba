package com.example.pruedatienda.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.beans.BeanUtils;

import com.example.pruedatienda.Entity.ABaseEntity;
import com.example.pruedatienda.IRepository.IBaseRepository;
import com.example.pruedatienda.IService.IBaseService;

public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T> {

	protected abstract IBaseRepository<T, Long> getRepository();

	@Override
	public List<T> all() throws Exception {
		// TODO Auto-generated method stub
		return getRepository().findAll();
	}

	@Override
	public List<T> findByStateTrue() throws Exception {
		// TODO Auto-generated method stub
		return getRepository().findAll();
	}

	@Override
	public Optional<T> findById(Long id) throws Exception {
		Optional<T> op = getRepository().findById(id);

		if (op.isEmpty()) {

			throw new Exception("Registro no encontrado");
		}
		// TODO Auto-generated method stub
		return op;
	}

	@Override
	public T save(T entity) throws Exception {

		try {
			entity.setCreatedAt(LocalDateTime.now());
			entity.setCreatedBy((long) 1);
			return getRepository().save(entity);

		} catch (Exception e) {

			throw new Exception("Error al guardar la entidad" + e.getMessage());
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Long id, T entity) throws Exception {

		Optional<T> op = getRepository().findById(id);

		if (op.isEmpty()) {
			throw new Exception("Registro no encontrado");
		} else if (op.get().getDeletedAt() != null) {

			throw new Exception("Registro inabilitado");
		}

		T entityUpdate = op.get();
		String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
		BeanUtils.copyProperties(entityUpdate, entity, ignoreProperties);
		entityUpdate.setUpdatedAt(LocalDateTime.now());
		entityUpdate.setUpdatedBy((long) 1);
		getRepository().save(entityUpdate);

	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
