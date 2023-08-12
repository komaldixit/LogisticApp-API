package com.logistics.LogisticApp.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name="payload")
@Data

public class Load {
	@Id
	@GeneratedValue
	private int shipperId;
	private String loadingPoint ;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private int weight ;
	private String comment;
	private Date shipdate;
	
	
	


}
