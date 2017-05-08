package shoppingCartInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import shoppingCart.Product;

public interface PromoRules {
	
	public BigDecimal moreForLessPromo(Product product, int qty);
	public BigDecimal bulkDiscountPromo(List<BigDecimal> currentPrice);
	public List<Product> bundleFreeItemPromo(List<Product>purchasedList);
	public BigDecimal usePromoCode(List<BigDecimal> originalPurchasedPriceList, String promoCode, BigDecimal discount);
	public boolean promoCodeVerified(String promoCode);
	public boolean isPurchasedDateOnFirstMonth(LocalDate purchasedDate, LocalDate joinDate);

}
