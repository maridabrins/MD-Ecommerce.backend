package com.revisao.ecommerce.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.UsuarioDTO;
import com.revisao.ecommerce.services.UsuarioService;




@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
	
		@Autowired
		UsuarioService usuarioService; //instanciando service para acessarmos o metodo
		
		@PostMapping(value = "/cadastrar")
		public ResponseEntity <UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO dto){ //salvando usuarios
			dto = usuarioService.salvarUsuario(dto);
			return ResponseEntity.ok(dto);
		}
		
		@PostMapping (value = "/login")
		public ResponseEntity<?> logar(@RequestBody UsuarioDTO dto){//metodo para mostrar se o usuario existe ou não
			
			boolean teste = usuarioService.login(dto);
			
			if(teste) {
				//se a resposta do matches(service) for true
				return ResponseEntity.ok("Sucesso!");
			}
			//se a resposta do matches for false
			return ResponseEntity.status(401).body("Senha ou login incorretos!");
		}
	
	
}
