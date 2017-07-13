/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portscanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.BindException;
import java.net.Socket;
import java.net.UnknownHostException;



/**
 *
 * @author virtual
 */
public class ScanThread extends Thread{
    private String ip;
    private int startingport;
    private int endingport;
    private Writer output;
    
    	public String getIP(){
		return this.ip;
	}
    
    public ScanThread(String ip, int startingport, int endingport){
        this.ip=ip;
        this.startingport=startingport;
        this.endingport=endingport;
    }
      public void run() {
                int i = startingport;
                //System.out.println();
                //System.out.println(startingport);
                //System.out.println(endingport);
                
                
		do{ //65535
		try{
			Socket sock = new Socket(ip, i);
			System.out.println(ip + ":" + i);
                        output = new BufferedWriter(new FileWriter("c:/logs/openports.txt", true));                       
                        output.append(ip + ":" + i + System.getProperty("line.separator"));
                        output.close();
			sock.close();
		}
		catch( UnknownHostException e ){
			//System.out.println("unknownhost                    " + i);
		}
                catch(BindException e){
			System.out.println(ip + ":" + i + "is being used??");
		}
		catch(IOException e){
			//System.out.println("couldnt connect                " + i );
		}
                finally{
                    i=i+1;
                    //System.out.println("i="+i);
                }
                //gmax=gmax+1285;
                
                //System.out.println("gmax="+gmax);
		}while(endingport >= i);//while(i < groupmax);  
    }
    
}