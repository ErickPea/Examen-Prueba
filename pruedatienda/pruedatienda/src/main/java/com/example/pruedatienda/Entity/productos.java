package com.example.pruedatienda.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class productos extends ABaseEntity {

	@Column(name = "nombre_producto", length = 50, nullable = false)
	private String nombre_producto;

	@Column(name = "descripcion", length = 50, nullable = false)
	private String descripcion;

	@Column(name = "cantidad", length = 50, nullable = false)
	private String cantidad;

	@Column(name = "precioDecimal", length = 50, nullable = false)
	private Double precioDecimal;

	@Column(name = "porcentaje_iva", length = 50, nullable = false)
	private Double porcentaje_iva;

	@Column(name = "porcentajeDescuento", length = 50, nullable = false)
	private Double porcentajeDescuento;

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioDecimal() {
		return precioDecimal;
	}

	public void setPrecioDecimal(Double precioDecimal) {
		this.precioDecimal = precioDecimal;
	}

	public Double getPorcentaje_iva() {
		return porcentaje_iva;
	}

	public void setPorcentaje_iva(Double porcentaje_iva) {
		this.porcentaje_iva = porcentaje_iva;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

}
