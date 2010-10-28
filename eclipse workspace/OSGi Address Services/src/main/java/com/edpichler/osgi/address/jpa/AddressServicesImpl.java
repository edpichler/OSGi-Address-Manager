package com.edpichler.osgi.address.jpa;

import javax.persistence.EntityManager;

import com.edpichler.osgi.address.Address;
import com.edpichler.osgi.address.City;
import com.edpichler.osgi.address.Country;
import com.edpichler.osgi.address.CountryState;
import com.edpichler.osgi.address.IAddressService;

public class AddressServicesImpl implements IAddressService {

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#persist(java.lang.Object)
	 */
	@Override
	public void persist(Object o) {
		EntityManager ent = JPAUtil.createEntityManager();
		ent.getTransaction().begin();
		ent.persist(o);
		ent.getTransaction().commit();
		ent.close();
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#remove(com.edpichler.osgi.address.Address)
	 */
	public void remove(Address o) {
		EntityManager ent = JPAUtil.createEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(o)) {
			ent.remove(o);
		} else {
			Address attached = ent.find(Address.class, o.getId());
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#remove(com.edpichler.osgi.address.Country)
	 */
	public void remove(Country o) {
		EntityManager ent = JPAUtil.createEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(o)) {
			ent.remove(o);
		} else {
			Country attached = ent.find(Country.class, o.getId());
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#remove(com.edpichler.osgi.address.CountryState)
	 */
	public void remove(CountryState o) {
		EntityManager ent = JPAUtil.createEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(o)) {
			ent.remove(o);
		} else {
			CountryState attached = ent.find(CountryState.class, o.getId());
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#remove(com.edpichler.osgi.address.City)
	 */
	public void remove(City o) {
		EntityManager ent = JPAUtil.createEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(o)) {
			ent.remove(o);
		} else {
			City attached = ent.find(City.class, o.getId());
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#merge(java.lang.Object)
	 */
	public void merge(Object o) {
		// JPA Entity Manager
		EntityManager ent = JPAUtil.createEntityManager();
		ent.getTransaction().begin();
		ent.merge(o);
		ent.getTransaction().commit();
		ent.close();

	}

	// FIND BY ID
	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#findAddressById(long)
	 */
	@SuppressWarnings("unchecked")
	public Address findAddressById(long id) {
		return (Address) findById(Address.class, id);
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#findCountryById(long)
	 */
	public Country findCountryById(long id) {
		return (Country) findById(Country.class, id);
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#findCityById(long)
	 */
	public City findCityById(long id) {
		return (City) findById(City.class, id);
	}

	/* (non-Javadoc)
	 * @see com.edpichler.osgi.address.jpa.Ra#findCountryStateById(long)
	 */
	public CountryState findCountryStateById(long id) {
		return (CountryState) findById(CountryState.class, id);
	}

	@SuppressWarnings("unchecked")
	private Object findById(Class o, long id) {
		return JPAUtil.createEntityManager().find(o, id);
	}
}
