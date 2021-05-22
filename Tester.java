
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testCounts() {
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("data/weblog2_log.txt");
        HashMap<String,Integer>counts=la.countVisits();
        for(String w: counts.keySet()){
            System.out.println(w+"\t\t"+counts.get(w));            
        }
    }
    

    
    
    
    
    
    
    
    
    public void testUniqueIP(){
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("data/short-test_log.txt");
        int uniqueIPs=la.countUniqueIPs();
        //la.printAll();
        System.out.println("There are "+uniqueIPs+" IPs");
    }
    
    
    public void testLogAnalyzer() {
        // complete method
        
    }
}
