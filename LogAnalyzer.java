import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records=new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr= new FileResource(filename);
         for(String line: fr.lines()){
             LogEntry le=WebLogParser.parseEntry(line);
             records.add(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> uniqueIPs= new ArrayList<String>();
         for(LogEntry le: records){
             String ipAddr=le.getIpAddress();
             int st=le.getStatusCode();
             if(st>199 && st<300 && !uniqueIPs.contains(ipAddr))uniqueIPs.add(ipAddr);
         }
         return uniqueIPs.size();
     }
     
     
     public HashMap<String, Integer> countVisits(){
         HashMap<String, Integer> counts= new HashMap<String, Integer>();
         for(LogEntry le: records){
             String date=le.getAccessTime().toString();
             String ip=le.getIpAddress();
             if(!date.contains("Sep 30"))continue;
             if(!counts.containsKey(ip))counts.put(ip,1);
             else counts.put(ip,counts.get(ip)+1);
         }
         return counts;
     }
     
     
     
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
