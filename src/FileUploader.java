import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploader {

    Members loadMembers(String fileName)
        throws FileNotFoundException, IOException, DataFormatException;

}
