import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Serverthread implements Runnable {
	Thread t;
	Socket df;





	Serverthread(Socket abc) {
		df = abc;
		t = new Thread(this);
		t.start();
	}
	public void run() {
		try {
			System.out.println("A connection has been made.");
		String h;
      	BufferedReader in = new BufferedReader(new InputStreamReader(df.getInputStream()));             
      	DataOutputStream out = new DataOutputStream(df.getOutputStream());
      	while (true) {
      		try{
  		      	
		      	if ((h = in.readLine()) != null) {
		      		System.out.println(h); 
		      		out.writeBytes("WTF\n");
		      	}
			} catch (Exception e) {
				System.out.println("Request Timed out. 10 sec.");
			}

      }

		} catch (Exception e) {
			e.printStackTrace();
			// out.writeBytes("badjob\n");
		}
   }
}