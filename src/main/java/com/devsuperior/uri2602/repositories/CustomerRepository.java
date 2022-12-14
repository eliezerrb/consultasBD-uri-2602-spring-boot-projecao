package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.dto.CostumerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	// Consulta nativa SQL
	@Query(nativeQuery = true, value = "SELECT name "
			+ "FROM customers "
			+ "WHERE UPPER(state)= UPPER(:state)")
	List<CustomerMinProjection> serch1(String state);
	
	// Consulta equivalente na JPQL
	@Query("SELECT new com.devsuperior.uri2602.dto.CostumerMinDTO(obj.name) "
			+ "FROM Customer obj "
			+ "WHERE UPPER(obj.state)= UPPER(:state)")
	List<CostumerMinDTO> serch2(String state);
}
