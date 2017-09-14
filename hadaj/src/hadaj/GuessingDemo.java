package hadaj;

import java.util.Random;
import java.util.Scanner;

public class GuessingDemo {

	public static void main(String[] args) throws GuessingException {
		int min = 0;
		int max = 100;
		char a = 0;
		int numberOfGuessing = 7;
		int count = 0; // premenna ktora pocita pocet hadani
		Scanner sc = new Scanner(System.in);
		int arrayH[] = new int[numberOfGuessing]; // toto pole bude ukladat
													// cisla ktore hadal pocitac
		System.out.println("Myslite si cislo od 1 do 100 a pocitac bude hadat na ake cislo myslite:\n\n"
				+ "ak vypise cislo mensie ako Vami myslene, stlacte 'v' (viac), v opacnom pripade 'm' (menej)\n"
				+ "pokusov moze byt maximalne 7, ak uhadne spravne stlacte 'u' (uhadol). \n");

		hadanie: for (int i = 0; i < arrayH.length; i++) {

			// blok zachytava spolu s metodou chybne vstupy
			try {
				arrayH[i] = randomNumber(min, max);
				System.out.println("Vacsie alebo mensie?(m/v)\n" + arrayH[i] + "\nPocitac ma este pokusov: "
						+ ((arrayH.length - i) - 1) + "\n");
				count++;

				a = sc.next().charAt(0);
				// pokial uzivatel chce viac ako je 100 alebo vice versa
				if (((a == 'v') && (arrayH[i] >= 100)) || ((a == 'm') && (arrayH[i] <= 0))) {

					throw new GuessingException("Program neuhadol vase cislo, mozno ste sa pomylili pri vstupe. ");
				}
				validate(a);

			} catch (GuessingException e) {
				e.printStackTrace();

			}

			switch (a) {
			case 'm':
				max = arrayH[i];
				break; // ak je myslene cislo mensie ako uhadol pocitac, zaradi
						// ho do max
			case 'v':
				min = arrayH[i];
				break; // a naopak
			case 'u':
				System.out.println("\nUhadol!!!\n");
				break hadanie; // ak uzivatel uhadne program opusti cyklus
			default:
				System.out.println("Neplatny znak, cakam na spravny znak:");
				break;
			}
		}
		// pokial ani na siedmykrat program neuhadol, vyhodi vynimku
		if (count == numberOfGuessing) {

			throw new GuessingException("Program neuhadol vase cislo, mozno ste sa pomylili pri vstupe. ");
		}

		System.out.println("Hadane cisla: ");

		// cyklus vypise hadane cisla
		for (int i = 0; i < count; i++) {
			System.out.println(arrayH[i]);
		}

		sc.close();
		System.out.println("koniec");

	}

	// funkcia ktora generuje nahodne cisla na zaklade urceneho minima a maxima
	public static int randomNumber(int min, int max) {

		Random rand = new Random(); // trebalo samozrejme pouzit Random class

		int randomNum = rand.nextInt((max - min) + 1) + min; // ak si program
																// tipol prilis
																// male cislo a
																// dal som ze
																// treba vacsie,
																// furt hadal
																// rovnake, tak
																// som pridal 1

		return randomNum;
	}

	// metoda ktora porovnava znaky z klavesnice
	public static void validate(char a) throws GuessingException {
		if ((a == 'v') || (a == 'm') || (a == 'u')) {
			return;
		} else {
			throw new GuessingException("nezmysel");
		}

	}

}
