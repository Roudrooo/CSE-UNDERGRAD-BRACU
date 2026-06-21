import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
class ReadingFile_ForLoop{
  public static void main(String[] args) throws IOException{
    String location = "C:\\Users\\sabbir.ahmed\\Desktop\\info.txt";
    FileReader fr = new FileReader(location);
    BufferedReader br = new BufferedReader(fr);
    for (String line = br.readLine(); line!=null; line = br.readLine()){
      System.out.println(line);
    }
    br.close();
    fr.close();
  }
}
