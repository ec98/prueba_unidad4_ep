package com.uce.edu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.ISupermercadoProductoService;
import com.uce.edu.demo.service.ISupermercadoVentaService;

@Controller
@RequestMapping("/supermercado")
public class SuperMercadoController {

	@Autowired
	private ISupermercadoProductoService iSupermercadoProductoService;

	@Autowired
	private ISupermercadoVentaService iSupermercadoVentaService;

	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) { // nombre de la vista (String)
		List<Producto> lista = this.iSupermercadoProductoService.buscarTodos();
		modelo.addAttribute("supermercado", lista);
		return "vistaListaProductos";
	}

	@GetMapping("/buscarStock/{codigo}")
	public String buscarStock(@PathVariable("codigo") String codigo, Model modelo) { // nombre de la vista (String)
		Producto p = this.iSupermercadoProductoService.codigoBarras(codigo);
		modelo.addAttribute("producto", p);
		return "vistaStockProducto";
	}

	@PostMapping("/realizarVenta/{nombre}&{cedula}&{numero}")
	public String realizarVenta(@PathVariable("nombre") Producto nombre, @PathVariable("cedula") String cedula,
			@PathVariable("numero") String numero, Model modelo) {
		List<Producto> milist = new ArrayList<Producto>();
		milist.add(nombre);
		this.iSupermercadoVentaService.realizarVenta(milist, cedula, numero);
		modelo.addAttribute("producto", milist);
		return "vistaVenta"; // modelo del cuadro
	}

	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		this.iSupermercadoProductoService.insertar(producto);
		return "redirect:/supermercado/buscar";
	}

	@GetMapping("/nuevoProducto")
	public String paginaNuevoProducto(Producto producto) {
		return "vistaNuevaProducto";
	}
}
