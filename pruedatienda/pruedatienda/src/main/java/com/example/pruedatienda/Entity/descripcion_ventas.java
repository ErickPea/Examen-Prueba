package com.example.pruedatienda.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "descripcion_ventas")
public class descripcion_ventas extends ABaseEntity {

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ventas_id", nullable = false, unique = true)
	private ventas venta;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "productos_id", nullable = false, unique = true)
	private productos producto;

	@Column(name = "cantidad", length = 50, nullable = false)
	private Double cantidad;
	@Column(name = "precioDecimal", length = 50, nullable = false)
	private Double precioDecimal;
	@Column(name = "descuentoDecimal", length = 50, nullable = false)
	private Double descuentoDecimal;

	@Column(name = "Sub_Total", length = 50, nullable = false)
	private Double Sub_Total;

	public ventas getVenta() {
		return venta;
	}

	public void setVenta(ventas venta) {
		this.venta = venta;
	}

	public productos getProducto() {
		return producto;
	}

	public void setProducto(productos producto) {
		this.producto = producto;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

/////
	public Double getPrecioDecimal() {
		return precioDecimal;
	}

	public void setPrecioDecimal(Double precioDecimal) {
		this.precioDecimal = precioDecimal;
	}

	public Double getDescuentoDecimal() {
		return descuentoDecimal;
	}

	public void setDescuentoDecimal(Double descuentoDecimal) {
		this.descuentoDecimal = descuentoDecimal;
	}

	public Double getSub_Total() {
		return Sub_Total;
	}

	public void setSub_Total(Double sub_Total) {
		Sub_Total = sub_Total;
	}

}
