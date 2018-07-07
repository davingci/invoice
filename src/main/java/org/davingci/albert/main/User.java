package org.davingci.albert.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.davingci.albert.main.Invoice.InvoiceBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="albert_user")
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    private String username;
    
    private String password;
    


}
