package com.sapient.builder;

public class TestUserBuilder {

	public static void main(String[] args) {
		// Using builder to get the object in a single line of code and
		// without any inconsistent state or arguments management issues

		User user = new User.UserBuilder("Ishan", "Aggarwal").age(29)
				.address("1493, FF, Sector 15, Part 2, Gurgaon")
				.phone("9654602663").build();

		System.out.println(user);

		User user1 = new User.UserBuilder("Lokesh", "Gupta").age(30)
				.phone("1234567").address("Fake address 1234").build();

		System.out.println(user1);

		User user2 = new User.UserBuilder("Jack", "Reacher").age(40)
				.phone("5655")
				// no address
				.build();

		System.out.println(user2);

		User user3 = new User.UserBuilder("Super", "Man")
		// No age
		// No phone
		// no address
				.build();

		System.out.println(user3);

	}

}
