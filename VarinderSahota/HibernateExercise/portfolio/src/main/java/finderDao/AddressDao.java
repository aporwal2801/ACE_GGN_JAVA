package finderDao;

import model.Address;

public interface AddressDao {	

	public Address getByEmailId(Address addressInfo);
	public int updateByEmailId(Address addressInfo);
}
