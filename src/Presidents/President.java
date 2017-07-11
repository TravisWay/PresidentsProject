package Presidents;

public class President {

	public int termNumber,startYear,endYear;
	public String firstName,middleName,lastName,party;
	
	
	public int getTermNumber() {
		return termNumber;
	}


	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}


	public int getStartYear() {
		return startYear;
	}


	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}


	public int getEndYear() {
		return endYear;
	}


	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getParty() {
		return party;
	}


	public void setParty(String party) {
		this.party = party;
	}


	public President() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("President [termNumber=");
		builder.append(termNumber);
		builder.append(", startYear=");
		builder.append(startYear);
		builder.append(", endYear=");
		builder.append(endYear);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", party=");
		builder.append(party);
		builder.append("]");
		return builder.toString();
	}

}
