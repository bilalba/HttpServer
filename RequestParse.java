import java.util.*;
import java.io.*;
public class RequestParse {
	String r_path;
	String version;
	byte[] file;
	String dir;
	int length;
	RequestParse(ArrayList<String> requests) {
		String[] paths = requests.get(0).split(" ");
		if (paths[0].equals("GET"))
			r_path = paths[1];
		version = paths[2];
		dir = System.getProperty("user.dir");
		readfile();
	}

	// public void convertPath() {
	// 	if path.equals("/") {

	// 	}
	// }
	public void readfile() {
		String path = dir +r_path;
		if (new File(path).isDirectory()) {
			try {
				path = directoryscene(path);
			} catch(Throwable e) {
				// file = ""; // fill this out with error of missing index
			}
		}
		System.out.println(path);
		if (new File(path).exists()) {
			// Scanner fileh = new Scanner(new File(path));
			try {
			RandomAccessFile f = new RandomAccessFile(new File(path), "r");
			long longlength = f.length();
             length = (int) longlength;
            byte[] data = new byte[length];
            f.read(data);
        	System.out.println("file reading:" + length);
        	System.out.println(data);
            file = data;
        } catch (Exception e) {
        	System.out.println("error reading file");
        }
		}
	}
	public String directoryscene(String directory) throws Throwable{
		String path ="";
		if (new File(directory + "/index.html").exists()) {
			return directory + "/index.html";
		} else if (new File(directory + "/index.php").exists()) {
			return directory + "/index.php";
		} else {
			throw new Throwable();
		}
	}

	public int getLength() {
		return 0;
	}
}