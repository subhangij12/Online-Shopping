package com.example.exception;

@SuppressWarnings("serial")
public class CartException extends Exception {
//	private static final long serialVersionUID = 1L;

	public CartException(String message)
	{
		super("CartException :"+message);
	}
}
