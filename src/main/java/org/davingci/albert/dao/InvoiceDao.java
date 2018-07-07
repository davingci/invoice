package org.davingci.albert.dao;

import java.util.List;

import org.davingci.albert.main.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDao extends JpaRepository<Invoice, Integer> {
	
	Invoice getById(Integer id);
	
	List<Invoice> getByRegisterUsername(String registerUsername);
	List<Invoice> findAll(); 

}
