package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface ISupermercadoProductoService {
	
	public void insertar(Producto producto);

	public void ingresarProductos(String nombre, Integer stock);

	public Producto consultarStock(String codigoBarras, String nombre, String categoria, Integer stock);
	
	public List<Producto> buscarTodos();
	
	public Producto codigoBarras(String codigoDeBarras);

}
