import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


class WritingFile_Loop{
    public static void main(String[] args) throws IOException{
        String[] words = {"Hi","Hey","Miss","Yes","No"};
        String location = "C:\\Users\\sabbir.ahmed\\Desktop\\MissUniverse.txt";
        FileWriter fw = new FileWriter(location);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0; i<words.length; i++) {
            bw.write( "Name"+(i+1)+words[i]+"\n" );
    }
        bw.close();
        fw.close();
    }
}
