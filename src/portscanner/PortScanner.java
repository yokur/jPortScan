/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portscanner;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PortScanner {
	static private String ip;
        static private int gmax=0;
        static private Scanner scan = new Scanner(System.in);
	
        public String getIP(){
		return this.ip;
	}
        
	public PortScanner(String ip){
		this.ip = ip;
	}


	public void scan(){
            int startingport=0;
            int endingport=startingport+51; //+1285=51t; +85=771t; +51=1285t ACTUAL
            int t=0;

                while(endingport<=65535){ 
                    ScanThread st = new ScanThread(ip, startingport, endingport);
                    st.start();
                    /*try {
                        st.join();
                    } catch (InterruptedException ex) {
                        System.out.println("INTERRUPTED THREAD"); 
                    } */
                    //System.out.println(t+" NEW starts at " + startingport + " ends at " + endingport); 
                    startingport=startingport+51;
                    endingport=startingport+51;
                    t++;
                }
                
            
                
		
            
		//}while(65535 >= i);//while(i < gmax);
	} 
	public static void main(String[] args) 
	{
            if(args!=null){
                ip=args[0];
                System.out.print("IP2scan: "+ip);
                System.out.println("these ports are being used at " + ip + " ::");
		PortScanner ps = new PortScanner(ip);
		ps.scan();
            }
                
                
                //System.out.println("gmax="+gmax);
                
                /*
                ScanThread st = new ScanThread(ip, 50905, 50920);
                st.start();
                try {
                    st.join();
                } catch (InterruptedException ex) {
                
                }*/
	}
}