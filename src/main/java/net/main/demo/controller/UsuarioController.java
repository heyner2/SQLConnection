package net.main.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import net.main.demo.DTOs.UsuarioRegistrationDTO;
import net.main.demo.services.repositories.UsuarioService;

@Controller
@RequestMapping("/Registration")
public class UsuarioController {

private UsuarioService service;

public UsuarioController(UsuarioService service) {
	this.service=service;
}

@ModelAttribute("usuario")
public UsuarioRegistrationDTO RegistroUsuarioDTO() {
	return new UsuarioRegistrationDTO();
}


@PostMapping
public String usuario(@ModelAttribute("usuario") UsuarioRegistrationDTO usuarioDto) {
	if(service.save(usuarioDto)) {
		return "redirect:/Registration?success";
	}else {
		return "redirect:/Registration?failed";
	}
	
}

@GetMapping
public String registro(Model model) {
	model.addAttribute("usuario", new UsuarioRegistrationDTO());
	return "Registro";
}


}
