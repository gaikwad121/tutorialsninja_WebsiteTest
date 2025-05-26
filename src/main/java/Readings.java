import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Readings {
public static void main(String[] args) throws IOException {
	File file=new File("D:\\MyEclipseWorkPlace\\Selenium_Java_Project_01\\src\\test\\resources\\resourses\\URL.txt");
	FileReader fr=new FileReader(file);
	BufferedReader reader=new BufferedReader(fr);
	String str=reader.readLine();
	String str2=reader.readLine();

	System.out.println("Data is :"+str);
	System.out.println(str2);
	reader.close();
}
}
