package ValidatorAndExeption;

public class DuplicatePlateException extends RuntimeException{
    DuplicatePlateException(String plateNumber){
        super("Plate number already registered: " + plateNumber);
    }
}
