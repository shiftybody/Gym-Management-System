public class DataFormatException extends Exception{

    /**
     * Método constructor de la clase DataFormatException
     */
    public DataFormatException() {

    }

    /**
     * Esta excepción se lanza con un NumberFormatException
     * o un Array IndexOutofbounds
     *
     * @param message devuelve la linea donde se encontro la excepción
     */
    public DataFormatException(String message) {
        super(message);
    }

}
