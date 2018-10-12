package com.capgemini.dal;

@SuppressWarnings("serial")
public class InvalidUserException extends Exception {
	public InvalidUserException(String s)
	{
		super(s);
	}

}
