//Elizabeth Ralyea
// Project: Java Program
// Date: 01/20/2017
//Purpose: To explore the java language

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class JavaCSCI431 {

		static Scanner read = new Scanner(System.in); //reads in from command line
		static String menu1 = "********************* \n";
		static String menu2 = "	Choice Menu\n";
		static String menu3 = "A : Read Numbers From Command Line\n";
		static String menu4 = "B : Read Numbers From File\n";
		static String menu5 = "E : Exit\n";

		static Stack<String> menu_list = new Stack<String>();


		public static void main(String[] args) throws IOException {
			String choice;
			float avg;

		 menu();
		 choice = read.next().toUpperCase();

		 while(choice != "E") {
		 switch(choice) {
		 	case "A" :avg = ReadFromCommand();
		 			System.out.println("The Average is :" + avg);
		 			break;
		 	case "B" : avg = ReadFromFile();
 					System.out.println("The Average is :" + avg);
 					break;
		 	case "E" : exit();
		 			break;
		 	default: System.out.println("This is not a choice! Please pick another.");
		 			break;
		 }

		 System.out.println(menu_list);
		 choice = read.next().toUpperCase();
		}


	}
		public static void menu() {
			menu_list.push(menu1);
			menu_list.push(menu1);
			menu_list.push(menu2);
			menu_list.push(menu3);
			menu_list.push(menu4);
			menu_list.push(menu5);
			menu_list.push(menu1);
			menu_list.push(menu1);


			System.out.println(menu_list);
		}

		public static void exit() {
			System.out.println("GoodBye!");
			System.exit(0);
		}

		public static float ReadFromFile() throws IOException {
			String filename;
			System.out.println("Please enter the file name:");
			filename = read.next();

			File file = new File(filename);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line;

			float sum = 0;
			int count = 0;
			float average;

			while ((line = bufferedReader.readLine()) != null) {
					try {
						sum = sum + Float.parseFloat(line);
						count++;
					} catch (NumberFormatException e) {

					}

			}
			average = sum /count;
			return average;
		}
		public static float ReadFromCommand() {
			float number;
			float sum = 0;
			int count = 0;
			float average = 0;

			System.out.println("Please enter your numbers: (to stop type -9999)");
			number = read.nextFloat();
			if(number == -9999)
				return average;
			while(number != -9999) {
					sum = sum + number;
					count++;
				number = read.nextFloat();
			}

			average = sum /count;

			return average;
		}


}
