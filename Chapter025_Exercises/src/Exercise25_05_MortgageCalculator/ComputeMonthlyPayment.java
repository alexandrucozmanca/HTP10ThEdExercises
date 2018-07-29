package Exercise25_05_MortgageCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ComputeMonthlyPayment 
{
	private BigDecimal monthlyPayment;
	
	public ComputeMonthlyPayment(BigDecimal creditAmount, BigDecimal interest, int loanDuration)
	{
		monthlyPayment = compute(creditAmount, interest, loanDuration);
	}
	
	private BigDecimal compute(BigDecimal creditAmount, BigDecimal interest, int loanDuration)
	{
		
		// RoadMap
		// pmt = CreditAmount * interest * (interest + 1)^loanDuration / ((interest + 1)^loanDuration) - 1)
		
		BigDecimal rate = interest.divide(new BigDecimal(100));
		BigDecimal toPow = rate.add(BigDecimal.ONE);
		BigDecimal pow = toPow.pow(loanDuration);
		
		BigDecimal numerator = creditAmount.multiply(rate).multiply(pow);
			
		BigDecimal denumerator = pow.subtract(BigDecimal.ONE);
				
		BigDecimal pmt = numerator.divide(denumerator, 2, RoundingMode.HALF_UP)
				.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP);
		
		return  pmt;
	}

	@Override
	public String toString()
	{
		return monthlyPayment.toString();
	}
	
}
