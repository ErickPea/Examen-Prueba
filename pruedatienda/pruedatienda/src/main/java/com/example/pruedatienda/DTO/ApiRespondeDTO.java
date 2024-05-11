package com.example.pruedatienda.DTO;

public class ApiRespondeDTO<T> {

	private Boolean estado;
	private T data;
	private String message;

	public ApiRespondeDTO(String message, T data, Boolean estado) {

		this.message = message;
		this.data = data;
		this.estado = estado;

	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
