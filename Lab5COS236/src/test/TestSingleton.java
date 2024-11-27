package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Member;
import lab5.PaperBook;
import lab5.Library;


class TestSingleton {
	
	@Test void TestSingleton() { 
		BorrowingService service1 = BorrowingService.getInstance(); 
		BorrowingService service2 = BorrowingService.getInstance(); 
		assertEquals(service1, service2,"Two Singleton instances detected");
	}
}
