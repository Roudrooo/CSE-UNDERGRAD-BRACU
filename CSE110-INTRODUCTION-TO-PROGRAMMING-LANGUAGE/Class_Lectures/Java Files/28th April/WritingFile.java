import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
class WritingFile{
    public static void main(String[] args) throws IOException{
        String location = "C:\\Users\\sabbir.ahmed\\Desktop\\HelloWorld.txt";
        FileWriter fw = new FileWriter(location);
        BufferedWriter bw = new BufferedWriter(fw);
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        bw.write(s1+"\n");
        bw.write("Summer Lover\n");
        bw.write("Semester Break\n");
        bw.close();
        fw.close();
    }
}
