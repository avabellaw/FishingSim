package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW {

	protected String filename;
	protected File file;
	
	public FileWrite tileMap = new FileWrite("Tile Map.txt");

	public FileRW() {

	}

	public class FileWrite extends FileRW {
		public FileWrite(String filename) {
			this.filename = filename;

			file = new File(filename);
			boolean fileCreated;
			try {
				fileCreated = file.createNewFile();

				if (fileCreated)
					System.out.println("File created: " + filename);
				else
					System.out.printf("'%s' already exists\n", filename);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public void Write(char c) {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				bw.append(c);
			} catch (IOException e) {
				e.printStackTrace();
				
				System.out.println("\n BufferdWriter failed ....");
			}
		}
		
		
	}

}
