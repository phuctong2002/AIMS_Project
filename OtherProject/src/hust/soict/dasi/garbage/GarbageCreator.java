package hust.soict.dasi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main( String[] args) throws IOException {
        String fileName = "E:\\ungDung\\vcredist_x64.exe";
        byte[] inputBytes = {0};
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get( fileName));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for( byte b : inputBytes){
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println( endTime - startTime);
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for( byte b : inputBytes){
            outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println( endTime - startTime);
    }
}
