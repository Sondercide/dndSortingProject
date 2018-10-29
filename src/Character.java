import java.util.*;
/**
 * This object type holds all the relavant information for a single character and 
 * implement comparable to allow for easy sorting
 * @author Jacob Brown
 *
 */
public class Character implements Comparable<Character>{
	public String ClassName;
	public Integer Str, Dex, Con, Int, Wis, Cha;
	public Integer tempCompare;
	Character(String ClassName, Integer Str, Integer Dex, Integer Con, Integer Int, Integer Wis, Integer Cha ){
		this.ClassName = ClassName;
		this.Str = Str;
		this.Dex = Dex;
		this.Con = Con;
		this.Int = Int;
		this.Wis = Wis;
		this.Cha = Cha;
	}
	
	public void setTempCompare(int tempCompare) {
		this.tempCompare = tempCompare;
	}
	
	@Override
	public int compareTo(Character c) {
		if (this.tempCompare < c.tempCompare) return -1;
		if (this.tempCompare == c.tempCompare) return 0;
		if (this.tempCompare > c.tempCompare) return 1;
		return 0;
	}
	
}

class characterCompare implements Comparator<Character>{
	
	@Override
	public int compare(Character c1, Character c2) {
		return c1.compareTo(c2);
	}
	
}