
public class Seat {
	private boolean Status;
	private String Type;

	public Seat(boolean status, String type) {
		Status = status;
		Type = type;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String Display() {
		if (Status == true)
			return "O";
		else
			return "X";
	}

}
