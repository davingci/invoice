package org.davingci.albert.service;

import java.util.List;

import org.davingci.albert.main.Invoice;

public interface InvoiceService {
	public void save(Invoice invoice);
	public List<Invoice> list();
	public List<Invoice> getByUsername(String username);

}
