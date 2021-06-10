import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploader {

    MemberList loadMembers(String fileName)
        throws FileNotFoundException, IOException, DataFormatException;

}
