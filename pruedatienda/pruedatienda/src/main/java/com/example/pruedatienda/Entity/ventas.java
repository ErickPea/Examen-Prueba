package com.example.pruedatienda.Entity;

import jakarta.persistence.FetchType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class ventas extends ABaseEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "clientes_id", nullable = false, unique = true)
	private clientes cliente;

	@Column(name = "total", length = 50, nullable = false)
	private String total;

	@Column(name = "fecha_venta", length = 50, nullable = false)
	private String fecha_venta;

	public clientes getCliente() {
		return cliente;
	}

	public void setCliente(clientes cliente) {
		this.cliente = cliente;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

}
