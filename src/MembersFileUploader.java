import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MembersFileUploader implements FileUploader {

    private final static String separator = "_";
    private final static String clientPref = "Client";
    private final static String instructorPref = "Instructor";


    private Member readClient(String line) throws DataFormatException{

        StringTokenizer st = new StringTokenizer(line, separator);

        if (st.countTokens() != 4) {
            throw new DataFormatException("Expected in:  " + line + "\n  Format: Product_code_description_price");

        } else {
            try {
                st.nextToken();
                String id = st.nextToken();
                String name = st.nextToken();
                String address = st.nextToken();
                int number  = Integer.parseInt(st.nextToken());
                double weight = Double.parseDouble(st.nextToken());
                double height = Double.parseDouble(st.nextToken());
                int age  = Integer.parseInt(st.nextToken());
                char sex = st.nextToken().charAt(0);
                String complexion = st.nextToken();

                return new Client(id,name,address,number,weight,height,age,sex,complexion);

            }catch(NumberFormatException  nfe){
                // lanzamos la excepción DataFormatException cuando existe un NumberFormatException
                throw new DataFormatException("Expected in:  " + line + "\n  Price double type");
            }
        }
    }

    private Instructor readInstructor(String line) throws DataFormatException{
        StringTokenizer st = new StringTokenizer(line, separator);

        if (st.countTokens() != 10) {
            throw new DataFormatException("Expected in:  " + line +
                    "\n  Format: Coffee_code_description_price_origin_roast_flavor_aroma_acidity_body");

        } else {
            try {
                st.nextToken();
                String id = st.nextToken();
                String name = st.nextToken();
                String address = st.nextToken();
                int number  = Integer.parseInt(st.nextToken());

                return new Instructor(id, name,address,number);

            }catch(NumberFormatException  nfe){
                throw new DataFormatException("Expected in:  " + line + "\n  Price double type");
            }
        }
    }


    @Override
    public Members loadMembers(String fileName) throws FileNotFoundException, IOException, DataFormatException {

        BufferedReader fileIn =	new BufferedReader(new FileReader(fileName));
        Members members = Members.getSingleton();

        String line = fileIn.readLine();
        while (line != null){

            Member member = null;

            if (line.startsWith(clientPref)){
                member = readClient(line);
            }else if (line.startsWith(instructorPref)){
                member = readInstructor(line);
            }else{
                throw new DataFormatException("Prefix espected in: " + line);
            }

            members.addMember(member);
            line =  fileIn.readLine();

        }
        return members;
    }
}
