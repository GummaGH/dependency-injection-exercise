import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

/** Stock price service that gets prices from Yahoo. 
 *  @author Michael Ballantyne and Zachary Morin */
public final class YahooStockService implements StockService {
	public static final String yahooPath = "http://finance.yahoo.com/d/quotes.csv?s=%s&f=b";

	@Override
	public BigDecimal getPrice(String symbol) {
		try {
			URL url = new URL(String.format(yahooPath, symbol));
			BufferedReader in = new BufferedReader(
					new InputStreamReader(url.openStream()));

			String inputLine = in.readLine();
			in.close();
			
			return new BigDecimal(inputLine);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public boolean buy(String symbol) {
		// Stub.
		return true;
	}
}