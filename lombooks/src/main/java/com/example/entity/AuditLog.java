package com.example.entity;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuditLog {
	@Id
	@GeneratedValue
	@Column
	private int id;
	
	@Column(columnDefinition = "date default sysdate")
	private Date createDate;
	
	private String description;

}
