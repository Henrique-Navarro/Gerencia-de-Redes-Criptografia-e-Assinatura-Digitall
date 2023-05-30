package pck;

import java.io.IOException;

public class Main {
	public static void main(String agrs[]) throws IOException {
		FileManager fm = new FileManager();
		String chave = "1234567890chave@";
		
		String mensagem = fm.readTextFile("./arquivos/original_simetrica.txt");
		
		CriptografiaSimetrica simetrica = new CriptografiaSimetrica(chave);

        String mensagemCriptografada = simetrica.criptografar(mensagem);
        String mensagemDescriptografada = simetrica.descriptografar(mensagemCriptografada);
        
        String result = "A Mensagem:\n\n"+mensagemDescriptografada+"\n\nGera a seguinte criptografia com a chave '"+chave+"':\n\n"+mensagemCriptografada;
        fm.writeTextFile("./arquivos/criptografada_simetrica.txt", result);
        
		//CriptografiaHash hash = new CriptografiaHash(arquivo, " ");
		//hash.criptografar();
	}
}
