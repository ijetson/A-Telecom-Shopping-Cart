package shoppingCart;

import java.time.LocalDate;
import java.time.Period;

public class ApplyPromo {

	public static void main(String[] args) {
		Period pd = Period.ofMonths(1);
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = d1.plusMonths(pd.getMonths());
		System.out.println(d2);
		
		
		

	}

}
