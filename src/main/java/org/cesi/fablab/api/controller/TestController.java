package org.cesi.fablab.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

	@RequestMapping("/")
	public String index() {
		return "Bienvenue sur l'application FabLab!";
	}

}
