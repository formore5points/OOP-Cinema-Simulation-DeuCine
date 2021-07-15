
public class Saloon {
	private int SaloonID;
	private Movie MovieID;
	private Showtime Morning;
	private Showtime Noon;
	private Showtime Evening;

	public Saloon(int saloonID, Movie movieID, Showtime morning, Showtime noon, Showtime evening) {
		SaloonID = saloonID;
		MovieID = movieID;
		Morning = morning;
		Noon = noon;
		Evening = evening;
	}

	public Saloon(int saloonID, Movie movieID) {
		SaloonID = saloonID;
		MovieID = movieID;
		Morning = null;
		Noon = null;
		Evening = null;
	}

	public Saloon() {
		SaloonID = 0;
		MovieID = null;
		Morning = null;
		Noon = null;
		Evening = null;
	}

	public int getSaloonID() {
		return SaloonID;
	}

	public void setSaloonID(int saloonID) {
		SaloonID = saloonID;
	}

	public Movie getMovieID() {
		return MovieID;
	}

	public void setMovieID(Movie movieID) {
		MovieID = movieID;
	}

	public Showtime getMorning() {
		return Morning;
	}

	public void setMorning(Showtime morning) {
		Morning = morning;
	}

	public Showtime getNoon() {
		return Noon;
	}

	public void setNoon(Showtime noon) {
		Noon = noon;
	}

	public Showtime getEvening() {
		return Evening;
	}

	public void setEvening(Showtime evening) {
		Evening = evening;
	}

	public String Display() {

		return "Saloon [SaloonID=" + SaloonID + ", MovieID=" + (MovieID.getMovieID() + 1) + ", Morning="
				+ Morning.getPrice() + ", Noon=" + Noon.getPrice() + ", Evening=" + Evening.getPrice() + "]";

	}

}
