import java.net.*;
import java.lang.*;

public class InetAddressDemo {
    public static void main(String[] args) {
        try{
            InetAddress ip=InetAddress.getByName("localhost");
            System.out.println("Hostname: "+ip.getHostName());
            System.out.println("IP Address: "+ip.getHostAddress());
        }
        catch(Exception e){System.out.println(e);}
    }
}
