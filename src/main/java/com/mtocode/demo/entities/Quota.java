package com.mtocode.demo.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Quota {
	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date fecha_cuota;
	private Double monto_cuota;
	
	public static SimpleDateFormat getFormatDate() {
		return formatDate;
	}

	public static void setFormatDate(SimpleDateFormat formatDate) {
		Quota.formatDate = formatDate;
	}
	
}
