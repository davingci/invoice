package org.davingci.albert.service.impl;

import java.util.List;

import org.davingci.albert.dao.InvoiceDao;
import org.davingci.albert.main.Invoice;
import org.davingci.albert.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired 
	InvoiceDao invoiceDao;
	
	public void save(Invoice invoice) {
		invoiceDao.save(invoice);
	}
	@Override
	public List<Invoice> list(){
		return invoiceDao.findAll();
	}
	@Override
	public List<Invoice> getByUsername(String username){
		return invoiceDao.getByRegisterUsername(username);
	}

}
