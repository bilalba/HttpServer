import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Serverthread implements Runnable {
	Thread t;
	Socket df;
	// String dir;
	// File dirt; 
	Serverthread(Socket abc) {
		// dir = System.getProperty("user.dir");
		// dirt = new File(dir);
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
	      	if ((h = in.readLine()) != null) {
	      		System.out.println(h); 

	      	}
      }

		} catch (Exception e) {
			e.printStackTrace();
			// out.writeBytes("badjob\n");
		}
   }
}