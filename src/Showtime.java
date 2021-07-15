import java.util.Arrays;
import java.util.Random;

public class Showtime {
	private double Price;
	private Seat[][] Seats;

	public Showtime(double price) {
		Price = price;
		Seats = new Seat[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Seats[i][j] = new Seat(true, "Regular");
				Seats[i][j].setStatus(true);
				Seats[i][j].setType("Regular");
			}
		}
	}

	public Showtime() {
		Price = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Seats[i][j] = new Seat(true, "Regular");
				Seats[i][j].setStatus(true);
				Seats[i][j].setType("Regular");
			}
		}
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void getSeats() {
		for (int i = 0; i < Seats[0].length; i++) {
			for (int j = 0; j < Seats[1].length; j++) {
				System.out.print(Seats[i][j].Display());
			}
			System.out.println(" ");
		}
	}

	public void getSeats2(int cursorx, int cursory) {

		for (int i = 0; i < Seats[0].length; i++) {
			for (int j = 0; j < Seats[1].length; j++) {
				System.out.print(Seats[i][j].Display());
			}
			AnaClass.cn.getTextWindow().setCursorPosition(cursorx, cursory + i + 1);

		}

	}

	public double getIncome() {
		double toplam = 0;
		for (int i = 0; i < Seats[0].length; i++) {
			for (int j = 0; j < Seats[1].length; j++) {
				if (!Seats[i][j].getStatus() && Seats[i][j].getType().equals("student")) {
					toplam = toplam + (Price / 2);
				} else if (!Seats[i][j].getStatus() && Seats[i][j].getType().equals("regular")) {
					toplam = toplam + Price;
				}
			}
		}
		return toplam;
	}

	public boolean getSeatStatus(int m, int n) {
		return Seats[m][n - 1].getStatus();
	}

	public boolean getSeatStatus2(int m, int n) {
		return Seats[m][n].getStatus();
	}

	public void setSeats(int m, int n, boolean status, String type) {
		Seats[m][n - 1].setStatus(status);
		Seats[m][n - 1].setType(type);
	}

	public int getHowMany() {
		int filled = 0;
		for (int i = 0; i < Seats[0].length; i++) {
			for (int j = 0; j < Seats[1].length; j++) {
				if (Seats[i][j].getStatus() == false) {
					filled++;
				} else
					continue;
			}

		}
		return filled;
	}

	public void FindPlaceMorning(int f, int g, int saloonnumber, String type) {
		while (Seats[f][g - 1].getStatus() == false) {
			Random Row = new Random();
			f = Row.nextInt(5);
			Random Column = new Random();
			g = Column.nextInt(5) + 1;
		}
		AnaClass.Saloons[saloonnumber - 1].getMorning().setSeats(f, g, false, type);
	}

	public void FindPlaceNoon(int f, int g, int saloonnumber, String type) {
		while (Seats[f][g].getStatus() == false) {
			Random Row = new Random();
			f = Row.nextInt(5);
			Random Column = new Random();
			g = Column.nextInt(5);
		}
		AnaClass.Saloons[saloonnumber - 1].getNoon().setSeats(f, g, false, type);
	}

	public void FindPlaceEvening(int f, int g, int saloonnumber, String type) {
		while (Seats[f][g].getStatus() == false) {
			Random Row = new Random();
			f = Row.nextInt(5);
			Random Column = new Random();
			g = Column.nextInt(5);
		}
		AnaClass.Saloons[saloonnumber - 1].getEvening().setSeats(f, g, false, type);
	}

	public void Initialize() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Seats[i][j] = new Seat(true, "Regular");
				Seats[i][j].setStatus(true);
				Seats[i][j].setType("Regular");
			}
		}
	}

	public String Display() {
		return "Showtime [Price=" + Price + ", Salon=" + Arrays.toString(Seats) + "]";
	}

}
