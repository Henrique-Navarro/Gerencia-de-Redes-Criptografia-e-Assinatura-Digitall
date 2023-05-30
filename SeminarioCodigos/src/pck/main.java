package pck;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class main {
	public static void main(String agrs[]) {
	String originalMessage = "Exemplo de mensagem para hash SHA-256";
	        
	        try {
	            // Criando uma instância do MessageDigest com o algoritmo SHA-256
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            
	            // Obtendo o hash dos bytes da mensagem original
	            byte[] hash = digest.digest(originalMessage.getBytes());
	            
	            // Convertendo o hash para uma representação hexadecimal
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hash) {
	                String hex = String.format("%02x", b);
	                hexString.append(hex);
	            }
	            
	            // Exibindo o hash SHA-256
	            System.out.println("Hash SHA-256: " + hexString.toString());
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	}
}
