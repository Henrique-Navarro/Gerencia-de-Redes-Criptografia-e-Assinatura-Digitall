package pck;

import java.io.IOException;

public class main {
	public static void main(String agrs[]) throws IOException {
		String path = "./arquivo.txt";
		FileManager fm = new FileManager();
		String arquivo = fm.readTextFile(path);
		
		CriptografiaHash hash = new CriptografiaHash(arquivo, " ");
		hash.criptografar();
	}
}
