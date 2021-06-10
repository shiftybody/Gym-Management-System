import java.util.ArrayList;
import java.util.Iterator;

public class Members implements Iterable<Member> {

    private static Members singleton = null;
    private final ArrayList<Member> members = new ArrayList<>();

    private Members() { }

    public static Members getSingleton() {

        if (singleton == null) {
            singleton = new Members();
        }
        return singleton;
    }

    public void addMember(Member member){
        members.add(member);
    }
    
    public Member getMember(String code){

        for (Member memb :
                members) {
            if (memb.getId().equals(code)) {
                return memb;
            }
        }
        return null;
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
