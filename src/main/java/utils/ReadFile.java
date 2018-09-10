package utils;

import java.io.*;

public class ReadFile {

    /**
     * 字节流读取文件
     * @return
     */
    public static InputStream readSingleFile(String s) {
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

    /**
     * 通过字符流读取文件
     * @return
     */
    public static Reader readSingleFile(){
        Reader reader = null;
        try {
            reader = new FileReader("readme.txt");
            InputStream is = new FileInputStream("readme.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (true){
                String msg = br.readLine();
                if (msg == null){
                    break;
                }
                System.out.println(msg);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return reader;
    }

    public static void main(String[] args) {
        readSingleFile();
    }
}
