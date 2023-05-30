package pck;

import java.io.IOException;

public class Main {
	public static void main(String agrs[]) throws IOException {
		String result="";
		FileManager fm = new FileManager();
		String chave = "1234567890chave@";
		
		String mensagem = fm.readTextFile("./arquivos/mensagem.txt");
		
		/*CRIPTOGRAFIA SIMÉTRICA*/
		long startTime = System.nanoTime();
		CriptografiaSimetrica sim = new CriptografiaSimetrica(chave);

        String mensagemCriptografada = sim.criptografar(mensagem);
        String mensagemDescriptografada = sim.descriptografar(mensagemCriptografada);
        
        result = "A Mensagem:\n\n"+mensagemDescriptografada+"\n\nGera a seguinte criptografia com a chave '"+chave+"':\n\n"+mensagemCriptografada;
        fm.writeTextFile("./arquivos/criptografada_simetrica.txt", result);
        long endTime = System.nanoTime();

        double elapsedTimeSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Tempo decorrido: " + elapsedTimeSeconds + " segundos");
        
        /*CRIPTOGRAFIA HASH*/
        CriptografiaHash hash = new CriptografiaHash();

        result = "Hash da mensagem lida:\n"+hash.criptografar(mensagem);
        fm.writeTextFile("./arquivos/criptografada_hash.txt", result);
	}
}
