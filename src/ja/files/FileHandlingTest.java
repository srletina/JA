package ja.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
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
		System.out.println(fileName);
		System.out.println(fileName2);
		System.out.println(fileName3);
		System.out.println(fileName4);
		System.out.println();

		Path path = Paths.get("C:/RAMT/dumps/translatorResult/");
		Path path2 = Paths.get("C:/RAMT\\/dumps//////translatorResult/");
		Path path3 = Paths.get("C:/RAMT\\dumps//////translatorResult/");
		Path path4 = Paths.get("C:/RAMT\\dumps//////translatorResult/", "/translatorResults/test2.txt");
		System.out.println(path);
		System.out.println(path2);
		System.out.println(path3);
		System.out.println(path4);
		System.out.println();

		String target = path.resolve(fileName).toString();
		Path target2 = path.resolve(fileName2);
		File target3 = new File(path.toString(), fileName.toString());
		System.out.println(target);
		System.out.println(target2);
		System.out.println(target3);
		System.out.println();

		String outString = "ajmo!";

		RandomAccessFile fajlic = new RandomAccessFile(target, "rw");
		fajlic.seek(fajlic.length());
		//fajlic.writeBytes(outString);
		fajlic.writeUTF(outString);
		fajlic.getFD().sync();
		fajlic.close();

		//PrintWriter out = new PrintWriter(targetFileName2);
		PrintWriter out = new PrintWriter(new FileOutputStream(target2.toString(), true));
		out.println(outString);
		out.close();

		//Files.write(target2, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		Files.write(target2, outString.getBytes(), StandardOpenOption.APPEND);

		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target, true), "utf-8"));
		writer.write("something");
		writer.close();

		//File file = new File("targetFileName");
		//file.setWritable(false));
		//file.setReadOnly();

	}
}
