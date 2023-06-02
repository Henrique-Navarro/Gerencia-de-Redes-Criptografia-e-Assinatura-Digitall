package pck;


public class VigenereCipher {


    public static void main(String[] args) {
        String plaintext = "Hello, World!";
        int[] shifts = {3, 1, 4,5,8,4}; // Exemplo de sequência de shifts: 3, 1, 4

        String encryptedText = encrypt(plaintext, shifts);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shifts);
        System.out.println("Decrypted Text: " + decryptedText);
    }
    public static String encrypt(String plaintext, int[] shifts) {
        StringBuilder ciphertext = new StringBuilder();
        int shiftLength = shifts.length;
        int plaintextLength = plaintext.length();

        for (int i = 0; i < plaintextLength; i++) {
            char plainChar = plaintext.charAt(i);
            int shift = shifts[i % shiftLength];

            if (Character.isUpperCase(plainChar)) {
                int encryptedChar = (plainChar - 'A' + shift) % 26 + 'A';
                ciphertext.append((char) encryptedChar);
            } else if (Character.isLowerCase(plainChar)) {
                int encryptedChar = (plainChar - 'a' + shift) % 26 + 'a';
                ciphertext.append((char) encryptedChar);
            } else {
                ciphertext.append(plainChar);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int[] shifts) {
        StringBuilder plaintext = new StringBuilder();
        int shiftLength = shifts.length;
        int ciphertextLength = ciphertext.length();

        for (int i = 0; i < ciphertextLength; i++) {
            char cipherChar = ciphertext.charAt(i);
            int shift = shifts[i % shiftLength];

            if (Character.isUpperCase(cipherChar)) {
                int decryptedChar = (cipherChar - 'A' - shift + 26) % 26 + 'A';
                plaintext.append((char) decryptedChar);
            } else if (Character.isLowerCase(cipherChar)) {
                int decryptedChar = (cipherChar - 'a' - shift + 26) % 26 + 'a';
                plaintext.append((char) decryptedChar);
            } else {
                plaintext.append(cipherChar);
            }
        }

        return plaintext.toString();
    }


}
