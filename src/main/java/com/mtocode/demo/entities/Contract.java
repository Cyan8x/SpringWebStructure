package com.mtocode.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contract {
	private String nro_contrato;
	private Date fecha_contrato;
	private Double importe_total;
	
	private List<Quota> quotas = new ArrayList<>();
}
