package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRW {

	private String filename;
	private File file;
	private BufferedReader br;
	private BufferedWriter bw;
	private boolean newFile = false;

	public FileRW(String filename) {
		this.filename = filename;

		file = new File(filename);

		if (!file.exists()) {
			newFile = true;
		}

	}

	public boolean isNewFile() {
		return newFile;
	}
	/*
	 * public String[][] getLines(){
	 * 
	 * }
	 */

	public void write(String text) {
		try {
			if (bw == null)	bw = new BufferedWriter(new FileWriter(file));
			bw.write(text);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();

			System.out.println("\n BufferdWriter failed ....");
		}
	}
	
	public String[] read() {
		List<String> linesList = new ArrayList<String>();
		String[] lines;
		try {
			if (br == null)	br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				linesList.add(line);	
			}
		} catch (IOException e) {
			e.printStackTrace();

			System.out.println("\n BufferdWriter failed ....");
		}
		
		lines = new String[linesList.size()];
		
		for(int i = 0; i < lines.length; i++) {
			lines[i] = linesList.get(i);//not noughlines
		}
		
		return lines;
	}
	
	public void closeWriter() {
		try {
			bw.close();
		} catch (IOException e) {
			System.out.printf("Error closing buffered writer for '%s'\n", filename);
		}
	}
	public void closeReader() {
		try {
			br.close();
		} catch (IOException e) {
			System.out.printf("Error closing buffered writer for '%s'\n", filename);
		}
	}

	public void newLine() {
		try {
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			System.out.printf("Failed to add new line to '%s'", filename);
		}
	}
}
