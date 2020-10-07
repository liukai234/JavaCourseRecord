import java.util.Iterator;
import java.util.LinkedList;

interface IMemberOperation {
    public abstract void addMember(Member m);
    public abstract void removeMember(Member m);
    public abstract void updateMember(Member originMem, Member newMem);
    public abstract Member getMember(Member m);
    public abstract void printAllMember();
//    public String toString();
}

