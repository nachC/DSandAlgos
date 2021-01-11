public class SLList<Item> {
    /**
     * TODO:
     * handle empty-list case when getting and removing
     * add method to reverse the list
     */

    private class Node<Item> {
        Item value;
        Node<Item> next;

        Node(Item value, Node<Item> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<Item> sentinel;
    int size;

    public SLList() {
        sentinel = new Node<>(null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item value) {
        size++;
        sentinel.next = new Node<>(value, sentinel.next);
    }

    public void addLast(Item value) {
        size++;
        Node e = sentinel;
        while (e.next != null) {
            e = e.next;
        }
        e.next = new Node<>(value, null);
    }

    public Item getFirst() {
        return sentinel.next.value;
    }

    public Item getLast() {
        Node<Item> e = sentinel;
        while (e.next != null) {
            e = e.next;
        }
        return e.value;
    }

    public Item get(int i) {
        return get(i, sentinel.next);
    }

    private Item get(int i, Node<Item> n) {
        if (i == 0) {
            return n.value;
        } else {
            return get(i-1, n.next);
        }
    }

    public Item removeFirst() {
        size--;
        Node<Item> first = sentinel.next;
        sentinel.next = sentinel.next.next;
        return first.value;
    }

    public Item removeLast() {
        size--;
        Node<Item> current = sentinel.next;
        while (current.next.next != null) {
            current = current.next;
        }
        Item value = current.next.value;
        current.next = null;
        return value;
    }

    public Item remove(int i) {
        return remove(i, sentinel.next);
    }

    private Item remove(int i, Node<Item> n) {
        size--;
        Node<Item> current = n;
        Node<Item> prev = null;
        if (i == 0) {
            sentinel.next = sentinel.next.next;
            return current.value;
        }
        for (int j=0 ; j<=i ; j++) {
            if (i-j == 1) {
                prev = current;
            }
            else if (j == i) {
                prev.next = current.next;
                break;
            }
            current = current.next;
        }
        return current.value;
    }

    public static void main(String[] args) {
        SLList<String> slList = new SLList<>();
        slList.addFirst("first");
        slList.addLast("last");
        slList.addLast("newLast");
        System.out.println(slList.get(1));
    }
}
