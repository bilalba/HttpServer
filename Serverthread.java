import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.*;
public class Serverthread implements Runnable {
	Thread t;
	Socket df;
	ArrayList<String> requests;

	Serverthread(Socket abc) {
		df = abc;
		t = new Thread(this);
		t.start();
	}

	public ArrayList<String> readReq(BufferedReader in) {
		String h;
		ArrayList<String> requests;
		requests = new ArrayList<String>();
		while (true) {
			try{
			  	if ((h = in.readLine()) != null) {
			  		System.out.println("Print:" +h);
	      			if (h.equals(""))
	      				break;
	      			requests.add(h);
	      		}
			} catch (Exception e) {
				System.out.println("Request Timed out. 10 sec."); // check here if request has genuinely timed out or what.
			}
		}
		return requests;
	}
	public void run() {
		try {
			System.out.println("A connection has been made.");
		
      	BufferedReader in = new BufferedReader(new InputStreamReader(df.getInputStream()));             
      	DataOutputStream out = new DataOutputStream(df.getOutputStream());
      	ArrayList<String> requests = readReq(in);
      	System.out.println("muchWOW");
		} catch (Exception e) {
			e.printStackTrace();
			// out.writeBytes("badjob\n");
		}
   }
}