package com.souza.gestaocliente;

import javax.persistence.Persistence;

public class TesteDb {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("crud-asbpm");
	}
}
