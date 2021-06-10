import java.util.ArrayList;
import java.util.Iterator;

public class MemberList implements Iterable<Member> {

    private final ArrayList<Member> members = new ArrayList<>();

    MemberList() { }

    public boolean addMember(Member member){
        members.add(member);
        return false;
    }

    public Member findMember(String name)
    {
        for (Member memb:
             members) {
            if (memb.getName().equalsIgnoreCase(name))
                return memb;
        }
        return null;
    }


    public String getAll()
    {

        String message = "All members :\n";

        for (Member memb:
             members) {
            message += memb.toString() + "\n";
            return message;
        }
        return null;
    }

    public int getNoOfMember() {
        return members.size();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */

    @Override
    public Iterator iterator() {
        return members.iterator();
    }
}
