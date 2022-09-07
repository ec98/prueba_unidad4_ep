package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@Column(name = "deve_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deve_id_seq")
	@SequenceGenerator(name = "deve_id_seq", sequenceName = "deve_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "deve_cantidad")
	private String cantidad;

	@Column(name = "deve_precio_unitario")
	private BigDecimal precioUnitario;

	@Column(name = "deve_sub_total")
	private BigDecimal subTotal;

	@ManyToOne
	@JoinColumn(name = "deve_id_producto")
	private Producto producto;

	@ManyToOne
	@JoinColumn(name = "deve_id_venta")
	private Venta venta;

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ ", subTotal=" + subTotal + ", producto=" + producto + ", venta=" + venta + "]";
	}

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
