import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
class ReadingFile_Loop{
    public static void main(String[] args) throws IOException{
        String location = "C:\\Users\\sabbir.ahmed\\Desktop\\info.txt";
        FileReader fr = new FileReader(location);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int i = 1;
        while(line!=null){
            System.out.println("Name#"+i+": "+line);
            i++;
            line = br.readLine();
        }
        br.close();
        fr.close();
    }
}
