package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@Column(name = "vent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent_id_seq")
	@SequenceGenerator(name = "vent_id_seq", sequenceName = "vent_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "vent_numero")
	private String numero;

	@Column(name = "vent_nombre")
	private String nombre;

	@Column(name = "vent_fecha")
	private LocalDateTime fecha;

	@Column(name = "vent_cedula_cliente")
	private String cedulaCliente;

	@Column(name = "vent_total_venta")
	private BigDecimal totalVenta;

	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Producto> productos;

	@Override
	public String toString() {
		return "Venta [id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", fecha=" + fecha + ", cedulaCliente="
				+ cedulaCliente + ", totalVenta=" + totalVenta + "]";
	}

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	

}
