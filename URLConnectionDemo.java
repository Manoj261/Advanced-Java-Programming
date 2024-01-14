import java.net.*;
import java.io.*;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.javatpoint.com/URLConnection-class");
        URLConnection urlcon = url.openConnection();
        System.out.println(urlcon.getContentLength());
        System.out.println(urlcon.getConnectTimeout());
        System.out.println(urlcon.getContentType());
        System.out.println(urlcon.getDate());
        System.out.println(urlcon.getHeaderField(0));
        System.out.println(urlcon.getExpiration());
        InputStream stream=urlcon.getInputStream(); int i;
        while((i=stream.read())!=-1){
            System.out.print((char)i);
        }
    }
}
