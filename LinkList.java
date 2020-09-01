//written by andrew sears
class LinkList{												//open class
		
   public Link firstLink; 									//set variables for class
   public int sizea = 0;
   public int sizeb = 0;
   public int count = 0;
	
   public void sortscore(String first, String last, double score, String grade){	//open sortscore method
      Link n = new Link(first,last,score,grade);			//create link
      if (sizea == 0){										//if size = 0
         n.setNext(firstLink);							//set link as first
         firstLink = n;									
         sizea++;											//add one to size
      }													//end if
      else{												//if size is not 0
         Link p = firstLink;								//set p to first link
         Link q = null;									//set q to null
         boolean endOfList = false;						//set end as false
         while (endOfList == false){						//while not end
            q = p;										//set q equal to p
            p = p.getNext();							//set p to next link
            if(p == null){								//if next link is null
               endOfList = true;						//endlist is true
               q.setNext(n);							//set link between two links
               n.setNext(p);
            }
            else if(q == firstLink && score > p.getDatascore()){	//if firstlink and score is higher
               n.setNext(firstLink);							//set link before firstlink
               firstLink = n;									//set new link as firstlink
               endOfList = true;								//endlist is true
            }													//close else if
            //if score of prev link is less and next score is more or prev or next is same score
            else if(q.getDatascore() > score && score > p.getDatascore() || q.getDatascore() == score || p.getDatascore() == score){
               endOfList = true;						//endlist is true
               q.setNext(n);							//set link between links
               n.setNext(p);
            }											//close if
         }												//end while
      }													//end else
   }														//close method
   public void sortLast(String first, String last, double score, String grade){	//sort name method 
      Link n = new Link(first,last,score,grade);			//create link
      if (sizeb == 0){									//if size is 0
         n.setNext(firstLink);							//set first link
         firstLink = n;									
         sizeb++;										//add one to size b
      }													//close if
      else{												//if size is not 0
         Link p = firstLink;								//set p to first link	
         Link q = null;									//set q to null
         boolean endOfList = false;						//set end as false
         while (endOfList == false){						//while not end
            q = p;										//set q equal to p
            p = p.getNext();							//set p to next link
            if(p == null){							//id next link is null
               endOfList = true;					//endlist is true
               q.setNext(n);						//set link in between 2 links
               n.setNext(p);
            }										//close if
            else if(q == firstLink && last.charAt(0) < Integer.valueOf(p.getDatalast().charAt(0))){	//if start of last name is befor first link
               n.setNext(firstLink);			//set to first link
               firstLink = n;					//set where first link is
               endOfList = true;				//endlist is true
            }									//end if
            else if(q.getDatalast().charAt(0) <= last.charAt(0) && last.charAt(0) <= p.getDatalast().charAt(0)){	//if a char is same or falls between two links
               endOfList = true;					//endlist is true
               q.setNext(n);						//set link between two links
               n.setNext(p);
            }										//end else
         }												//end while
      }													//end else
   }														//end method
}															//end class