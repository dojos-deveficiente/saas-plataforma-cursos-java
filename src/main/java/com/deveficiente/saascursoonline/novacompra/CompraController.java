package com.deveficiente.saascursoonline.novacompra;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping
	@Transactional
	public void comprar(@RequestBody @Valid CompraRequest request) {
		Compra novaCompra = request.toModel();
		manager.persist(novaCompra);
	}
	
	
}
