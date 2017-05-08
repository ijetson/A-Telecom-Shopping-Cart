package shoppingCartImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import shoppingCart.Product;
import shoppingCartInterface.PromoRules;

public class PromoRulesImpl implements PromoRules {

	Double promoPrice = 39.90;
	private BigDecimal discountPay;

	@Override
	public BigDecimal moreForLessPromo(Product product, int qty) {

		if (qty == 3) {
			discountPay = product.getPrice().multiply(new BigDecimal(2)).setScale(2, RoundingMode.HALF_UP);
		}

		return discountPay;
	}

	@Override
	public BigDecimal bulkDiscountPromo(List<BigDecimal> currentPrice) {
		BigDecimal totalDiscountPrice = new BigDecimal(0);
		List<BigDecimal> discountPrice = new ArrayList<>();

		if ((currentPrice.size() >= 3)) {
			for (int i = 0; i < currentPrice.size(); i++) {
				discountPrice.add(new BigDecimal(promoPrice));
			}

			for (int i = 0; i < discountPrice.size(); i++) {
				totalDiscountPrice = (totalDiscountPrice.add(discountPrice.get(i))).setScale(2, RoundingMode.HALF_UP);
			}

		}

		return totalDiscountPrice;

	}

	@Override
	public List<Product> bundleFreeItemPromo(List<Product> purchasedList) {
		Product pr2Gb = new Product();
		pr2Gb.setPrice(new BigDecimal(24.90));
		pr2Gb.setProductCode("ult_small");
		pr2Gb.setProductName("1 GB Data Pack");

		ListIterator<Product> prItr = purchasedList.listIterator();
		while (prItr.hasNext()) {
			if (prItr.next().getProductCode().equals("ult_medium")) {
				prItr.add(pr2Gb);
			}
		}

		return purchasedList;
	}

	@Override
	public BigDecimal usePromoCode(List<BigDecimal> originalPurchasedPriceList, String promoCode, BigDecimal discount) {
		BigDecimal discountedPrice = BigDecimal.ZERO;
		// create a stream add all the purchase then get the discounted price
		if (promoCodeVerified(promoCode)) {
			BigDecimal purchasedListTotal = originalPurchasedPriceList.stream().reduce(BigDecimal.ZERO,
					BigDecimal::add);
			discountedPrice = purchasedListTotal.subtract(purchasedListTotal.multiply(discount));
			return discountedPrice;
		}
		return null;
	}

	@Override
	public boolean promoCodeVerified(String promoCode) {
		if (promoCode.equals("I<3AMAYSIM")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isPurchasedDateOnFirstMonth(LocalDate purchasedDate, LocalDate joinDate) {
		Period period = Period.ofMonths(1);
		LocalDate firstMonthEndDate = joinDate.plusDays(period.getMonths());
		return !(purchasedDate.isBefore(joinDate) || purchasedDate.isAfter(firstMonthEndDate));
	}

}
