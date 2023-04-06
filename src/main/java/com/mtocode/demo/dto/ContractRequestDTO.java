package com.mtocode.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Class represent the contract request")
public class ContractRequestDTO {
	@ApiModelProperty(notes = "Numero de identificacion de Contrato", required = true)
	private String nro_contrato;
	
	@ApiModelProperty(notes = "Fecha de contrato formato (dd/mm/yyyy)", required = true)
	private String fecha_contrato;

	@ApiModelProperty(notes = "Importe total del contrato", required = true)
	private Double importe_total;
	
	@ApiModelProperty(notes = "Cantidad de meses que se cotizará el contrato", required = true)
	private Integer cant_meses;
}
