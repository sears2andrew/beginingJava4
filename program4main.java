//this program was written by andrew sears
import java.io.FileWriter;										
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class program4main {										//open class
   public static void main(String[] args) throws IOException {	//main
      LinkList ABCLinkedList = new LinkList();				//create linked lists for each sort type
      LinkList theLinkedList = new LinkList();
      PrintWriter outputFile = new PrintWriter(new FileWriter("gradeData.txt"));	//open output file
      PrintWriter errorFile = new PrintWriter(new FileWriter("errors.txt"));		//open input file
      LinkedList<String> finishedData = test.scores();							//Declare variables
      LinkedList<String> idData = student.ids();	
      outputFile.println("     SCORE ORDER   ");
      outputFile.printf("%-12s %-12s %-4s %-5s\n", "First Name" , "Last Name" , "Avg" , "Grade");	//print header	
      outputFile.println("====================================");
      int i = 0;																	//Declare i
      while(finishedData.get(i) != "end"){										//while not end
         int j = 0;																//declare variables
         int printed = 0;														
         while(idData.get(j) != "finished"){										//while not string finished
            int count = 0;														//Declare variables
            if(idData.get(j).equals(finishedData.get(i))) {						//if strings are equal
               for( int t = 0; t < 4 ; t++) {									//loop 4 times holding base
                  for( int y = 0; y < 4; y++) {								//loop 4 times compairing base
                     if(String.valueOf(idData.get(j).charAt(y+2)).equals(String.valueOf(idData.get(j).charAt(t+2))) && t != y) {	//if chars equal at dif spots
                        errorFile.println(idData.get(j) + " is invalid - Duplicate digits detected.");		//print to errorfile
                        count++;										//add one to count
                        y=4;											//set y to 4
                        t=4;											//set t to 4
                     }														//end if
                  }															//close for
               }																//close for
               boolean charError = false;										//Declare variables
               boolean numError = false;						
               int holder = 0;									
               for(int o = 0; o < 2; o++) {									//loop 2 times
                  if((int)idData.get(j).charAt(o) < 58) 						//check if they are letters
                     charError = true;										//set that there was an error
               }																//end for loop
               for(int l = 0; l < 4; l++) {									//loop 4 times
                  if((int)idData.get(j).charAt(l+2) > 58) {					//if they were letters
                     numError = true;										//set that there was a num error
                     holder = l+2;											//set holder
                  }															//end if
               }																//close for loop
               if (numError == true && charError == false) {					//if num error only
                  errorFile.println(idData.get(j) + " is invalid - characters in the wrong order");		//error file print
                  count++;													//add one to count
               }																//end if
               else if(numError == true) {										//if both errors occurred
                  errorFile.println(idData.get(j) + " is invalid - character '" + idData.get(j).charAt(holder) + "' should be a digit");	//error file print
                  count++;													//add one to count
               }																//end else if
               if(idData.get(j).length() > 6) {								//if not correct length
                  errorFile.println(idData.get(j) + " is invalid - too many characters.");	//error file print
                  count++;													//add one to count
               }																//end if
               if((int)idData.get(j).charAt(0) == (int)idData.get(j).charAt(1)) {		//if characters are the same
                  errorFile.println(idData.get(j)+ " is invalid - First and second characters are the same.");	//error file print
                  count++;													//add one to count
               }																//end if
               if(count == 0) {												//if no errors
                  theLinkedList.sortscore(idData.get(j+1), idData.get(j+2) , Double.valueOf(finishedData.get(i+1)) , finishedData.get(i+2));	//add link to list
                  ABCLinkedList.sortLast(idData.get(j+1), idData.get(j+2) , Double.valueOf(finishedData.get(i+1)) , finishedData.get(i+2));	//add link to list				
               }																//end if
               printed = 1;													//set printed to 1
            }																	//end if
            j += 3;																//add 3 to j
         }																		//end while
         if(printed == 0)														//if nothing was printed
            errorFile.println("ID: " + finishedData.get(i) + " - no name found " + finishedData.get(i+1) + " " + finishedData.get(i+2));	//error file print
         i += 3;																	//add 3 to i
      }																			//close while
      Link theLink = ABCLinkedList.firstLink;										//get first link
      while(theLink != null) {													//while its not null
         outputFile.printf("%-12s %-12s %.2f %-5s\n",theLink.getDatafirst() , theLink.getDatalast() , theLink.getDatascore() , theLink.getDatagrade());	//output file print
         theLink = theLink.getNext();											//get next link
      }																			//end while
      outputFile.println("         ABC  ORDER     ");
      outputFile.printf("%-12s %-12s %-4s %-5s\n", "First Name" , "Last Name" , "Avg" , "Grade");	//print header	
      outputFile.println("====================================");
      Link aLink = theLinkedList.firstLink;										//get first link
      while(aLink != null) {														//while link is not null
         outputFile.printf("%-12s %-12s %.2f %-5s\n",aLink.getDatafirst() , aLink.getDatalast() , aLink.getDatascore() , aLink.getDatagrade());	//output file print
         aLink = aLink.getNext();												//get next link
      }																			//end while
      outputFile.close();															//close files
      errorFile.close();											
   }																				//close main
}																					//close class