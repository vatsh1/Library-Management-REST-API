package com.controller;

import java.util.Optional;

import com.model.Admin;
import com.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	// Register admin handler
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		Admin a = null;
		try {
			a = this.adminService.registerAdmin(admin);
			return ResponseEntity.of(Optional.of(a));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// get admin by id
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getBook(@PathVariable("id") int id) {

		Admin admin = this.adminService.getAdminById(id);
		if (admin == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(admin));
	}

	// get admin by email and password
	@GetMapping("/login/{email}")
	public ResponseEntity<Admin> loginAdmin(@PathVariable("email") String email) {
		Admin a = null;
		try {
			a = this.adminService.getAdminByEmail(email);
			return ResponseEntity.of(Optional.of(a));
		} catch (Exception ee) {
			ee.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
