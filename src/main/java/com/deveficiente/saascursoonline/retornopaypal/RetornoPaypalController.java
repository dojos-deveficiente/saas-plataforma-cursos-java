package com.deveficiente.saascursoonline.retornopaypal;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetornoPaypalController {

    @PostMapping(path = "/retorno/paypal")
    public ResponseEntity<?> execute(@RequestBody @Valid RetornoPaypalRequest request){
        return ResponseEntity.ok(null);
    }

}
