import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class ManipulaArquivo implements Serializable{
    public static void lerArquivoTexto(String nomeArquivo){
        MT maquina = new MT(null, null, nomeArquivo, nomeArquivo);

        try{
            BufferedReader arquivo = new BufferedReader(new FileReader(nomeArquivo)); 
            String conteudo = arquivo.readLine(); //retorna uma linha do arquivo de texto

            
            if(conteudo.startsWith("111") && conteudo.endsWith("000")){
                maquina.runTM(conteudo);
            }
            else{
                System.err.println("ERRO: o input não começa com 111 ou não termina com 000.");
            }

        
            arquivo.close(); //fechando o arquivo ao finalizar a leitura
        }
        
        catch(FileNotFoundException erro){
            System.out.println("Erro ao encontrar o arquivo: " + nomeArquivo + ".");
        }
        catch(IOException erro){
            System.out.println("Erro no salvamento do arquivo: " + nomeArquivo + "." + " Erro detectado: " + erro.getMessage());
        }
    }
}


    

