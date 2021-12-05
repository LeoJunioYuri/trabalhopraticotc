/**
 * Principal
 */
import java.util.*;

public class Principal {
    static Scanner entrada;
    public static void main(String[] args) {
        //ManipulaArquivo arquivo = new ManipulaArquivo();


        entrada = new Scanner(System.in);
        

        
        ManipulaArquivo.lerArquivoTexto(lerNomeArquivoTexto());
        entrada.close();
    }

    private static String lerNomeArquivoTexto(){
        System.out.print("Nome do arquivo texto: ");
        return entrada.nextLine();
    }
}