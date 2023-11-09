package com.inditex.api.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.api.models.PriceModel;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class QueriesControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Test
    public void testPost1() throws Exception {
		String applyDate = "2020-06-14 10:00:00";
		String productId = "35455";
		String brandId = "1";

        MvcResult mvcResult = configure(applyDate, productId, brandId);
        String jsonResponse = mvcResult.getResponse().getContentAsString();
        List<Optional<PriceModel>> priceModels = objectMapper.readValue(jsonResponse, new TypeReference<List<Optional<PriceModel>>>() {});
        
        assertTrue(priceModels.stream().anyMatch(Optional::isPresent));
		
		assertEquals(priceModels.get(0).get().getBrandId(), "1");
		assertEquals(priceModels.get(0).get().getStartDate(), "2020-06-14 00:00:00");
		assertEquals(priceModels.get(0).get().getEndDate(), "2020-12-31 23:59:59");
		assertEquals(priceModels.get(0).get().getPriceList(), "1");
		assertEquals(priceModels.get(0).get().getProductId(), "35455");
		assertEquals(priceModels.get(0).get().getPrice(), 35.5);
	}
	
	@Test
    public void testPost2() throws Exception {
		String applyDate = "2020-06-14 16:00:00";
		String productId = "35455";
		String brandId = "1";

        MvcResult mvcResult = configure(applyDate, productId, brandId);
        String jsonResponse = mvcResult.getResponse().getContentAsString();
		PriceModel[] priceModels = objectMapper.readValue(jsonResponse, PriceModel[].class);
		
		assertEquals(priceModels[0].getBrandId(), "1");
		assertEquals(priceModels[0].getStartDate(), "2020-06-14 00:00:00");
		assertEquals(priceModels[0].getEndDate(), "2020-12-31 23:59:59");
		assertEquals(priceModels[0].getPriceList(), "1");
		assertEquals(priceModels[0].getProductId(), "35455");
		assertEquals(priceModels[0].getPrice(), 35.5);
		
		assertEquals(priceModels[1].getBrandId(), "1");
		assertEquals(priceModels[1].getStartDate(), "2020-06-14 15:00:00");
		assertEquals(priceModels[1].getEndDate(), "2020-06-14 18:30:00");
		assertEquals(priceModels[1].getPriceList(), "1");
		assertEquals(priceModels[1].getProductId(), "35455");
		assertEquals(priceModels[1].getPrice(), 25.45);
	}
	
	@Test
    public void testPost3() throws Exception {
		String applyDate = "2020-06-14 21:00:00";
		String productId = "35455";
		String brandId = "1";

        MvcResult mvcResult = configure(applyDate, productId, brandId);
        String jsonResponse = mvcResult.getResponse().getContentAsString();
		PriceModel[] priceModels = objectMapper.readValue(jsonResponse, PriceModel[].class);
		
		assertEquals(priceModels[0].getBrandId(), "1");
		assertEquals(priceModels[0].getStartDate(), "2020-06-14 00:00:00");
		assertEquals(priceModels[0].getEndDate(), "2020-12-31 23:59:59");
		assertEquals(priceModels[0].getPriceList(), "1");
		assertEquals(priceModels[0].getProductId(), "35455");
		assertEquals(priceModels[0].getPrice(), 35.5);
	}
	
	@Test
    public void testPost4() throws Exception {
		String applyDate = "2020-06-15 10:00:00";
		String productId = "35455";
		String brandId = "1";

        MvcResult mvcResult = configure(applyDate, productId, brandId);
        String jsonResponse = mvcResult.getResponse().getContentAsString();
		PriceModel[] priceModels = objectMapper.readValue(jsonResponse, PriceModel[].class);
		
		assertEquals(priceModels[0].getBrandId(), "1");
		assertEquals(priceModels[0].getStartDate(), "2020-06-14 00:00:00");
		assertEquals(priceModels[0].getEndDate(), "2020-12-31 23:59:59");
		assertEquals(priceModels[0].getPriceList(), "1");
		assertEquals(priceModels[0].getProductId(), "35455");
		assertEquals(priceModels[0].getPrice(), 35.5);
		
		assertEquals(priceModels[1].getBrandId(), "1");
		assertEquals(priceModels[1].getStartDate(), "2020-06-15 00:00:00");
		assertEquals(priceModels[1].getEndDate(), "2020-06-15 11:00:00");
		assertEquals(priceModels[1].getPriceList(), "3");
		assertEquals(priceModels[1].getProductId(), "35455");
		assertEquals(priceModels[1].getPrice(), 35.5);
	}
	
	@Test
    public void testPost5() throws Exception {
		String applyDate = "2020-06-16 21:00:00";
		String productId = "35455";
		String brandId = "1";

        MvcResult mvcResult = configure(applyDate, productId, brandId);
        String jsonResponse = mvcResult.getResponse().getContentAsString();
		PriceModel[] priceModels = objectMapper.readValue(jsonResponse, PriceModel[].class);
		
		assertEquals(priceModels[0].getBrandId(), "1");
		assertEquals(priceModels[0].getStartDate(), "2020-06-14 00:00:00");
		assertEquals(priceModels[0].getEndDate(), "2020-12-31 23:59:59");
		assertEquals(priceModels[0].getPriceList(), "1");
		assertEquals(priceModels[0].getProductId(), "35455");
		assertEquals(priceModels[0].getPrice(), 35.5);
		
		assertEquals(priceModels[1].getBrandId(), "1");
		assertEquals(priceModels[1].getStartDate(), "2020-06-15 16:00:00");
		assertEquals(priceModels[1].getEndDate(), "2020-12-31 23:59:59");
		assertEquals(priceModels[1].getPriceList(), "4");
		assertEquals(priceModels[1].getProductId(), "35455");
		assertEquals(priceModels[1].getPrice(), 38.95);
	}
	
	public MvcResult configure(String applyDate, String productId, String brandId) throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/getPrice").param("applyDate", applyDate)
						.param("productId", productId).param("brandId", brandId).contentType(MediaType.APPLICATION_JSON))
		                .andExpect(status().isOk())
		                .andReturn();
		
		return mvcResult;
	
	}
}
