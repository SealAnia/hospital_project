package com.example.hospital.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospital.model.entity.Role;
import com.example.hospital.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> getUserByName(String name);
	List<User> getUserBySurname(String surname);
	@Query(value = "SELECT u FROM User u WHERE u.id LIKE '%' || :keyword || '%'"
			+ "OR u.name LIKE '%' || :keyword || '%'"
			+ "OR u.surname LIKE '%' || :keyword || '%'"
			+ "OR u.dept.name LIKE '%' || :keyword || '%'"
			+ "OR u.role.name LIKE '%' || :keyword || '%'")
	List<User> search(@Param("keyword") String keyword);
	
	List<User> getUserByRole(Role role);
	
	//NEW
	User findByUsername(String username);

}
