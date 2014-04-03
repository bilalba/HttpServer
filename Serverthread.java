import java.io.*;
import java.net.*;
import java.util.*;
public class Serverthread implements Runnable {
	Thread t;
	Socket df;
	ArrayList<String> requests;
	DataOutputStream out;

	Serverthread(Socket abc) {
		df = abc;
		t = new Thread(this);
		t.start();
	}

	public void send(String tobesent) {
	try {
		out.writeBytes(tobesent + "\n");
		} catch (Exception e) {
			System.out.println("Some error sending");
		}
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
      	out = new DataOutputStream(df.getOutputStream());
      	ArrayList<String> requests = readReq(in);
      	RequestParse req = new RequestParse(requests);
      	System.out.println(req.r_path);
      	System.out.println("muchWOW");
      	send("HTTP/1.1 200 OK");
		send("Date: Fri, 06 Nov 2009 00:35:42 GMT");
		send("Server: BILAL's Server.");
		send("Content-Length: " + req.length);
		send("Keep-Alive: timeout=15, max=100");
		send("Connection: Keep-Alive");
		send("Content-Type: text/plain");
		send("");
		out.write(req.file, 0, req.length);

		} catch (Exception e) {
			e.printStackTrace();
			// out.writeBytes("badjob\n");
		}
   }
}