package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import shoppingCart.Product;
import shoppingCartImpl.PromoRulesImpl;
import shoppingCartInterface.PromoRules;

public class PromoRulesTest {

	@Test
	public void testMoreForLessPromo() {
		Product p1 = new Product();
		p1.setPrice(new BigDecimal(9.90));
		PromoRules pr = new PromoRulesImpl();
		BigDecimal discountPrice = pr.moreForLessPromo(p1, 3);
		assertEquals(discountPrice, (new BigDecimal(9.90).multiply(new BigDecimal(2)).setScale(2, RoundingMode.HALF_UP)));
	}
	
	@Test
	public void testBulkDiscountPromo(){

		
		List<BigDecimal>currentPrice = new ArrayList<>();
		currentPrice.add(new BigDecimal(44.90));
		currentPrice.add(new BigDecimal(44.90));
		currentPrice.add(new BigDecimal(44.90));
		System.out.println(currentPrice.size());
		
		PromoRules pr = new PromoRulesImpl();
		pr.bulkDiscountPromo(currentPrice);
		
		BigDecimal expectedTotal  = (new BigDecimal(39.90).multiply(new BigDecimal(3))).setScale(2, RoundingMode.HALF_UP);
		System.out.println(pr.bulkDiscountPromo(currentPrice));
		System.out.println(expectedTotal);
		assertEquals(expectedTotal, (pr.bulkDiscountPromo(currentPrice)).setScale(2, RoundingMode.HALF_UP));
	}
	
	@Test
	public void testBundleFreeItemPromo(){
		Product pr1 = new Product();
		Product pr2 = new Product();
		Product pr3 = new Product();
		
		pr1.setPrice(new BigDecimal(24.90));
		pr1.setProductCode("ult_small");
		pr1.setProductName("Unlimited 1GB");
		
		pr2.setPrice(new BigDecimal(29.90));
		pr2.setProductCode("ult_medium");
		pr2.setProductName("Unlimited 2GB");
		
		pr3.setPrice(new BigDecimal(29.90));
		pr3.setProductCode("ult_medium");
		pr3.setProductName("Unlimited 2GB");
		
		List<Product>purchasedList = new ArrayList<>();
		purchasedList.add(pr1);
		purchasedList.add(pr2);
		purchasedList.add(pr3);
		
		PromoRules pr = new PromoRulesImpl();
		List<Product>testResultList = pr.bundleFreeItemPromo(purchasedList);
		assertEquals(testResultList.size(), 5);
	}
	
	
	


}
