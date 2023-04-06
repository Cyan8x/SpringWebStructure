package com.mtocode.demo.common;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtocode.demo.dto.ContractResponseDTO;
import com.mtocode.demo.entities.Contract;

@Component
public class EntityDtoConverte {
	@Autowired
	private ModelMapper modelMapper;
	
	public ContractResponseDTO convertEntityToDto(Contract contract) {
		return modelMapper.map(contract, ContractResponseDTO.class);
	}
	
	public List<ContractResponseDTO> convertEntityToDto(List<Contract> contracts){
		return contracts
				.stream()
				.map(contract->convertEntityToDto(contract))
				.collect(Collectors.toList());
	}
}
