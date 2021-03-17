
class PlayerException extends Exception { 
    public PlayerException(String errorMessage) {
        super(errorMessage);
    }
}
class MoveException extends Exception { 
    public MoveException(String errorMessage) {
        super(errorMessage);
    }
    public MoveException() {
        super();
    }
}
