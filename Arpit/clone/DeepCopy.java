package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopy {

	static class Employee implements Serializable {
		String firstName;
		String lastName;
		Address address;
		
		public Employee(){
			
		}

		public Employee(String firstName, String lastName, Address address) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("First Name: " + firstName + "\n");
			sb.append("Last Name: " + lastName + "\n");
			sb.append("Address: " + address + "\n");
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("Al", "B1", new Address("A1L1", "B1L2"));

		Employee e2 = (Employee) deepCloneUsingSerialization(e1);
		
		Employee e3 =  new Employee();
		DeepCopyCloner.copyFieldByField(e1, e3);

		e2.firstName = "A2";
		e2.lastName = "B2";
		e2.address = new Address("A2L1", "B2L2");
		
		e3.firstName = "A3";
		e3.lastName = "B3";
		e3.address = new Address("A3L1", "B3L2");

		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
	}

	public static Object deepCloneUsingSerialization(Object object) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);

			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static class Address implements Serializable{
		String line1;
		String line2;
		
		public Address(String l1, String l2){
			line1 = l1;
			line2 = l2;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Line1: " + line1 + "\n");
			sb.append("Line2: " + line2 + "\n");
			return sb.toString();
		}
	}
}
