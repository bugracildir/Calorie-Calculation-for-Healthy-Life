import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sport {
	public String name;
	public int sportID;
	public int calorieburned;
	public static void addAttributesToObjects(Sport[] sportlist) throws FileNotFoundException {
		File sport = new File("sport.txt");
		Scanner scansport1 = new Scanner(sport);
        while (scansport1.hasNext()){
        	for (int i = 0; i < sportlist.length; i++) {
        	String sportline = scansport1.nextLine();
            String[] my_list = sportline.split("\t");
            sportlist[i].sportID=Integer.parseInt(my_list[0]);;
            sportlist[i].name=my_list[1];
            sportlist[i].calorieburned= Integer.parseInt(my_list[2]);
          //We took the information from sport.txt and created objects
            }	
        }
	}

}
