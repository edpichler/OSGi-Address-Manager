package com.edpichler.osgi.address.test;



import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.jpa.address.IAddress;
import com.edpichler.osgi.jpa.address.imp.Address;

public class AddressCrudTest extends OSGiTestCase {
	
	public  void testPersist(){		
		Address address = new Address();
		address.setStreet("Rua");
		address.persist();
		
		assertNotNull(address.getId());
		
		List<Address> lista = address.findAll();
		assertTrue("It was not persisted",  + lista.size() > 0);
	}
	
	//TODO PASSAR PARAMETRO PARA RECRIAR O BANCO TODA VEZ QUE INICIA TESTES.
	//TODO CRIAR BANCO COM SUFIXO TEMP PARA NAO TER RISCO DE APAGAR EM PRODUÇÃO
	//TODO CODE COVERAGE AT 80%
	
	public  void testFindAll(){		
		Address address = new Address();
		address.setStreet("Rua etc");
		address.persist();
		
		assertNotNull(address.getId());
		
		List<Address> lista = address.findAll();
		assertTrue("It was not persisted",  + lista.size() > 0);
	}
	
	public  void testRemove(){
		Address address = new Address();
		address.setStreet("Rua");
		address.persist();
		
		assertNotNull(address.getId());		
		address.remove();		
				
		assertNull("It was not removed", address.find(address.getId()));
		
	}
	
	public  void testUpdate(){
		Address address = new Address();
		address.setStreet("Rua");
		address.persist();
		
		assertNotNull(address.getId());
		
		String novaRua = "Rua das Hortênsias";
		
		List<Address> lista = address.findAll();
		assertTrue("It was not persisted",  + lista.size() > 0);
				
		address.setStreet(novaRua);
		address.merge();	
		
		IAddress adrSaved = address.find(address.getId());
		String ruaSalva = adrSaved.getStreet();
		
		assertEquals("The streets are diferent!", novaRua, ruaSalva);
			
	}
	
	public  void testFindById(){
		Address address = new Address();
		address.setStreet("Back Street");
		address.persist();
		
		assertNotNull(address.getId());		
		IAddress adrSaved = address.find(address.getId());
		assertNotNull("Can't find!", adrSaved);			
	}
}