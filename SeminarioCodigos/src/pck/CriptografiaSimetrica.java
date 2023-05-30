package pck;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CriptografiaSimetrica {
    private SecretKeySpec chave;

    public CriptografiaSimetrica(String chave) {
        this.chave = gerarChave(chave);
    }

    public String criptografar(String mensagem) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, chave);
            byte[] encryptedBytes = cipher.doFinal(mensagem.getBytes(StandardCharsets.UTF_8));
            String mensagem_crip = Base64.getEncoder().encodeToString(encryptedBytes); 
            System.out.println("Mensagem descriptografada: \n" + mensagem_crip);
            return mensagem_crip;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String descriptografar(String mensagemCriptografada) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, chave);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(mensagemCriptografada));
            String mensagem = new String(decryptedBytes, StandardCharsets.UTF_8);
            System.out.println("Mensagem criptografada: \n" + mensagem);
            return mensagem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private SecretKeySpec gerarChave(String chave) {
        try {
            byte[] chaveBytes = chave.getBytes(StandardCharsets.UTF_8);
            return new SecretKeySpec(chaveBytes, "AES");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

