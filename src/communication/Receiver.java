package communication;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    public Object receive() throws Exception{
        try {
            ObjectInput in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in Receiver" + e.getMessage());
        }
    }
}
