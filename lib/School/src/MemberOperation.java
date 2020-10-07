import java.util.Iterator;

class MemberOperation  {
    private String stringCache;

    public static void addMember(Member m, Clazz c) {
        try {
            c.getMembers(m).add(m);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removeMember(Member m, Clazz c) {
        try{
            Iterator<Member> iter = c.getMembers(m).iterator();
            while (iter.hasNext()) {
                if (iter.next().getName().equals(m.getName())) {
                    iter.remove();
                    return;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setThesis(Member m, String thesis) {
        if (m instanceof GrandStudent) {
            ((GrandStudent) m).setThesis(thesis);
        } else {
            System.out.println("null");
        }
    }

    public String getThesis(Member m) {
        if (m instanceof GrandStudent) {
            return ((GrandStudent) m).getThesis();
        } else {
            return null;
        }
    }

    public static void updateMember(Member originMember, Member newMember, Clazz c) {
        try{
            Iterator<Member> iter = c.getMembers(originMember).iterator();
            while (iter.hasNext()) {
                Member temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if (temp.getName().equals(originMember.getName())) {
                    temp.setName(newMember.getName());
                }
            }
        } catch(NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Member getMember(Member m, Clazz c) {
        Member temp = null;
        try{
            Iterator<Member> iter = c.getMembers(m).iterator();
            while (iter.hasNext()) {
                temp = iter.next();
                if (temp.getName().equals(m.getName())) {
                    return temp;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public static void printAllMember(Clazz c) {
        System.out.println("print ALL Member: class" + c.getThisClazz());
        String[] allTypeMem = {"Teacher", "Student", "Course", "GrandStudent"};
        try{

            for (String str : allTypeMem) {
                System.out.println(str + ": " + c.getMembers(str).size());
                Iterator<Member> iter = c.getMembers(str).iterator();
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
                System.out.println("---");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}