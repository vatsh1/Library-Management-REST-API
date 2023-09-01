package com.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	public Admin findById(int id);

	@Query("select a from Admin a where a.email =:n")
	public Admin getAdminByEmail(@Param("n") String email);
}
