package com.mtocode.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtocode.demo.common.EntityDtoConverte;
import com.mtocode.demo.dto.ContractRequestDTO;
import com.mtocode.demo.dto.ContractResponseDTO;
import com.mtocode.demo.entities.Contract;
import com.mtocode.demo.services.ContractService;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("/contracts")
public class ContractController {
	
	private ContractService contractService;
	private EntityDtoConverte entityDtoConverter;
	
	public ContractController(ContractService contractService,EntityDtoConverte entityDtoConverter) {
		this.contractService = contractService;
		this.entityDtoConverter = entityDtoConverter;
	}
	
	@GetMapping()
	public ResponseEntity<ContractResponseDTO> calculoMontoCuotas(@RequestBody ContractRequestDTO contractRequest){
		Contract contrato = contractService.proceedService(contractRequest);
		
		return new ResponseEntity<>(entityDtoConverter.convertEntityToDto(contrato),HttpStatus.OK);
	}
}
