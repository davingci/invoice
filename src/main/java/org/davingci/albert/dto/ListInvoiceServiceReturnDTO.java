package org.davingci.albert.dto;

import java.util.List;

import org.davingci.albert.main.Invoice;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListInvoiceServiceReturnDTO {
	
	private List<Invoice> invoiceList;

}
