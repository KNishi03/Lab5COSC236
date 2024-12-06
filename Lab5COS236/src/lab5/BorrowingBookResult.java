package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class BorrowingBookResult{
	
	private boolean isSuccess; 
	private String borrowingMessage;
	
	// Constructor
	public BorrowingBookResult(boolean isSuccess, String borrowingMessage) { 
		this.isSuccess = isSuccess; 
		this.borrowingMessage = borrowingMessage;
	}
	
	// Getters and setters
	// TODO implement getters and setters 
	
	public Boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getBorrowingMessage() {
		return borrowingMessage;
	}

	public void setBorrowingMessage(String borrowingMessage) {
		this.borrowingMessage = borrowingMessage;
	}

}
