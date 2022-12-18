import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Write{
	public static void readandwrite(Sport[] sportlist, Food[] foodlist, People[] peoplelist, File command) throws IOException {
		File monitoring = new File("monitoring.txt"); //Creating output file 
        FileWriter myWriter = new FileWriter(monitoring); //Creating FileWriter to write monitoring.txt
        

	    Scanner scancommand = new Scanner(command);
		while (scancommand.hasNext()){
        	int totalcalorie=0;
        	int totalcalorieburned=0;
        	String commandline = scancommand.nextLine();
        	String[] my_list = commandline.split("\t");//List for using things in the line separately
        	
        	if (my_list.length==3) { 
        		if (my_list[1].startsWith("1")) { //This means if second object in my_list is food, execute the following lines
        			int portion=Integer.parseInt(my_list[2]); 
        			int personid = Integer.parseInt(my_list[0]); 
        			int foodid = Integer.parseInt(my_list[1]);
        	        for (int i = 0; i < foodlist.length; i++) { //in next lines, I am finding the person's id and then calculating the calorie taken 
        	            if (foodid == foodlist[i].foodID) {
        	            	totalcalorie=foodlist[i].caloriecount * portion;
        	            	for (int j = 0; j < peoplelist.length; j++) {
            	            	if (personid==peoplelist[j].personID) {
    								peoplelist[j].caloriestaken+=totalcalorie;
    								myWriter.write(peoplelist[j].personID+"\t"+"has"+"\t"+"taken"+"\t"+
    								totalcalorie+"kcal"+"\t"+"from"+"\t"+foodlist[i].name+"\n");
    								if (scancommand.hasNext()) { //I wrote this starts separately because i don't want to write stars to last line
										myWriter.write("***************\n");
									}
    							}
						}
        	            }
        	        }
				}
        		if (my_list[1].startsWith("2")) { //This means if second object in my_list is sport execute the following lines
        			int duration=Integer.parseInt(my_list[2]);
        			int sportid = Integer.parseInt(my_list[1]);
        			int personid = Integer.parseInt(my_list[0]);
        			for (int i = 0; i < sportlist.length; i++) {//in next lines, I am finding the person's id and then calculating the calorie burned
        				if (sportid == sportlist[i].sportID) {
        	            	totalcalorieburned=sportlist[i].calorieburned * (duration/60);
        	            	for (int j = 0; j < peoplelist.length; j++) {
            	            	if (personid==peoplelist[j].personID) {
    								peoplelist[j].caloriesburned+=totalcalorieburned;
    								myWriter.write(peoplelist[j].personID+"\t"+"has"+"\t"+"burned"+"\t"+
    								totalcalorieburned+"kcal"+"\t"+"thanks to"+"\t"+sportlist[i].name+"\n");
    								if (scancommand.hasNext()) {//I wrote this starts separately because i don't want to write stars to last line
										myWriter.write("***************\n");
									}
    							}
						
        	            }
        	            	
        				}
        				
        			}
        			
				}
				
			}
        	else if (commandline.startsWith("print(")) { //Lines for print(id) command
				String id= commandline.substring(6,11);
				int personid=Integer.parseInt(id);
				for (int j = 0; j < peoplelist.length; j++) {
					if (personid==peoplelist[j].personID) {
						myWriter.write(peoplelist[j].name+"\t"+(2022-peoplelist[j].dateOfBirth)+"\t"+
								peoplelist[j].calorieneed()+"kcal"+"\t"+peoplelist[j].caloriestaken+"kcal"+"\t"+
								peoplelist[j].caloriesburned+"kcal"+"\t"+
								((peoplelist[j].caloriestaken-peoplelist[j].caloriesburned)-peoplelist[j].calorieneed()
								)+"kcal"+"\n");
						if (scancommand.hasNext()) {//I wrote this starts separately because i don't want to write stars to last line
							myWriter.write("***************\n");
						}
					}
				}
				
			}
        	else if (commandline.equals("printList")) { //Lines for printList command
        		for (int j = 0; j < peoplelist.length; j++) {
        			if ((((peoplelist[j].caloriestaken-peoplelist[j].caloriesburned)-peoplelist[j].calorieneed())<0)
        					&&(peoplelist[j].caloriestaken!=0 || peoplelist[j].caloriesburned!=0)) {
        				myWriter.write(peoplelist[j].name+"\t"+(2022-peoplelist[j].dateOfBirth)+"\t"+
								peoplelist[j].calorieneed()+"kcal"+"\t"+peoplelist[j].caloriestaken+"kcal"+"\t"+
								peoplelist[j].caloriesburned+"kcal"+"\t"+
								((peoplelist[j].caloriestaken-peoplelist[j].caloriesburned)-peoplelist[j].calorieneed()
								)+"kcal"+"\n");
						
					}
        			else if ((((peoplelist[j].caloriestaken-peoplelist[j].caloriesburned)-peoplelist[j].calorieneed())>0)
        					&&(peoplelist[j].caloriestaken!=0 || peoplelist[j].caloriesburned!=0)) {
        				myWriter.write(peoplelist[j].name+"\t"+(2022-peoplelist[j].dateOfBirth)+"\t"+
								peoplelist[j].calorieneed()+"kcal"+"\t"+peoplelist[j].caloriestaken+"kcal"+"\t"+
								peoplelist[j].caloriesburned+"kcal"+"\t"+"+"+
								((peoplelist[j].caloriestaken-peoplelist[j].caloriesburned)-peoplelist[j].calorieneed()
								)+"kcal"+"\n");
					}
        		}
        		if (scancommand.hasNext()) {//I wrote this starts separately because i don't want to write stars to last line
					myWriter.write("***************\n");
				}
        		
        		
        	}
        	else if (commandline.equals("printWarn")) { //Lines for printWarn command
        		ArrayList<Integer> listforwarn = new ArrayList<Integer>();
        		for (int j = 0; j < peoplelist.length; j++) {
        			if ((peoplelist[j].caloriestaken-peoplelist[j].caloriesburned)-peoplelist[j].calorieneed()>0) {
        				listforwarn.add(peoplelist[j].personID);
					}
        		}
        		if (listforwarn.size()==0) {
					myWriter.write("there"+"\t"+"is"+"\t"+"no"+"\t"+"such"+"\t"+"person\n");
				}
        		else if (listforwarn.size()!=0) {
        	    	for(int k = 0;k<listforwarn.size();k++) {
	        	    	for (int j1 = 0; j1 < peoplelist.length; j1++) {
	    					if (listforwarn.get(k)==peoplelist[j1].personID) {
	    						myWriter.write(peoplelist[j1].name+"\t"+(2022-peoplelist[j1].dateOfBirth)+"\t"+
	    								peoplelist[j1].calorieneed()+"kcal"+"\t"+peoplelist[j1].caloriestaken+"kcal"+"\t"+
	    								peoplelist[j1].caloriesburned+"kcal"+"\t"+"+"+
	    								((peoplelist[j1].caloriestaken-peoplelist[j1].caloriesburned)-peoplelist[j1].calorieneed()
	    								)+"kcal"+"\n");
	    					}
    				    }
					
				   }
        	    }
        		if (scancommand.hasNext()) {//I wrote this starts separately because i don't want to write stars to last line
					myWriter.write("***************\n");
				}
        		}
        		
        	}
        myWriter.close();
        scancommand.close();
	}
}
