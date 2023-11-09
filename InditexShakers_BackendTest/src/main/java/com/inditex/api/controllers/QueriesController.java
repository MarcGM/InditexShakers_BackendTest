package com.inditex.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.api.models.PriceModel;
import com.inditex.api.services.QueriesService;

@RestController
public class QueriesController {
	
	private final QueriesService queriesService;
	
	public QueriesController(QueriesService queriesService) {
		this.queriesService = queriesService;
	}

	@PostMapping({"/getPrice"})
	public List<Optional<PriceModel>> getPrice(@RequestParam("applyDate") String applyDate, @RequestParam("productId") String productId,
			@RequestParam("brandId") String brandId) {
		return queriesService.getPrice(applyDate, productId, brandId);
	}
}
