package com.deveficiente.saascursoonline.novacompra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping
	@Transactional
	public ResponseEntity<?> comprar(@RequestBody @Valid CompraRequest request) {
		Compra novaCompra = request.toModel();
		manager.persist(novaCompra);

		URI uri = URI.create("http://gateway.paypal.com/payment?customId="+novaCompra.getCodigo()+"&payment="+novaCompra.getValor());
		return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).location(uri).build();
	}
	
	
}
