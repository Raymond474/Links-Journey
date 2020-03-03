package main;
import java.util.Scanner;
import model.Book;
import model.Order;
import model.NonFiction;
import model.Fiction;
import model.Fantasy;
import model.SciFi;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuValue;
		int genre = 0;
		int pageLength = 0;
		boolean genreChosen = false;
		boolean pageLengthChosen = false;
		boolean openMenu = true;
		
		Order order = new Order();
		
		while(openMenu) {
			System.out.println("0: exit\n1: add a Book to the Order");
			menuValue = sc.nextInt();
			if(menuValue==0) {break;}
			else if(menuValue==1) {
				while(!genreChosen) {
					System.out.println("NonFiction (1)\nFiction (2)\nFantasy (3)\nSciFi (4)\nPrevious menu (0)");
					genre = sc.nextInt();
					if (genre >= Book.NONFICTION && genre <= Book.SCIFI) {
						genreChosen = true;
						while(!pageLengthChosen) {
							System.out.println("Short (1)\nMedium (2)\nLong (3)\nPrevious menu (0)");
							pageLength = sc.nextInt();
							if (pageLength >= Book.SHORT && pageLength <= Book.LONG) {
								pageLengthChosen = true;
								if (genre == Book.NONFICTION) {
									NonFiction addingBook = new NonFiction(pageLength);
									System.out.println(addingBook);
									order.getBooks().add(addingBook);
								}
								else if (genre == Book.FICTION) {
									Fiction addingBook = new Fiction(pageLength);
									System.out.println(addingBook);
									order.getBooks().add(addingBook);
								}
								else if (genre == Book.FANTASY) {
									Fantasy addingBook = new Fantasy(pageLength);
									System.out.println(addingBook);
									order.getBooks().add(addingBook);
								}
								else {
									SciFi addingBook = new SciFi(pageLength);
									System.out.println(addingBook);
									order.getBooks().add(addingBook);
								}
								
							}
							else if (pageLength == 0) {
								genreChosen = false;
								break;
							}
							else {System.out.println("You have put in a wrong value, try again.");}
						}
					}
					else if (genre == 0) {break;}
					else {System.out.println("You have put in a wrong value, try again.");}
				}
				genreChosen = false;
				pageLengthChosen = false;
			}
			else {
				System.out.println("Invalid Option");
			}
	
		}
		
		System.out.println(order);
		sc.close();
		
	}
	
	
	

}