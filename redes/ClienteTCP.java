import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTCP {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("digite sua mensagem: ");
        String mensagem = scanner.nextLine();
        
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            out.println(mensagem);
            
            String resposta = in.readLine();
            System.out.println("Mensagem direto do servidor: " + resposta);
        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + HOST);
        } catch (IOException e) {
            System.err.println("Erro de " + e.getMessage());
        }
    }
}