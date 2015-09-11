
import java.util.ArrayList;

public class DictionaryWords {

   private ArrayList<String> dict = new ArrayList<String>();
   public DictionaryWords(){
	   dict.add("apple");
       dict.add("pie");
       dict.add("sea");
       dict.add("side");
       dict.add("a");
       dict.add("man");
   }
    public String segmentation(String str) {
        int len = str.length();
        for (int i = 1; i < len; i++) {
            String first = str.substring(0, i);
            if (dict.contains(first)) 
            	//found a words, see if the other is also one
            {
                String second = str.substring(i, len);
                if (dict.contains(second)) {
                    return first + " " + second;
                }
            }
        }
        return null;  //no two words found
    }

    public static void main(String[] args) {
      
        DictionaryWords test=new DictionaryWords();
        System.out.println(test.segmentation("seaside"));
        System.out.println(test.segmentation("aman"));
        System.out.println(test.segmentation("applepie"));
        
        
     


    }

}
