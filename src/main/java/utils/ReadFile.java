package utils;

import java.io.*;

public class ReadFile {


    public static InputStream readSingleFile() {
        InputStream in = null;
        InputStream in2 = null;
        try {
            in = new BufferedInputStream(new FileInputStream("test.txt"));
            byte[] b = new byte[in.available()];

            in.mark(1);
            in.read(b, 0, 4);
            System.out.println(new String(b));
            System.out.println("暂停读取...");
            Thread.sleep(2000);
            System.out.println("继续读取...");
//            in.reset();
            in.read(b);
            System.out.println(new String(b));
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return in;
    }

    public static void main(String[] args) {
        readSingleFile();
    }
}
