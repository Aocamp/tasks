import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static final int PORT = 8888;

    ConcurrentHashMap<String, Socket> activeClients = new ConcurrentHashMap<String, Socket>();

    static int clientCount;
    static String clientID;

    Socket clientSocket;

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
                    for(Map.Entry<String, Socket> entry: activeClients.entrySet()) {
                        Socket socket = entry.getValue();
                        System.out.println(socket);
                        System.out.println(message);
                        sendMessage(message, socket);
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server().go();
    }

    public void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                clientSocket = serverSocket.accept();
                clientCount++;
                clientID = Integer.toString(clientCount);
                activeClients.put(clientID, clientSocket);
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message, Socket socket) {
       // Iterator iterator = writers.iterator();
        //while (iterator.hasNext()){
          try {
                //PrintWriter writer = (PrintWriter) iterator.next();
              PrintWriter writer = new PrintWriter(socket.getOutputStream());
                writer.println(message);
                writer.flush();
            } catch (Exception e){
                e.printStackTrace();
            }
        //}

    }
}


