package tests;

//import static org.junit.Assert.*;
//import junit.framework.Assert;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import de.dennis.easymock.Portfolio;
import de.dennis.easymock.Stock;
import de.dennis.easymock.StockMarket;

public class PortolioTest {

	private Portfolio portfolio;
	private StockMarket marketMock;

	@Before
	public void setUp() {
		portfolio  = new Portfolio();
		portfolio.setName("Sindys portfolio");
		marketMock = EasyMock.createMock(StockMarket.class);
		portfolio.setStockMarket(marketMock);

	}

	@Test
	public void testGetTotalValue() {
		/* = Setup our mock object with the expected values */
		EasyMock.expect(marketMock.getPrice("Ebay")).andReturn(42.00);
		EasyMock.replay(marketMock);

		// Now start testing our Portfolio
		Stock ebayStock = new Stock("Ebay", 5);
		portfolio.addStock(ebayStock);
		assertEquals(new Double(210.00), portfolio.getTotalValue());
    
    
	}
}
