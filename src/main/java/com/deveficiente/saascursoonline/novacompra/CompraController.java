package com.deveficiente.saascursoonline.novacompra;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@PostMapping
	public void comprar(CompraRequest compra) {
		
	}
}
