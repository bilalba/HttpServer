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

	public void readReq(BufferedReader in) {
		String h;
		while (true) {
			try{
			  	if ((h = in.readLine()) != null) {
	      			System.out.println("Print:" +h);
	      			if (h.equals(""))
	      				break;
	      		}
			} catch (Exception e) {
				System.out.println("Request Timed out. 10 sec."); // check here if request has genuinely timed out or what.
			}
		}
	}
	public void run() {
		try {
			System.out.println("A connection has been made.");
		
      	BufferedReader in = new BufferedReader(new InputStreamReader(df.getInputStream()));             
      	DataOutputStream out = new DataOutputStream(df.getOutputStream());
      	readReq(in);
      	System.out.println("muchWOW");
		} catch (Exception e) {
			e.printStackTrace();
			// out.writeBytes("badjob\n");
		}
   }
}