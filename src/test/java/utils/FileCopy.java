package utils;

import java.io.*;

/**
 * 文件复制方式，字节流，一个4个方式
 * 1.字节流读写单个字节
 * 2.字节流读写字节数组
 * 3.字节缓冲区读写单个字节
 * 4.字节缓冲区读写字节数组
 */
public class FileCopy {

    public static void copy_1(File src, File desc) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        int len = 0;
        while ((len = fis.read()) != -1){
            fos.write(len);
        }
        fos.close();
        fis.close();
    }

    public static void copy_2(File src,File desc)throws IOException{
        FileInputStream fis=new FileInputStream(src);
        FileOutputStream fos=new FileOutputStream(desc);
        int len=0;
        byte[] bytes=new byte[1024];
        while((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }

    /*
     *    方法：实现文件复制
     *     3，字节流缓冲区流读写单个字节
     */
    public static void copy_3(File src,File desc)throws IOException{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(desc));
        int len=0;
        while((len=bis.read())!=-1){
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    /*
     * 方法：实现文件复制
     *     4.字节流缓冲区流读写字节数组
     */
    public static void copy_4(File src,File desc)throws IOException{
//        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
        InputStream bis = new FileInputStream(src);
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0;
        byte[] bytes=new byte[1024];
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }

    public static void copy_5(File src,File desc) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(src));
        BufferedWriter wr = new BufferedWriter(new FileWriter(desc));

        String str;
        while ((str = br.readLine()) != null){
            wr.write(str);
            wr.newLine();
        }
        wr.flush();
        br.close();
        wr.close();

    }

    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();
        copy_5(new File("/Users/shiwang/Downloads/Firefox-latest.dmg"),new File("/Users/shiwang/Downloads/Firefox-latest2.dmg"));
        copy_5(new File("/Users/shiwang/Downloads/Firefox-latest.dmg"),new File("/Users/shiwang/Downloads/Firefox-latest2.dmg"));
//        copy_5(new File("readme.txt"), new File("readme2.txt"));

        long e=System.currentTimeMillis();
        System.out.println(e-s);
    }

}
