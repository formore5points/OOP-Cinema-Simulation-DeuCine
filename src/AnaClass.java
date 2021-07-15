import enigma.console.Console;
import enigma.core.Enigma;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnaClass {
	public static enigma.console.Console cn = Enigma.getConsole("DeuCine", 185, 100, 15, 0);

	public static Star Stars[] = new Star[50];
	public static Director Directors[] = new Director[50];
	public static Movie Movies[] = new Movie[50];
	public static Saloon Saloons[] = new Saloon[3];
	public static Showtime Morning1 = new Showtime(0);
	public static Showtime Noon1 = new Showtime(0);
	public static Showtime Evening1 = new Showtime(0);
	public static Showtime Morning2 = new Showtime(0);
	public static Showtime Noon2 = new Showtime(0);
	public static Showtime Evening2 = new Showtime(0);
	public static Showtime Morning3 = new Showtime(0);
	public static Showtime Noon3 = new Showtime(0);
	public static Showtime Evening3 = new Showtime(0);
	public static int a = 0, b = 0, c = 0, d = 0, e = 1, f = 0, g = 0, q = 0;
	public static double total;

	static void addStar(int i, String x, String y, String z) {

		Stars[i] = new Star(x, y, z, i);
		a = a + 1;
	}

	static void addDirector(int i, String x, String y, String z) {
		Directors[i] = new Director(x, y, z, i);
		b = b + 1;
	}

	static void addMovie(int i, String x, String y, String z, int j, int k, int m, int[] p) {
		Movies[k] = new Movie(x, y, z, Directors[j], k, m, p);

		c = c + 1;

	}

	static void updateSaloon(int i, int j) {
		if (Movies[j - 1] == null) {
			System.out.println("No such movie.");
		} else {
			Saloons[i - 1].setSaloonID(i);
			Saloons[i - 1].setMovieID(Movies[j - 1]);
			e = e + 1;
		}
	}

	static void updateShowtime(int i, String s, int j) {
		if (s.equals("morning") && i == 1) {
			Morning1.setPrice(j);

		} else if (s.equals("morning") && i == 2) {
			Morning2.setPrice(j);

		} else if (s.equals("morning") && i == 3) {
			Morning3.setPrice(j);

		} else if (s.equals("noon") && i == 1) {
			Noon1.setPrice(j);

		} else if (s.equals("noon") && i == 2) {
			Noon2.setPrice(j);

		} else if (s.equals("noon") && i == 3) {
			Noon3.setPrice(j);

		} else if (s.equals("evening") && i == 1) {
			Evening1.setPrice(j);

		} else if (s.equals("evening") && i == 2) {
			Evening2.setPrice(j);

		} else if (s.equals("evening") && i == 3) {
			Evening3.setPrice(j);

		}
	}

	static void sellTicket(int SaloonNumber, String Showtime, int Row, int Column, String Type) {

		if (Showtime.equals("morning")) {
			if (Saloons[SaloonNumber - 1].getMorning().getSeatStatus(Row, Column)) {
				Saloons[SaloonNumber - 1].getMorning().setSeats(Row, Column, false, Type);
			} else {
				Saloons[SaloonNumber - 1].getMorning().FindPlaceMorning(Row, Column, SaloonNumber, Type);
			}
		} else if (Showtime.equals("noon")) {
			if (Saloons[SaloonNumber - 1].getNoon().getSeatStatus(Row, Column)) {
				Saloons[SaloonNumber - 1].getNoon().setSeats(Row, Column, false, Type);
			} else
				Saloons[SaloonNumber - 1].getNoon().FindPlaceMorning(Row, Column, SaloonNumber, Type);
		} else if (Showtime.equals("evening")) {
			if (Saloons[SaloonNumber - 1].getEvening().getSeatStatus(Row, Column)) {
				Saloons[SaloonNumber - 1].getEvening().setSeats(Row, Column, false, Type);
			} else
				Saloons[SaloonNumber - 1].getEvening().FindPlaceMorning(Row, Column, SaloonNumber, Type);
		}
	}

	static void cancelTicket(int SaloonNumber, String Showtime, int Row, int Column, String Type) {

		if (Showtime.equals("morning")) {
			if (Saloons[SaloonNumber - 1].getMorning().getSeatStatus(Row, Column) == false) {
				Saloons[SaloonNumber - 1].getMorning().setSeats(Row, Column, true, Type);
			} else
				System.out.println("Ticket is already empty.");
		} else if (Showtime.equals("noon")) {
			if (Saloons[SaloonNumber - 1].getNoon().getSeatStatus(Row, Column) == false) {
				Saloons[SaloonNumber - 1].getNoon().setSeats(Row, Column, true, Type);
			} else
				System.out.println("Ticket is already empty.");
		} else if (Showtime.equals("evening")) {
			if (Saloons[SaloonNumber - 1].getEvening().getSeatStatus(Row, Column) == false) {
				Saloons[SaloonNumber - 1].getEvening().setSeats(Row, Column, true, Type);
			} else
				System.out.println("Ticket is already empty.");
		}

	}

	static void MostFilledShowtime() {
		int[] Showtime = new int[9];
		int sýralama = 0;
		Showtime[0] = (Saloons[0].getMorning().getHowMany());
		Showtime[1] = (Saloons[0].getNoon().getHowMany());
		Showtime[2] = (Saloons[0].getEvening().getHowMany());
		Showtime[3] = (Saloons[1].getMorning().getHowMany());
		Showtime[4] = (Saloons[1].getNoon().getHowMany());
		Showtime[5] = (Saloons[1].getMorning().getHowMany());
		Showtime[6] = (Saloons[2].getEvening().getHowMany());
		Showtime[7] = (Saloons[2].getNoon().getHowMany());
		Showtime[8] = (Saloons[2].getEvening().getHowMany());
		for (int i = 0; i < 9; i++) {
			if (sýralama < Showtime[i])
				sýralama = Showtime[i];
		}

		if (sýralama == Showtime[0])
			System.out.println("The most-filled show time : s1-morning");
		else if (sýralama == Showtime[1])
			System.out.println("The most-filled show time : s1-noon");
		else if (sýralama == Showtime[2])
			System.out.println("The most-filled show time : s1-evening");
		else if (sýralama == Showtime[3])
			System.out.println("The most-filled show time : s2-morning");
		else if (sýralama == Showtime[4])
			System.out.println("The most-filled show time : s2-noon");
		else if (sýralama == Showtime[5])
			System.out.println("The most-filled show time : s2-evening");
		else if (sýralama == Showtime[6])
			System.out.println("The most-filled show time : s3-morning");
		else if (sýralama == Showtime[7])
			System.out.println("The most-filled show time : s3-noon");
		else if (sýralama == Showtime[8])
			System.out.println("The most-filled show time : s3-evening");
		else
			System.out.println("GELDÝ");
	}

	static void MostWatchedMovie() {
		int s11 = 0;
		int s22 = 0;
		int s33 = 0;
		s11 = Saloons[0].getMorning().getHowMany() + Saloons[0].getNoon().getHowMany()
				+ Saloons[0].getEvening().getHowMany();
		s22 = Saloons[1].getMorning().getHowMany() + Saloons[1].getNoon().getHowMany()
				+ Saloons[1].getEvening().getHowMany();
		s33 = Saloons[2].getMorning().getHowMany() + Saloons[2].getNoon().getHowMany()
				+ Saloons[2].getEvening().getHowMany();
		if (s11 > s22 && s11 > s33)
			System.out.println("The most-watched movie : " + Saloons[0].getMovieID().getName());
		else if (s22 > s11 && s22 > s33)
			System.out.println("The most-watched movie : " + Saloons[1].getMovieID().getName());
		else if (s33 > s22 && s33 > s11)
			System.out.println("The most-watched movie : " + Saloons[2].getMovieID().getName());
	}

	static void displayActors() {
		int nullcount = 0;
		for (int i = 0; i < Stars.length; i++)
			if (Stars[i] != null) {
				System.out.println(Stars[i].Display());
				nullcount++;
			} else if (nullcount == 0) {
				System.out.println("No Stars Added");
				break;
			}

		System.out.println(" ");
	}

	static void displayDirectors() {
		int nullcount = 0;
		for (int i = 0; i < Directors.length; i++)
			if (Directors[i] != null) {
				System.out.println(Directors[i].Display());
				nullcount++;
			} else if (nullcount == 0) {
				System.out.println("No Stars Added");
				break;
			}

		System.out.println(" ");

	}

	static void displayMovies() {
		int nullcount = 0;
		for (int i = 0; i < Movies.length; i++)
			if (Movies[i] != null) {
				System.out.println(Movies[i].Display());
				nullcount++;
			} else if (nullcount == 0) {
				System.out.println("No Stars Added");
				break;
			}

		System.out.println(" ");

	}

	static void displaySeats(int saloonid, String showtime) {

		if (showtime.equals("morning")) {
			System.out.println("SALOON " + saloonid + " MORNING");
			Saloons[saloonid - 1].getMorning().getSeats();
		} else if (showtime.equals("noon")) {
			System.out.println("SALOON " + saloonid + " NOON");
			Saloons[saloonid - 1].getNoon().getSeats();
		} else if (showtime.equals("evening")) {
			System.out.println("SALOON " + saloonid + " EVENING");
			Saloons[saloonid - 1].getEvening().getSeats();
		}

	}

	static void displaySeats2(int saloonid, String showtime) {

		if (showtime.equals("morning")) {
			Saloons[saloonid - 1].getMorning().getSeats2(cn.getTextWindow().getCursorX(),
					cn.getTextWindow().getCursorY());
		} else if (showtime.equals("noon")) {
			Saloons[saloonid - 1].getNoon().getSeats2(cn.getTextWindow().getCursorX(), cn.getTextWindow().getCursorY());
		} else if (showtime.equals("evening")) {
			Saloons[saloonid - 1].getEvening().getSeats2(cn.getTextWindow().getCursorX(),
					cn.getTextWindow().getCursorY());
		}

	}

	static void displaySaloons() {
		for (int i = 0; i < Saloons.length; i++)
			if (Saloons[i].getMovieID() != null)
				System.out.println(Saloons[i].Display());
			else {
				System.out.println("Please add a movie before.");
				break;
			}
		System.out.println(" ");
	}

	static void Statistic() {
		MostWatchedMovie();
		System.out.println("Total revenue of CineCeng : " + Revenue());
		MostFilledShowtime();
		HighestIncome();
		int ekrany = cn.getTextWindow().getCursorY();
		cn.getTextWindow().setCursorPosition(0, ekrany);
		System.out.println("               s1            s2            s3");
		cn.getTextWindow().setCursorPosition(0, cn.getTextWindow().getCursorY() + 2);
		System.out.println("MORNING");
		cn.getTextWindow().setCursorPosition(0, cn.getTextWindow().getCursorY() + 7);
		System.out.println("NOON");
		cn.getTextWindow().setCursorPosition(0, cn.getTextWindow().getCursorY() + 7);
		System.out.println("EVENING");
		cn.getTextWindow().setCursorPosition(13, ekrany + 1);
		displaySeats2(1, "morning");
		cn.getTextWindow().setCursorPosition(27, ekrany + 1);
		displaySeats2(2, "morning");
		cn.getTextWindow().setCursorPosition(41, ekrany + 1);
		displaySeats2(3, "morning");
		cn.getTextWindow().setCursorPosition(13, ekrany + 9);
		displaySeats2(1, "noon");
		cn.getTextWindow().setCursorPosition(27, ekrany + 9);
		displaySeats2(2, "noon");
		cn.getTextWindow().setCursorPosition(41, ekrany + 9);
		displaySeats2(3, "noon");
		cn.getTextWindow().setCursorPosition(13, ekrany + 17);
		displaySeats2(1, "evening");
		cn.getTextWindow().setCursorPosition(27, ekrany + 17);
		displaySeats2(2, "evening");
		cn.getTextWindow().setCursorPosition(41, ekrany + 17);
		displaySeats2(3, "evening");
		cn.getTextWindow().setCursorPosition(0, ekrany + 22);
	}

	static void HighestIncome() {
		double film1 = 0;
		double film2 = 0;
		double film3 = 0;
		film1 = Saloons[0].getMorning().getIncome() + Saloons[0].getNoon().getIncome()
				+ Saloons[0].getEvening().getIncome();
		film2 = Saloons[1].getMorning().getIncome() + Saloons[1].getNoon().getIncome()
				+ Saloons[1].getEvening().getIncome();
		film3 = Saloons[2].getMorning().getIncome() + Saloons[2].getNoon().getIncome()
				+ Saloons[2].getEvening().getIncome();
		if (film1 > film2 && film1 > film3)
			System.out.println("The highest-income movie : " + Saloons[0].getMovieID().getName() + " - " + film1);
		else if (film2 > film1 && film2 > film3)
			System.out.println("The highest-income movie : " + Saloons[1].getMovieID().getName() + " - " + film2);
		else if (film3 > film1 && film3 > film2)
			System.out.println("The highest-income movie : " + Saloons[2].getMovieID().getName() + " - " + film3);

		total = film1 + film2 + film3;
	}

	static double Revenue() {
		double film1 = 0;
		double film2 = 0;
		double film3 = 0;
		film1 = Saloons[0].getMorning().getIncome() + Saloons[0].getNoon().getIncome()
				+ Saloons[0].getEvening().getIncome();
		film2 = Saloons[1].getMorning().getIncome() + Saloons[1].getNoon().getIncome()
				+ Saloons[1].getEvening().getIncome();
		film3 = Saloons[2].getMorning().getIncome() + Saloons[2].getNoon().getIncome()
				+ Saloons[2].getEvening().getIncome();

		return film1 + film2 + film3;
	}

	static void Reset() {
		for (int i = 0; i < Stars.length; i++)
			Stars[i] = null;
		for (int i = 0; i < Directors.length; i++)
			Directors[i] = null;
		for (int i = 0; i < Movies.length; i++)
			Movies[i] = null;
		for (int i = 0; i < Saloons.length; i++)
			Saloons[i] = null;
		Morning1.Initialize();
		Noon1.Initialize();
		Evening1.Initialize();
		Morning2.Initialize();
		Noon2.Initialize();
		Evening2.Initialize();
		Morning3.Initialize();
		Noon3.Initialize();
		Evening3.Initialize();
		a = 0;
		b = 0;
		c = 0;
		d = 0;
		e = 1;
		f = 0;
		g = 0;
		q = 0;
		total = 0;
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		while (5 > 0) {
			System.out.println(
					"                                                                               WELCOME THE DEUCINE ");

			Saloons[0] = new Saloon();
			Saloons[1] = new Saloon();
			Saloons[2] = new Saloon();
			Saloons[0].setMorning(Morning1);
			Saloons[0].setNoon(Noon1);
			Saloons[0].setEvening(Evening1);
			Saloons[1].setMorning(Morning2);
			Saloons[1].setNoon(Noon2);
			Saloons[1].setEvening(Evening2);
			Saloons[2].setMorning(Morning3);
			Saloons[2].setNoon(Noon3);
			Saloons[2].setEvening(Evening3);
			String satir = " ";
			String File = " ";

			Scanner Scanner = new Scanner(System.in);
			String user = Scanner.next();

			while (!user.equals("endTheDay")) {
				String[] userinput = user.split(";");
				if (userinput[0].equals("addStar"))
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else
						addStar(a, userinput[1], userinput[2], userinput[3]);

				else if (userinput[0].equals("addDirector"))
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else
						addDirector(b, userinput[1], userinput[2], userinput[3]);

				else if (userinput[0].equals("addMovie")) {
					if (userinput.length < 5)
						System.out.println("Invalid request.");
					else if (Directors[Integer.parseInt(userinput[4]) - 1] == null) {
						System.out.println("No such director.");
					} else {
						int sayaç = 0;
						g = userinput.length - 5;
						int[] Deneme = new int[g];
						for (int i = 0; i < Deneme.length; i++) {
							if (Stars[Integer.parseInt(userinput[i + 5]) - 1] == null) {
								System.out.println("No such star.");
								sayaç++;
								break;
							} else
								Deneme[i] = Stars[Integer.parseInt(userinput[i + 5]) - 1].getStarID() + 1;
						}
						if (sayaç == 0)
							addMovie(c, userinput[1], userinput[2], userinput[3],
									Directors[Integer.parseInt(userinput[4]) - 1].getDirectorID(), c, g, Deneme);
					}
				}

				else if (userinput[0].equals("updateSaloon")) {
					if (userinput.length != 3)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						updateSaloon(Integer.parseInt(userinput[1]), Integer.parseInt(userinput[2]));
					}
				} else if (userinput[0].equals("updateShowtime")) {
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						updateShowtime(Integer.parseInt(userinput[1]), userinput[2], Integer.parseInt(userinput[3]));
					}
				}

				else if (userinput[0].equals("sellTicket")) {
					if (userinput.length != 5)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						String Deneme = userinput[3].substring(0, 1);
						String Deneme2 = userinput[3].substring(1);
						if (Deneme.equals("A"))
							q = 0;
						else if (Deneme.equals("B"))
							q = 1;
						else if (Deneme.equals("C"))
							q = 2;
						else if (Deneme.equals("D"))
							q = 3;
						else if (Deneme.equals("E"))
							q = 4;
						sellTicket(Integer.parseInt(userinput[1]), userinput[2], q, Integer.parseInt(Deneme2),
								userinput[4]);
					}
				} else if (userinput[0].equals("cancelTicket")) {
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						String Deneme = userinput[3].substring(0, 1);
						String Deneme2 = userinput[3].substring(1);
						if (Deneme.equals("A"))
							q = 0;
						else if (Deneme.equals("B"))
							q = 1;
						else if (Deneme.equals("C"))
							q = 2;
						else if (Deneme.equals("D"))
							q = 3;
						else if (Deneme.equals("E"))
							q = 4;
						cancelTicket(Integer.parseInt(userinput[1]), userinput[2], q, Integer.parseInt(Deneme2),
								"Regular");
					}
				} else if (userinput[0].equals("displayActors")) {
					displayActors();

				} else if (userinput[0].equals("displayDirectors")) {
					displayDirectors();

				} else if (userinput[0].equals("displayMovies")) {
					displayMovies();

				} else if (userinput[0].equals("displaySeats")) {
					if (userinput.length != 3)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						displaySeats(Integer.parseInt(userinput[1]), userinput[2]);
					}

				} else if (userinput[0].equals("displaySaloons")) {
					displaySaloons();

				} else if (userinput[0].equals("load")) {
					if (userinput.length != 2)
						System.out.println("Invalid request.");
					else {
						File file = new File(userinput[1]);
						File = file.toString();
					}
				}

				user = Scanner.next();
			}

			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(File));

			satir = reader.readLine();
			while (satir != null) {
				String[] words = satir.split(";");

				if (words[0].equals("addStar"))
					addStar(a, words[1], words[2], words[3]);

				else if (words[0].equals("addDirector"))
					addDirector(b, words[1], words[2], words[3]);

				else if (words[0].equals("addMovie")) {
					g = words.length - 5;
					int[] Deneme = new int[g];
					for (int i = 0; i < Deneme.length; i++)
						Deneme[i] = Integer.parseInt(words[i + 5]);
					addMovie(c, words[1], words[2], words[3], Directors[Integer.parseInt(words[4]) - 1].getDirectorID(),
							c, g, Deneme);
				}

				else if (words[0].equals("updateSaloon"))
					updateSaloon(e, Integer.parseInt(words[2]));

				else if (words[0].equals("updateShowtime")) {
					words[1] = words[1].substring(1);
					updateShowtime(Integer.parseInt(words[1]), words[2], Integer.parseInt(words[3]));
				}

				else if (words[0].equals("sellTicket")) {
					words[1] = words[1].substring(1);
					String Deneme = words[3].substring(0, 1);
					String Deneme2 = words[3].substring(1);
					if (Deneme.equals("A"))
						q = 0;
					else if (Deneme.equals("B"))
						q = 1;
					else if (Deneme.equals("C"))
						q = 2;
					else if (Deneme.equals("D"))
						q = 3;
					else if (Deneme.equals("E"))
						q = 4;
					sellTicket(Integer.parseInt(words[1]), words[2], q, Integer.parseInt(Deneme2), words[4]);
				} else if (words[0].equals("cancelTicket")) {

					words[1] = words[1].substring(1);
					String Deneme = words[3].substring(0, 1);
					String Deneme2 = words[3].substring(1);
					if (Deneme.equals("A"))
						q = 0;
					else if (Deneme.equals("B"))
						q = 1;
					else if (Deneme.equals("C"))
						q = 2;
					else if (Deneme.equals("D"))
						q = 3;
					else if (Deneme.equals("E"))
						q = 4;
					cancelTicket(Integer.parseInt(words[1]), words[2], q, Integer.parseInt(Deneme2), "Regular");
				}

				satir = reader.readLine();
			}

			Statistic();

			user = " ";
			while (!user.equals("endTheDay")) {
				String[] userinput = user.split(";");
				if (userinput[0].equals("addStar"))
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else
						addStar(a, userinput[1], userinput[2], userinput[3]);

				else if (userinput[0].equals("addDirector"))
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else
						addDirector(b, userinput[1], userinput[2], userinput[3]);

				else if (userinput[0].equals("addMovie")) {
					if (userinput.length < 5)
						System.out.println("Invalid request.");
					else if (Directors[Integer.parseInt(userinput[4]) - 1] == null) {
						System.out.println("No such director.");
					} else {
						int sayaç = 0;
						g = userinput.length - 5;
						int[] Deneme = new int[g];
						for (int i = 0; i < Deneme.length; i++) {
							if (Stars[Integer.parseInt(userinput[i + 5]) - 1] == null) {
								System.out.println("No such star.");
								sayaç++;
								break;
							} else
								Deneme[i] = Stars[Integer.parseInt(userinput[i + 5]) - 1].getStarID() + 1;
						}
						if (sayaç == 0)
							addMovie(c, userinput[1], userinput[2], userinput[3],
									Directors[Integer.parseInt(userinput[4]) - 1].getDirectorID(), c, g, Deneme);
					}
				}

				else if (userinput[0].equals("updateSaloon")) {
					if (userinput.length != 3)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						updateSaloon(Integer.parseInt(userinput[1]), Integer.parseInt(userinput[2]));
					}
				} else if (userinput[0].equals("updateShowtime")) {
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						updateShowtime(Integer.parseInt(userinput[1]), userinput[2], Integer.parseInt(userinput[3]));
					}
				}

				else if (userinput[0].equals("sellTicket")) {
					if (userinput.length != 5)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						String Deneme = userinput[3].substring(0, 1);
						String Deneme2 = userinput[3].substring(1);
						if (Deneme.equals("A"))
							q = 0;
						else if (Deneme.equals("B"))
							q = 1;
						else if (Deneme.equals("C"))
							q = 2;
						else if (Deneme.equals("D"))
							q = 3;
						else if (Deneme.equals("E"))
							q = 4;
						sellTicket(Integer.parseInt(userinput[1]), userinput[2], q, Integer.parseInt(Deneme2),
								userinput[4]);
					}
				} else if (userinput[0].equals("cancelTicket")) {
					if (userinput.length != 4)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						String Deneme = userinput[3].substring(0, 1);
						String Deneme2 = userinput[3].substring(1);
						if (Deneme.equals("A"))
							q = 0;
						else if (Deneme.equals("B"))
							q = 1;
						else if (Deneme.equals("C"))
							q = 2;
						else if (Deneme.equals("D"))
							q = 3;
						else if (Deneme.equals("E"))
							q = 4;
						cancelTicket(Integer.parseInt(userinput[1]), userinput[2], q, Integer.parseInt(Deneme2),
								"Regular");
					}
				} else if (userinput[0].equals("displayActors")) {
					displayActors();

				} else if (userinput[0].equals("displayDirectors")) {
					displayDirectors();

				} else if (userinput[0].equals("displayMovies")) {
					displayMovies();

				} else if (userinput[0].equals("displaySeats")) {
					if (userinput.length != 3)
						System.out.println("Invalid request.");
					else {
						userinput[1] = userinput[1].substring(1);
						displaySeats(Integer.parseInt(userinput[1]), userinput[2]);
					}

				} else if (userinput[0].equals("displaySaloons")) {
					displaySaloons();

				} else if (userinput[0].equals("load")) {
					if (userinput.length != 2)
						System.out.println("Invalid request.");
					else {
						File file = new File(userinput[1]);
						File = file.toString();
					}
				}

				user = Scanner.next();
			}
			Reset();
			reader.close();
			Scanner.close();
		}
	}

}
