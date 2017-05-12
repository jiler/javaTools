
import java.net.*;
import org.apache.http.HttpHost;

public class InetAddressTest {

    public static void interNetAddress(){
        String IP = null;
        String host = null;
        try {
            InetAddress ia = InetAddress.getLocalHost();
            host = ia.getHostName();//获取计算机主机名  
            IP= ia.getHostAddress();//获取计算机IP
            System.out.println("local hostname: "+host);
            System.out.println("local hostAddress: "+IP);
            System.out.println("local InetAddress: "+ia);
        } catch(UnknownHostException e) {
            e.printStackTrace();
        }
        
        try {
            InetAddress ias = InetAddress.getByName("localhost");
            host = ias.getHostName();//获取计算机主机名  
            IP= ias.getHostAddress();//获取计算机IP

            System.out.println("localhost hostname: "+host);
            System.out.println("localhost hostAddress: "+IP);
            System.out.println("localhost InetAddress: "+ias);

            InetAddress iaa = InetAddress.getByName("10.4.20.195");


            host = iaa.getHostName();//获取计算机主机名  
            IP= iaa.getHostAddress();//获取计算机IP
            System.out.println("10机器 hostname: "+host);
            System.out.println("10机器 hostAddress: "+IP);
            System.out.println("10机器 InetAddress: "+iaa);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void httphostTest(){
        HttpHost h = new HttpHost("localhost", 8080);
        System.out.println(h.getAddress());
        System.out.println(h.getHostName());
        System.out.println(h.toString());
        System.out.println(h.getSchemeName());

        HttpHost hh = new HttpHost("localhost", 8080, "scoket");
        System.out.println("==========");
        System.out.println(hh.getAddress());
        System.out.println(hh.getHostName());
        System.out.println(hh.toString());
        System.out.println(hh.getSchemeName());
    }


    public static void main(String[] args)
    {
        interNetAddress();
        httphostTest();
    }
}


/**
 output:
 local hostname: A06P-E52C64D3
 local hostAddress: 192.168.98.56
 local InetAddress: A06P-E52C64D3/192.168.98.56
 localhost hostname: localhost
 localhost hostAddress: 127.0.0.1
 localhost InetAddress: localhost/127.0.0.1
 10机器 hostname: 10.4.20.195
 10机器 hostAddress: 10.4.20.195
 10机器 InetAddress: 10.4.20.195/10.4.20.195
 null
 localhost
 http://localhost:8080
 http
 ==========
 null
 localhost
 scoket://localhost:8080
 scoket

 * */
