

public class Queue {

    static class Node {
        String value;
        Node nextNode;
        Node prevNode;

        Node(String str) {
            this.value = str;
            this.nextNode = null;
            this.prevNode = null;
        }

        Node() {
            this("");
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(String str) {
        Node node = new Node(str);
        if(tail == null) {
            tail = node;
            head = node;
            return;
        }
        else {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        }
        ++size;
    }

    public String remove() {
        if(head == null) {
            return null;
        }
        String res = head.value;
        if (head == tail) {
            head = null;
            tail = null;
            return res;
        }
        head = head.nextNode;
        head.prevNode = null;
        --size;
        return res;
    }

    public class Iterator {
        private Node current;
        private Node last;
        private boolean canRemove;

        public Iterator() {
            current = head;
            last = null;
            canRemove = false;
        }

        public boolean hasNext() {
            return current != null;
        }

        public String next() {
            last = current;
            String data = current.value;
            current = current.nextNode;
            canRemove = true;
            return data;
        }

        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("remove() can only be called after next()");
            }

            if (last == null) {
                throw new IllegalStateException("No element to remove");
            }

            if (last == head && last == tail) {
                head = null;
                tail = null;
            }
            else if (last == head) {
                head = head.nextNode;
                head.prevNode = null;
            }
            else if (last == tail) {
                tail = tail.prevNode;
                tail.nextNode = null;
            }
            else {
                last.prevNode.nextNode = last.nextNode;
                last.nextNode.prevNode = last.prevNode;
            }

            --size;
            canRemove = false;
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add("A");
        q.add("B");
        q.add("C");
        String str = q.remove();
        q.add("D");
        Queue.Iterator iterator = q.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
