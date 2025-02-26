package case1;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

public class AccountTest {
	
	@Test
	public void testCreateAccount() {
		Account account = new Account();
		assertEquals(0, account.getBalance(), 0);
		assertEquals(null, account.getLastTransactionDate());
	}
	
	@Test
	public void testDebit() {
		Account account = new Account();
		account.debit(1000);
		assertEquals(1000, account.getBalance(), 0.001);
		//assertDateEquals(new Date(), account.getLastTransactionDate());
	}

	@Test
	public void testDebitTwice() {
		Account account = new Account();
		account.debit(310.15);
		account.debit(532.30);
		assertEquals(842.45, account.getBalance(), 0.001);
		assertDateEquals(new Date(), account.getLastTransactionDate());
	}

	@Test
	public void testCredit() {
		Account account = new Account();
		account.credit(1000);
		assertEquals(-1000, account.getBalance(), 0.001);
		assertDateEquals(new Date(), account.getLastTransactionDate());
	}
	
	@Test
	public void testSeveralMovements() {
		Account account = new Account();
		account.debit(2000);
		account.credit(45.10);
		account.credit(545.15);
		assertEquals(1409.75, account.getBalance(), 0.001);
		assertDateEquals(new Date(), account.getLastTransactionDate());
	}	

	private void assertDateEquals(Date expected, Date result) {
		long gap = expected.getTime() - result.getTime();
		assertTrue(Math.abs(gap) < 5);		
	}

}
