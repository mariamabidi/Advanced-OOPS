import java.io.Serial;

public class StorageHasBeenModifiedException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    public StorageHasBeenModifiedException(String message){
        super(message);
    }
}
