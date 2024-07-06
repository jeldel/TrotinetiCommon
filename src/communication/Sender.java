package communication;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object object) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeObject(object);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Error in Sender" + e.getMessage());
        }

    }
}
