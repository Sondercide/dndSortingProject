import java.util.*;
import java.io.*;

/**
 * This program reads in Characters from an external file and 
 * allows the user to sort them based on any of the stats 
 * @author Jacob Brown
 *
 */
public class DnDSorting {

	public static void main(String[] args) throws FileNotFoundException{
		File Characters = new File("characters.txt");
		Scanner FileScan = new Scanner(Characters);
		Scanner scan = new Scanner(System.in);
		ArrayList<Character> CharacterList = new ArrayList<Character>();
		boolean again = true;
		boolean correct = false;
		String sortBy;
		//Reads in file to a ArrayList
		while(FileScan.hasNext()) {
			String ClassName = FileScan.nextLine();
			int Str = Integer.parseInt(FileScan.nextLine().replaceAll(".*:", ""));
			int Dex = Integer.parseInt(FileScan.nextLine().replaceAll(".*:", ""));
			int Con = Integer.parseInt(FileScan.nextLine().replaceAll(".*:", ""));
			int Int = Integer.parseInt(FileScan.nextLine().replaceAll(".*:", ""));
			int Wis = Integer.parseInt(FileScan.nextLine().replaceAll(".*:", ""));
			int Cha = Integer.parseInt(FileScan.nextLine().replaceAll(".*:", ""));
			if(FileScan.hasNextLine())
				FileScan.nextLine();
			CharacterList.add(new Character(ClassName, Str, Dex, Con, Int, Wis, Cha));
		}

		//Gets user input and sorts according to what they said
		do {
			do {
				System.out.println("What stat do you wish to sort these characters by?");
				sortBy = scan.nextLine().toLowerCase();
				correct = false;
				if(sortBy.equals("recursion!") || sortBy.equals("no")) {
					again = false;
					System.out.println("I wish thee good adventuring!");
				}
				else if(sortBy.equals("strength") || sortBy.equals("str"))
					for(Character c  : CharacterList)
						c.setTempCompare(c.Str);
				else if(sortBy.equals("dexterity") || sortBy.equals("dex"))
					for(Character c  : CharacterList)
						c.setTempCompare(c.Str);
				else if(sortBy.equals("constitution") || sortBy.equals("con"))
					for(Character c  : CharacterList)
						c.setTempCompare(c.Str);
				else if(sortBy.equals("intelligence") || sortBy.equals("int"))
					for(Character c  : CharacterList)
						c.setTempCompare(c.Str);
				else if(sortBy.equals("wisdom") || sortBy.equals("wis"))
					for(Character c  : CharacterList)
						c.setTempCompare(c.Str);
				else if(sortBy.equals("charisma") || sortBy.equals("cha"))
					for(Character c  : CharacterList)
						c.setTempCompare(c.Str);
				else {
					System.out.println("That is not a applicable stat. Try again");
					correct = true;
				}
			}while(correct);
			//prints the sorted list
			if(again) {
				Collections.sort(CharacterList, new characterCompare());
				System.out.println("The characters are listed in ascendeing order based on their "+sortBy+".");
				for (Character c : CharacterList)
					System.out.println(c.ClassName + " (" + c.tempCompare +")");

				System.out.println();
			}
		}while(again);
	}
}


