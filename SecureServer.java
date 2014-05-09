import java.io.*;
import java.net.*;

public class SecureServer {
	public static void main(String[] args) throws Exception {
		ServerSocket welcomeSocket = new ServerSocket(443);
		while (true) {
      		Socket socks = welcomeSocket.accept();
      		socks.setSoTimeout(10*1000); // timeout seconds.
      		Securethread h = new Securethread(socks);
      	}
	}
}