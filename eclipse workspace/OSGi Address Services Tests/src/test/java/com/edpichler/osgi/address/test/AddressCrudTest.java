package com.edpichler.osgi.address.test;
import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.address.Address;
import com.edpichler.osgi.address.AddressServiceFactory;
import com.edpichler.osgi.address.IAddressService;

public class AddressCrudTest extends OSGiTestCase {
	
	public  void testPersist(){		
		Address address = new Address();
		address.setStreet("Rua");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);
		
		
		assertNotNull(address.getId());
		
		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted",  + lista.size() > 0);
	}
	
	//TODO PASSAR PARAMETRO PARA RECRIAR O BANCO TODA VEZ QUE INICIA TESTES.
	//TODO CRIAR BANCO COM SUFIXO TEMP PARA NAO TER RISCO DE APAGAR EM PRODU��O
	//TODO CODE COVERAGE AT 80%
	
	public  void testFindAll(){		
		Address address = new Address();
		address.setStreet("Rua etc");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);
		
		
		
		assertNotNull(address.getId());
		
		List<Address> lista =  service.findAllAddresses();
		assertTrue("It was not persisted",  + lista.size() > 0);
	}
	
	public  void testRemove(){
		Address address = new Address();
		address.setStreet("Rua");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);
		
		
		assertNotNull(address.getId());		
		service.remove(address);		
				
		assertNull("It was not removed", service.findAddressById(address.getId()));
		
	}
	
	public  void testUpdate(){
		Address address = new Address();
		address.setStreet("Rua");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);
		
		
		assertNotNull(address.getId());
		
		String novaRua = "Rua das Hort�nsias";
		
		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted",  + lista.size() > 0);
				
		address.setStreet(novaRua);
		service.merge(address);	
		
		Address adrSaved = service.findAddressById(address.getId());
		String ruaSalva = adrSaved.getStreet();
		
		assertEquals("The streets are diferent!", novaRua, ruaSalva);
			
	}
	
	public  void testFindById(){
		Address address = new Address();
		address.setStreet("Back Street");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);
		
		
		assertNotNull(address.getId());		
		Address adrSaved = service.findAddressById(address.getId());
		assertNotNull("Can't find!", adrSaved);			
	}
}