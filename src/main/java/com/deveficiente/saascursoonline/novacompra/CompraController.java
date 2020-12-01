package com.deveficiente.saascursoonline.novacompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping
	@Transactional
	public ResponseEntity<Void> comprar(@RequestBody @Valid CompraRequest request, UriComponentsBuilder uriComponentsBuilder) {
		Compra novaCompra = request.toModel();
		manager.persist(novaCompra);

		return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).location(novaCompra.geraURL(uriComponentsBuilder)).build();
	}
	
	
}
