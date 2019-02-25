import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final int PORT = 8888;

    List<Socket> clientList = new ArrayList<>();

    Socket clientSocket;

    public static void main(String[] args) {
        new Server().go();
    }

    public void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
                clientList.add(clientSocket);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {

        try {for(int i = clientList.size(); --i >=0; ) {
            Socket s = clientList.get(i);
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            System.out.println(message);
            writer.println(message);
            writer.flush();
        }

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public class ClientHandler implements Runnable{
        BufferedReader reader;
        Socket socket;

        public ClientHandler(Socket socket){
            try {
                this.socket = socket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null){
                       sendMessage(message);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}


