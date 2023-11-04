public class LinkedTest {
    private char ch;
    private LinkedTest next;
    private LinkedTest prev;

    LinkedTest(char ch) {
        this.ch = ch;
    }

    LinkedTest(char ch, LinkedTest next, LinkedTest prev) {
        this.ch = ch;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return String.valueOf(this.ch);
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public void setNext(LinkedTest next) {
        this.next = next;
    }

    public void setPrev(LinkedTest prev) {
        this.prev = prev;
    }

    public static String stringLL(LinkedTest head) {
        if (head == null) {
            return " ->null";
        }
        return head + "" + stringLL(head.next);
    }

    public static void main(String[] args) {
        LinkedTest r = new LinkedTest('r');
        LinkedTest a = new LinkedTest('a');
        LinkedTest n = new LinkedTest('n');

        r.setNext(a);
        a.setNext(n);
        n.setNext(null);

        n.setPrev(a);
        a.setPrev(r);
        r.setPrev(null);

//        System.out.print("r: " + r + "\na: " + a + "\nn: " + n);

        LinkedTest x = new LinkedTest('i');

        n.prev.next = x;
        x.prev = n.prev;
        x.next = n;
        n.prev = x;

        System.out.print(stringLL(r));
    }
}
