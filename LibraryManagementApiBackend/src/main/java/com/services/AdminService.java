package com.services;

import java.util.List;

import com.dao.AdminRepository;
import com.model.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	// get all admins
	public List<Admin> getAdmins() {
		List<Admin> list = (List<Admin>) this.adminRepository.findAll();
		return list;
	}

	// get admin by id
	public Admin getAdminById(int id) {
		Admin admin = this.adminRepository.findById(id);
		return admin;
	}

	// get admin by email
	public Admin getAdminByEmail(String email) {
		Admin admin = this.adminRepository.getAdminByEmail(email);
		return admin;
	}

	// register admin
	public Admin registerAdmin(Admin admin) {
		Admin result = this.adminRepository.save(admin);
		return result;
	}
}
