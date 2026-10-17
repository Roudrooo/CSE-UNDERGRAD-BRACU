import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


class ReadingFile{
    public static void main(String[] args) throws IOException{
        String location = "C:\\Users\\sabbir.ahmed\\Desktop\\Hello.txt";
        FileReader fr = new FileReader(location);
        BufferedReader br = new BufferedReader(fr);
        String first_line = br.readLine();
        String second_line = br.readLine();
        String third_line = br.readLine();
        System.out.println(first_line);
        System.out.println(second_line);
        System.out.println(third_line);
        br.close();
        fr.close();
    }
}
