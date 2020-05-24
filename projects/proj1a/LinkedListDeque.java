public class LinkedListDeque<DataType> {

    public class IntNode {

        public DataType item;
        public IntNode next;
        public IntNode prev;

        public IntNode(DataType i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;

        }

    }

    private IntNode sentinelF;
    private IntNode sentinelR;
    private int size;
    private String out;
    private IntNode getRecursiveHelper;


    public LinkedListDeque() {

        sentinelF = new IntNode(null, null, null);
        sentinelR = new IntNode(null, null, null);

        size = 0;
    }


    public LinkedListDeque(DataType x) {
        sentinelF = new IntNode(null, null, null);
        sentinelF.next = new IntNode(x, null, sentinelF);

        sentinelR = new IntNode(null, null, null);
        sentinelR.prev = sentinelF.next;

        size = 1;
    }


    public void addFirst(DataType x) {
        sentinelF.next = new IntNode(x, sentinelF.next, sentinelF);
        size += 1;

    }


    public void addLast(DataType x) {
        IntNode p = sentinelF;
        IntNode r = sentinelR;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null, p);
        size += 1;

        r.prev = p.next;

    }


    public void removeFirst() {
        sentinelF.next = sentinelF.next.next;
        size -= 1;
    }



    public void removeLast() {

        sentinelR.prev = sentinelR.prev.prev;
        size -= 1;

    }


    public boolean isEmpty() {

        if (sentinelF.next == null & sentinelR.prev == null) {
            return true;
        } else {
            return false;
        }

    }


    public void printDeque() {

        IntNode p = sentinelF;
        String out = "";

        while (p.next != null) {
            out += p.item + " ";
            p = p.next;
        }

        System.out.println(out + '\n');

    }


    private int size(IntNode p) {
        if (p.next == null)
            return 1;
        return 1 + size(p.next);
    }


    public int size() {
        return size(sentinelF.next);
    }


    public DataType get(int i) {

        IntNode p = sentinelF.next;
        int a = 0;

        while (a < i) {
            p = p.next;
        }

        return p.item;
    }


    private DataType getRecursiveHelper(int index, IntNode p) {

        if (index == 0) {
            return p.item;

        } else {
            return getRecursiveHelper(index - 1, p.next);

        }

    }


    public DataType getRecursive(int index) {

        IntNode p = sentinelF;

        return getRecursiveHelper(index, sentinelF.next);


    }


    public LinkedListDeque(LinkedListDeque other) {
        sentinelF = new IntNode(null, null, null);

        for (int i = 0; i < other.size(); i += 1) {
            addLast((DataType) other.get(i));
        }

    }



}
