package ja.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileHandlingTest {

	public static void main(String[] args) throws IOException {
		Path fileName = Paths.get("test.txt");
		Path fileName2 = Paths.get("test2.txt");
		Path fileName3 = Paths.get("/translatorResults/test2.txt");
		Path fileName4 = Paths.get("translatorResults\\test2.txt/");
		System.out.println(":: Filenames");
		System.out.println(fileName);
		System.out.println(fileName2);
		System.out.println(fileName3);
		System.out.println(fileName4);
		System.out.println();

		Path path = Paths.get("C:/RAMT/dumps/translatorResult/");
		Path path2 = Paths.get("C:/RAMT\\/dumps//////translatorResult/");
		Path path3 = Paths.get("C:/RAMT\\dumps//////translatorResult/");
		Path path4 = Paths.get("C:/RAMT\\dumps//////translatorResult/", "/translatorResults/test2.txt");
		System.out.println(":: Paths");
		System.out.println(path);
		System.out.println(path2);
		System.out.println(path3);
		System.out.println(path4);
		System.out.println();

		String targetString = path.resolve(fileName).toString();
		Path targetPath = path.resolve(fileName2);
		File file = new File(path.toString(), fileName.toString());
		System.out.println(":: path.resolve & File(path, fileName)");
		System.out.println(targetString);
		System.out.println(targetPath);
		System.out.println(file);
		System.out.println();

		URL url = FileHandlingTest.class.getClassLoader().getResource("");
		URL url2 = FileHandlingTest.class.getClassLoader().getResource("studenti_dtd.xml");
		URL url3 = FileHandlingTest.class.getClassLoader().getResource("resources/studenti_dtd.xml");
		System.out.println(":: getResource");
		System.out.println(url);
		System.out.println(url2);
		System.out.println(url3);
		System.out.println();

		String outString = "ajmo!";
		RandomAccessFile fajlic = new RandomAccessFile(targetString, "rw");
		fajlic.seek(fajlic.length());
		//fajlic.writeBytes(outString);
		fajlic.writeUTF(outString);
		fajlic.getFD().sync();
		fajlic.close();

		//PrintWriter out = new PrintWriter(targetFileName2);
		PrintWriter out = new PrintWriter(new FileOutputStream(targetString, true));
		out.println(outString);
		out.close();

		//Files.write(target2, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		Files.write(targetPath, outString.getBytes(), StandardOpenOption.APPEND);

		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetString, true), "utf-8"));
		writer.write("something");
		writer.close();

		//file.setReadOnly();
		//file.setWritable(false);
		file.setWritable(true);

	}
}
