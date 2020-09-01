//this program was written by andrew sears
import java.io.File;		
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class student {									//open class
	public static LinkedList<String> ids() throws FileNotFoundException{	//open method return linked list
		Scanner inputFile = new Scanner(new File("input data files/students.txt"));		//open input file
		LinkedList<String> idData = new LinkedList<String>();				//Declare linked list
		while(inputFile.hasNextLine()){										//while input file has next line
			String line = inputFile.nextLine();								//put line into string
			String[] data = line.split(" ");								//split string into array
			for(int b = 0; b < 3; b++)										//loop 3 times
				idData.add(data[b]);										//add to linked list
		}																	//end while
		inputFile.close();													//close input file
		idData.add("finished");												//add finished to linked list
		return idData;														//return data
	}
}