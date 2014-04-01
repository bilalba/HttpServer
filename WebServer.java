import java.io.*;
import java.net.*;

public class WebServer {
	public static void main(String[] args) throws Exception {
		ServerSocket welcomeSocket = new ServerSocket(8810);
		while (true) {
      		Socket socks = welcomeSocket.accept();
      		Serverthread h = new Serverthread(socks);
      	}
	}
}