import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Food {
	public int foodID;
	public String name;
	public int caloriecount;
public static void addAttributesToObjects(Food[] foodlist) throws FileNotFoundException {
	File food = new File("food.txt");
    Scanner scanfood1 = new Scanner(food);
    while (scanfood1.hasNext()){
    	for (int i = 0; i < foodlist.length; i++) {
    	String foodline = scanfood1.nextLine();
        String[] my_list = foodline.split("\t");
        foodlist[i].foodID=Integer.parseInt(my_list[0]);;
        foodlist[i].name=my_list[1];
        foodlist[i].caloriecount= Integer.parseInt(my_list[2]);    
        
      //We took the information from food.txt and created objects
}
}
}
}
