package pck;

public class CriptografiaCesar {
    public static void main(String[] args) {
        String mensagemOriginal = "Hello, World!sdadsasdaui.ç";
        int chave = 8;

        String mensagemCriptografada = criptografar(mensagemOriginal, chave);
        System.out.println("Mensagem criptografada: " + mensagemCriptografada);

        String mensagemDescriptografada = descriptografar(mensagemCriptografada, chave);
        System.out.println("Mensagem descriptografada: " + mensagemDescriptografada);
    }

    public static String criptografar(String mensagem, int chave) {
        StringBuilder mensagemCriptografada = new StringBuilder();

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);

            // Verifica se o caractere é uma letra maiúscula
            if (Character.isUpperCase(caractere)) {
                char novoCaractere = (char) (((caractere - 'A' + chave) % 26) + 'A');
                mensagemCriptografada.append(novoCaractere);
            }
            // Verifica se o caractere é uma letra minúscula
            else if (Character.isLowerCase(caractere)) {
                char novoCaractere = (char) (((caractere - 'a' + chave) % 26) + 'a');
                mensagemCriptografada.append(novoCaractere);
            }
            // O caractere não é uma letra, mantém o mesmo caractere
            else {
                mensagemCriptografada.append(caractere);
            }
        }

        return mensagemCriptografada.toString();
    }

    public static String descriptografar(String mensagemCriptografada, int chave) {
        // Inverte a chave para desfazer a criptografia
        int chaveInvertida = 26 - chave;
        return criptografar(mensagemCriptografada, chaveInvertida);
    }
}
