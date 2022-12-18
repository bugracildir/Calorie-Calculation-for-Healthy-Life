import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File people = new File("people.txt");
	    Scanner scanpeople = new Scanner(people);
	    int lineOfPeople = 0; //Variable for number of people, I will use this to create objects
	    while (scanpeople.hasNextLine()){
	    	scanpeople.nextLine();
	        lineOfPeople++;
	    }
	     
	    People[] peoplelist = new People[lineOfPeople];
        for (int i = 0; i < lineOfPeople; i++) {
            peoplelist[i] = new People();
        }
        People.addAttributesToObjects(peoplelist);
        //Until now, we took the information from people.txt and created class named People, then we added people's 
        //information to that class
        
        
        
        File food = new File("food.txt");
	    Scanner scanfood = new Scanner(food);
	    int lineOfFood = 0; //Variable for number of food, I will use this to create objects
	    while (scanfood.hasNextLine()) {
	    	scanfood.nextLine();
	        lineOfFood++;
	    }
	     
	    Food[] foodlist = new Food[lineOfFood];
        for (int i = 0; i < lineOfFood; i++) {
            foodlist[i] = new Food();
        }
        Food.addAttributesToObjects(foodlist);  
      //Until now, we took the information from food.txt and created class named Food, then we added food's
      //information to that class
        
        
        
        
        File sport = new File("sport.txt");
	    Scanner scansport = new Scanner(sport);
	    int lineOfSport = 0; //Variable for number of sports, I will use this to create objects
	    while (scansport.hasNextLine()){
	    	scansport.nextLine();
	        lineOfSport++;
	    }
	     
	    Sport[] sportlist = new Sport[lineOfSport];
        for (int i = 0; i < lineOfSport; i++) {
            sportlist[i] = new Sport();
        }
        
        Sport.addAttributesToObjects(sportlist);
        //Until now, we took the information from sport.txt and created class named Sport, then we added sport's 
      //information to that class
        
        File command = new File("command.txt");//Opening and scanning command.txt
        Write.readandwrite(sportlist, foodlist, peoplelist, command);//We created the lists and now we will read commands and execute and write

        }    
	}