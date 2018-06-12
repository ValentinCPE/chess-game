package tools.data;

public enum TextMessage {

    CHESS_EXCEPTION_GENERAL_MESSAGE("Exception Chess Game : "),
    COORD_IS_NULL("Coordonées sont nulles !"),
    PIECE_DOES_NOT_EXIST("La pièce n'existe pas !");

    private String message;

    TextMessage(String text){
        this.message = text;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
