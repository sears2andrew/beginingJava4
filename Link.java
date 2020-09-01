
import java.io.PrintWriter;

public class Link {
   public PrintWriter outputFile;	
   public String first;
   public String last;
   public Double score;
   public String grade;
   public Link next;
   public Link firstLink; 
	
   public Link(String first, String last, double score, String grade){
      this.first = first;			//set first
      this.last = last;			//set last
      this.score = score;			//set score
      this.grade = grade;			//set grade
   }
	
	
   public void setNext(Link n)		//open setNext 
   {
      next = n;					//set next
   }								//close next
   public Link getNext()			//open getnext
   {		
      return next;				//return next
   }								//close next
   public String getDatafirst()	//open getDatafirst
   {
      return first;				//return first name
   }								//close first
   public String getDatalast()		//open getDatalast
   {
      return last;				//return last name
   }								//close last
   public Double getDatascore(){	//open getDatascore
      return score;				//return score
   }								//close score
   public String getDatagrade()	//open getDatagrade
   {
      return grade;				//return grade
   }								//close grade
}									//close class