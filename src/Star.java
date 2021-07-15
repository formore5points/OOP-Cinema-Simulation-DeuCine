
public class Star {
	private String Name;
	private String BirthDay;
	private String BirthPlace;
	private int StarID;

	public Star(String name, String birthDay, String birthPlace, int starID) {
		Name = name;
		BirthDay = birthDay;
		BirthPlace = birthPlace;
		StarID = starID;
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

	public int getStarID() {
		return StarID;
	}

	public void setStarID(int starID) {
		StarID = starID;
	}

	public String Display() {
		return "Star [Name=" + Name + ", BirthDay=" + BirthDay + ", BirthPlace=" + BirthPlace + ", StarID="
				+ (StarID + 1) + "]";
	}

}
