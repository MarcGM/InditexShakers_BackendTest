package com.inditex.api.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.api.models.PriceModel;
import com.inditex.api.repositories.QueriesRepository;

@Service
public class QueriesService {
	
	@Autowired
	private QueriesRepository queryRepository;

	public List<Optional<PriceModel>> getPrice(String applyDate, String productId, String brandId){
		List<Optional<PriceModel>> priceModel = new ArrayList<>();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime applyDateDateTime = LocalDateTime.parse(applyDate, dateTimeFormatter);
		
		priceModel = queryRepository.getData(applyDateDateTime, productId, brandId);
		if(priceModel.isEmpty())
			return null;
		else
			return priceModel;
	}

}
