package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ISupermercadoProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class SupermercadoProductoServiceImpl implements ISupermercadoProductoService {

	@Autowired
	private ISupermercadoProductoRepository iSupermercadoProductoRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void ingresarProductos(String nombre, Integer stock) {
		// TODO Auto-generated method stub

		Producto producto = this.iSupermercadoProductoRepository.buscarStock(stock);
		producto.setNombre(nombre);

		Integer valor = producto.getStock();

		if (valor.compareTo(stock) == 0) {
			valor = valor + stock;
		} else {
			this.iSupermercadoProductoRepository.codigoBarras(producto.getCodigoDeBarras());
			producto.setStock(stock);
		}

		this.iSupermercadoProductoRepository.ingresar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Producto consultarStock(String codigoBarras, String nombre, String categoria, Integer stock) {
		// TODO Auto-generated method stub
		// Producto producto =
		// this.iSupermercadoProductoRepository.nativeQueryCodigoBarras(codigoBarras);
		Producto producto = this.iSupermercadoProductoRepository.codigoBarras(codigoBarras);
		producto.setNombre(nombre);
		producto.setCategoria(categoria);
		producto.setStock(stock);

		return producto;
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iSupermercadoProductoRepository.ingresar(producto);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iSupermercadoProductoRepository.buscarTodos();
	}

	@Override
	public Producto codigoBarras(String codigoDeBarras) {
		// TODO Auto-generated method stub
		return this.iSupermercadoProductoRepository.codigoBarras(codigoDeBarras);
	}

}
