import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 8888;
    public static LinkedList<ServerThread> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server Started");
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerThread(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}

    class ServerThread extends Thread {

        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            start();
        }
        @Override
        public void run() {
            String message;
            try {
                try {
                    while (true) {
                        message = in.readUTF();
                        if(message.equals("stop")) {
                            this.downService();
                            break;
                        }
                        for (ServerThread msg : Server.serverList) {
                            System.out.println(message);
                            msg.send(message);
                        }
                    }
                } catch (NullPointerException ignored) {}
            } catch (IOException e) {
                this.downService();
            }
        }

        private void send(String msg) throws IOException {
            out.writeUTF(msg);
            out.flush();
        }

        private void downService() {
            try {
                if(!socket.isClosed()) {
                    socket.close();
                    in.close();
                    out.close();
                    for (ServerThread vr : Server.serverList) {
                        if(vr.equals(this)) vr.interrupt();
                        Server.serverList.remove(this);
                    }
                }
            } catch (IOException ignored) {

            }
        }
}


