import java.util.Arrays;

public class Movie {
	private String Name;
	private String Genre;
	private String Duration;
	private Director Director;
	private int MovieID;
	private Star[] StarIDs;
	private int Count;
	private int[] StarIDWriter;
	public int Revenue;

	public Movie(String name, String genre, String duration, Director director, int movieID, int numberofstars,
			int[] stars) {

		Name = name;
		Genre = genre;
		Duration = duration;
		Director = director;
		MovieID = movieID;
		StarIDs = new Star[numberofstars];
		Count = 0;
		StarIDWriter = stars;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public Director getDirector() {
		return Director;
	}

	public void setDirectorID(Director director) {
		Director = director;
	}

	public int getMovieID() {
		return MovieID;
	}

	public void setMovieID(int movieID) {
		MovieID = movieID;
	}

	public Star[] getStarIDs() {
		return StarIDs;
	}

	public void setStarIDs(Star[] starIDs) {
		StarIDs = starIDs;
	}

	public int getRevenue() {
		return Revenue;
	}

	public void addStar(Star s) {
		StarIDs[Count] = s;
		Count++;
	}

	public String Display() {

		return "Movie [Name=" + Name + ", Genre=" + Genre + ", Duration=" + Duration + ", DirectorID="
				+ (Director.getDirectorID() + 1) + ", MovieID=" + (MovieID + 1) + ", StarIDs="
				+ Arrays.toString(StarIDWriter);
	}
}
