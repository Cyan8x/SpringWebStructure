package com.mtocode.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mtocode.demo.entities.Quota;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Class represent the contract request")
public class ContractResponseDTO {
	@ApiModelProperty(notes = "Numero de identificacion de Contrato", required = true)
	private String nro_contrato;
	
	@ApiModelProperty(notes = "Fecha de contrato", required = true)
	private Date fecha_contrato;

	@ApiModelProperty(notes = "Importe total del contrato", required = true)
	private Double importe_total;
	
	@ApiModelProperty(notes = "Lista de cuotas")
	private List<Quota> quotas = new ArrayList<>();
	
}
