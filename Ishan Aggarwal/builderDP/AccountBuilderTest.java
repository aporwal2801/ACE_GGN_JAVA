package com.sapient.builder;

class Account {

	// required parameters
	private final String name;
	private final String primaryPhoneNumber;
	private final String addressProofId;
	private final String accountType;

	// optional parameters
	private final String secondaryPhoneNumber;
	private final String panNumber;

	public String getName() {
		return name;
	}

	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}

	public String getAddressProofId() {
		return addressProofId;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	private Account(AccountBuilder builder) {
		this.name = builder.name;
		this.primaryPhoneNumber = builder.primaryPhoneNumber;
		this.addressProofId = builder.addressProofId;
		this.accountType = builder.accountType;
		this.secondaryPhoneNumber = builder.secondaryPhoneNumber;
		this.panNumber = builder.panNumber;
	}

	// Builder Class
	public static class AccountBuilder {

		// required parameters
		private final String name;
		private final String primaryPhoneNumber;
		private final String addressProofId;
		private final String accountType;

		// optional parameters
		private String secondaryPhoneNumber;
		private String panNumber;

		public AccountBuilder(String name, String primaryPhoneNumber,
				String addressProofId, String accountType) {
			super();
			this.name = name;
			this.primaryPhoneNumber = primaryPhoneNumber;
			this.addressProofId = addressProofId;
			this.accountType = accountType;
		}

		public AccountBuilder setSecondaryPhoneNumber(
				String secondaryPhoneNumber) {
			this.secondaryPhoneNumber = secondaryPhoneNumber;
			return this;
		}

		public AccountBuilder setPanNumber(String panNumber) {
			this.panNumber = panNumber;
			return this;
		}

		public Account build() {
			return new Account(this);
		}
	}

	@Override
	public String toString() {
		return "Account [Holder Name = " + name + ", Primary Phone Number = "
				+ primaryPhoneNumber + ",\nAddressProofId = " + addressProofId
				+ ", AccountType = " + accountType + ",\nPan Number = "
				+ panNumber + ", Secondary Phone Number = "
				+ secondaryPhoneNumber + "]";
	}

}

public class AccountBuilderTest {
	public static void main(String[] args) {
		Account account = new Account.AccountBuilder("Test User", "9999999999",
				"12ER323", "Saving").setPanNumber("NU213NJH3")
				.setSecondaryPhoneNumber("9545432445").build();
		System.out.println(account);

		Account account1 = new Account.AccountBuilder("Ishan Aggarwal",
				"9654602663", "17-B, YamunaNagar", "Saving")
				.setPanNumber("ASBBPPAA").setSecondaryPhoneNumber("9545432445")
				.build();
		System.out.println(account1);

		Account account2 = new Account.AccountBuilder("Vaibhav Jain",
				"9988776655", "19-C, Delhi", "Saving").setPanNumber(
				"SSYYTTEERR").build();
		System.out.println(account2);

	}
}