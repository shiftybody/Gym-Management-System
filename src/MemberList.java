import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que modela un catalogo o lista de miembros
 *
 * @author Shiftybody
 * @version 0.0.1
 */
public class MemberList implements Iterable<Member> {

    private final ArrayList<Member> members = new ArrayList<>();
    private static MemberList singleton = null;

    /**
     * Método constructor inaccesible para otras clases
     * Se considera una buena práctica agregar un constructor por defecto.
     */
    private MemberList() {
    }

    /**
     * Implementación del patrón singletón
     *
     * @return acceso a una instancia unica
     */
    public static MemberList getSingleton() {

        if (singleton == null) {
            singleton = new MemberList();
        }
        return singleton;
    }

    /**
     * Añáde un miembro especifico a la colección miembros
     *
     * @param member
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * metodo consultor de un objeto tipo Member dado un id
     *
     * @param id
     * @return una referencia a la instancia Member con el código especificado.
     */
    public Member getMember(String id) {
        for (Member member :
                members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    /**
     * Dado un Id almacena temporalmente el miembro para su eliminación
     *
     * @param id
     * @return
     */
    public boolean removeMember(String id) {

        Member membtemp = getMember(id);
        return members.remove(membtemp);

    }

    /**
     * Devuelve un iterador sobre elementos de tipo member
     *
     * @return an Iterator.
     */

    @Override
    public Iterator iterator() {
        return members.iterator();
    }
}
