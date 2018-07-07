package org.davingci.albert.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="albert_invoice")
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    private String code;
    
    @Column(name="register_username")
    private String registerUsername;
    

    private String registerTime;
    
   

}
