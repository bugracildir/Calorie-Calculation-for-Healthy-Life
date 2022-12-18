import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class People {
public String name;
public int personID;
public String gender;
public int weight;
public int height;
public int dateOfBirth;
public int caloriestaken = 0;
public int caloriesburned = 0;
public int calorieneed() { //Method for calculating daily calorie needs for male and female
	int calorieneed = 0;
	if (gender.equals("male")){
		calorieneed=  (int) Math.round(66+(13.75*weight)+(5*height)-(6.8*(2022-dateOfBirth)));	
	}
	if (gender.equals("female")){
		calorieneed= (int) Math.round(665+(9.6*weight)+(1.7*height)-(4.7*(2022-dateOfBirth)));	
	}
	return calorieneed;
}
public static void addAttributesToObjects(People[] peoplelist) throws FileNotFoundException {
	File people = new File("people.txt");
	Scanner scanpeople1 = new Scanner(people);
    while (scanpeople1.hasNext()){
        for (int i = 0; i < peoplelist.length; i++) {
        	String peopleline = scanpeople1.nextLine();
        	String[] my_list = peopleline.split("\t");
        	peoplelist[i].name=my_list[1];
        	peoplelist[i].gender=my_list[2];
        	peoplelist[i].personID=Integer.parseInt(my_list[0]);;
        	peoplelist[i].weight=Integer.parseInt(my_list[3]);;
        	peoplelist[i].height=Integer.parseInt(my_list[4]);;
        	peoplelist[i].dateOfBirth= Integer.parseInt(my_list[5]); 
        	
        	//We took the information from people.txt and created objects
}
}
}
}
