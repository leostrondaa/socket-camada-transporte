import java.io.*;
import java.net.*;

public class ServidorTCP {
    private static final int PORTA = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            System.out.println("servidor iniciado.");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Conexão aceita de " + clientSocket.getInetAddress());

                    String mensagem = in.readLine();
                    System.out.println("Mensagem recebida: " + mensagem);

                    out.println("Mensagem recebida!");
                } catch (IOException e) {
                    System.err.println("Erro na conexão>" + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("nao foi possível iniciar o servidor: " + e.getMessage());
        }
    }
}