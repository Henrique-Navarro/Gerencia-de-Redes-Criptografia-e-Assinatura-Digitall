package pck;


import java.io.*;
import java.security.*;
import javax.crypto.*;

public class CriptografiaAssimetrica {
    private static final String ALGORITHM = "RSA";

    public static void main(String[] args) {
        try {
            // Gerar par de chaves pública/privada
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Arquivo original
            String inputFile = "arquivo.txt";
            // Arquivo criptografado
            String encryptedFile = "arquivo_criptografado.enc";
            // Arquivo descriptografado
            String decryptedFile = "arquivo_descriptografado.txt";

            // Criptografar o arquivo com a chave pública
            encryptFile(inputFile, encryptedFile, publicKey);

            // Descriptografar o arquivo com a chave privada
            decryptFile(encryptedFile, decryptedFile, privateKey);

            System.out.println("Criptografia e descriptografia concluídas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void encryptFile(String inputFile, String outputFile, PublicKey publicKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IOException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }

            fis.close();
            cos.flush();
            cos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void decryptFile(String inputFile, String outputFile, PrivateKey privateKey) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IOException {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            CipherInputStream cis = new CipherInputStream(fis, cipher);

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            cis.close();
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
