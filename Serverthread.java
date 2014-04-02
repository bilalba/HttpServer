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
		String h = "";
      	BufferedReader in = new BufferedReader(new InputStreamReader(df.getInputStream()));             
      	DataOutputStream out = new DataOutputStream(df.getOutputStream());
      	while (true) {
      		try{
	      		h = in.readLine();
	      	} catch (Exception e) {
	      		System.out.println("Request timed out. 10 second time out.");
	      	}
	      	if (h.equals("")) {
	      		System.out.println(h); 
	      		out.writeBytes("WTF\n");
	      	}
      }

		} catch (Exception e) {
			e.printStackTrace();
			// out.writeBytes("badjob\n");
		}
   }
}