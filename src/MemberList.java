import java.util.ArrayList;
import java.util.Iterator;

public class MemberList implements Iterable<Member> {

    private final ArrayList<Member> members = new ArrayList<>();

    MemberList() { }

    public void addMember(Member member){
        members.add(member);
    }

    public Member findMember(String name)
    {
        for (Member memb:
             members) {
            if (memb.getNombre().equalsIgnoreCase(name))
                return memb;
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
