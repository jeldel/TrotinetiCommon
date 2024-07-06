package communication;

import java.io.Serializable;

public class Request implements Serializable {
    private int operation;
    private Object argument;

    public Request(int operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public int getOperation() {
        return operation;
    }

    public Object getArgument() {
        return argument;
    }
}
