import java.util.*;


class Program2
{
	// Read multi-line input from console in Java by using Scanner class
   public static void main(String[] args)
   {
      List<String> tokens = new ArrayList<>();
      Scanner input = new Scanner(System.in);
      boolean keepgoing = true;
      
      while (keepgoing) {
         String line = input.nextLine();
         if(line.isEmpty())
            keepgoing = false;
         else
         {String [] list = line.split(" ",0);
            for( String element : list){
               
               if (!element.isEmpty())
                  tokens.add(element);}
         }
      }
      input.close();
      
      
      Map<String, Integer> counter = new HashMap<String, Integer> ();
      int mode = 0; 
      String most = "";
      for (String s:tokens) {
      
         if (!counter.containsKey(s)) {  // first time we've seen this string
            counter.put(s, 1);
         }
         else {
            int count = counter.get(s);
            counter.put(s, count + 1);
         }
      }
      for (Map.Entry<String, Integer> entry : counter.entrySet()) {
         int i = entry.getValue();
         if (i> mode){
            mode =i;
            most = entry.getKey();}
      }
            
         
    
    
   
      //System.out.println(tokens);
      //System.out.println(counter);
      System.out.println("The most common word is '" + most + "' which appeared " +mode+ " times.");
   
   }

}