
public class Director {
	private String Name;
	private String BirthDay;
	private String BirthPlace;
	private int DirectorID;

	public Director(String name, String birthDay, String birthPlace, int directorID) {
		Name = name;
		BirthDay = birthDay;
		BirthPlace = birthPlace;
		DirectorID = directorID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public String getBirthPlace() {
		return BirthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		BirthPlace = birthPlace;
	}

	public int getDirectorID() {
		return DirectorID;
	}

	public void setDirectorID(int directorID) {
		DirectorID = directorID;
	}

	public String Display() {
		return "Director [Name=" + Name + ", BirthDay=" + BirthDay + ", BirthPlace=" + BirthPlace + ", DirectorID="
				+ (DirectorID + 1) + "]";
	}

}
