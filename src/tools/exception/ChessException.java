package tools.exception;

import tools.data.TextMessage;

public class ChessException  extends Exception {

    private String exceptionRaised;

    public ChessException(String message){
        super(message);
        this.exceptionRaised = message;
    }

    @Override
    public String getMessage(){
        return TextMessage.CHESS_EXCEPTION_GENERAL_MESSAGE.toString() + this.exceptionRaised;
    }

}
