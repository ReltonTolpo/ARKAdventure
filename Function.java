package ark.adventure;

import java.util.*;

public class Function {
    
    public static String input(String prompt){ 
        
        Scanner reader = new Scanner(System.in);  // Reading from System.in 
        System.out.println(prompt); 
        String n = reader.nextLine(); // Scans the next token of the input as an int. 
              
        return n; 
    }
    
    public static String print(String input){
        
        System.out.println(input);
        
        return input;
        
    }
    
    public static void line(){
        
        System.out.println("");
        
    }
    
}
