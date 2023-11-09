package com.inditex.api.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.inditex.api.models.PriceModel;


public interface QueriesRepository extends CrudRepository<PriceModel, Long>{

	@Transactional
	@Query(value = "SELECT ID, PRODUCT_ID, BRAND_ID, PRICE_LIST, START_DATE, END_DATE, PRICE, CURR, PRIORITY FROM ELECTRONIC_COMERCIAL WHERE PRODUCT_ID = :productId AND BRAND_ID = :brandId AND :applyDateDateTime BETWEEN START_DATE AND END_DATE", nativeQuery = true)
	public List<Optional<PriceModel>> getData(@RequestParam LocalDateTime applyDateDateTime, @RequestParam  String productId, @RequestParam  String brandId);

}
