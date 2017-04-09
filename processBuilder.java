import java.io.*;
import java.util.*;

public class processBuilder {
  public static void main(String args[]) 
     throws InterruptedException,IOException 
  {
     String rspimac="B8:27:EB:B2:F6:03";
     BufferedWriter bw = null;
    ProcessBuilder builder = new ProcessBuilder("nmap", "-sP", "192.168.1.0/24");
    //Map<String, String> environ = builder.environment();
   //File file = new File("F:/myfile.txt");
    File statText = new File("F:/statsTest.txt");
            FileOutputStream ous = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(ous);    
            BufferedWriter w = new BufferedWriter(osw);
    
    final Process process = builder.start();
    InputStream is = process.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null) {
    w.write(line);
    System.out.println(line);
    if(line.contains(rspimac))
    System.out.println("RAspberrr present");
     
    }
    if(line==null)
    w.close();
    System.out.println("Program terminated!");
  }
}