import java.io.*;
import java.net.*;
import java.util.*;
public class Securethread implements Runnable {
	Thread t;
	Socket df;
	ArrayList<String> requests;
	DataOutputStream out;

	Securethread(Socket abc) {
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

	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for ( int j = 0; j < bytes.length; j++ ) {
        int v = bytes[j] & 0xFF;
        hexChars[j * 2] = hexArray[v >>> 4];
        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
    }
    return new String(hexChars);
}



	public void readReq(InputStream in) {
		 String h = null;
		ArrayList<String> requests;
		requests = new ArrayList<String>();
		while (true) {
			try{
				byte[] content = new byte[50];  
				int count = -1;  
			  	while ((count = in.read(content)) != -1) {
			  		byte[] turd = new byte[count];
			  		for (int i = 0; i < count; i++) {
			  			turd[i] = content[i];
			  		}
			  		// System.out.println("Print:" +h);
	      			// if (h.equals(""))
	      			// 	break;
	      			// requests.add(h);
	      			System.out.println(bytesToHex(turd));
	      			if (h.equals("hell")) {
	      				break;
	      			}
	      		}
			} catch (Exception e) {
				System.out.println("Request Timed out. 10 sec."); // check here if request has genuinely timed out or what.
			}
		}
		// return requests;
	}
	public void run() {
		try {
			System.out.println("A connection has been made.");
		
      	InputStream in = df.getInputStream();             
      	out = new DataOutputStream(df.getOutputStream());
      	// ArrayList<String> requests = 
      	readReq(in);
  //     	RequestParse req = new RequestParse(requests);
  //     	System.out.println(req.r_path);
  //     	System.out.println("muchWOW");
  //     	send("HTTP/1.1 200 OK");
		// send("Date: Fri, 06 Nov 2009 00:35:42 GMT");
		// send("Server: BILAL's Server.");
		// send("Content-Length: " + req.length);
		// send("Keep-Alive: timeout=15, max=100");
		// send("Connection: Keep-Alive");
		// send("Content-Type: text/plain");
		// send("");
		// out.write(req.file, 0, req.length);

		} catch (Exception e) {
			e.printStackTrace();

			
			// out.writeBytes("badjob\n");
		}
   }
}