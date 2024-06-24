package com.codzer.teste.services.exceptions;

public class RessourceNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public RessourceNotFoundException( Object id )
	{
		super("Resource not fond. Id: "+ id );
	}
}
