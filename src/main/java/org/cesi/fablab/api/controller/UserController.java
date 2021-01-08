package org.cesi.fablab.api.controller;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cesi.fablab.api.dto.UserDTO;
import org.cesi.fablab.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = { "/core/api/v1" })
public class UserController {
	
	@Autowired(required=true)
	private UserService userService;
	
	@GetMapping("/all")
	ResponseEntity<Map<String, Object>> all() throws Exception {
		Map<String,Object> response = new HashMap<>();
		response.put("ERROR", false);
		response.put("DATA", userService.getAllUsers());
		response.put("TIMESTAMP", ZonedDateTime.now().toEpochSecond());
		response.put("MESSAGE", "message d'erreur dans le cas ou d'une exception ou erreur");
	    return ResponseEntity.ok(response);
	}
}
