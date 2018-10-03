public class Main<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public Main() //Initialize list with a head that is followed by a tail, with null data
    {
        head = new Node<>(null,null,null);
        tail = new Node<>(null,null,head);
        head.setNext(tail);
    }

    private void insertNode(E data, Node<E> next, Node<E> previous)
    {
        if(searchList(data) == null)
        {
            Node<E> newNode = new Node<>(data, next, previous);
            next.setPrev(newNode);
            previous.setNext(newNode);
            size++;
        }
        else
        {
            System.out.println("Duplicate Key");
        }
    }

    public void addFirst(E data)
    {
        insertNode(data, head.next, head);
    }

    public void addLast(E data)
    {
        insertNode(data, tail, tail.previous);
    }

    public void removeNode(E data)
    {
        if(searchList(data) == null)
        {
            System.out.println("Not found");
        }
        else
        {
            Node<E> node = searchList(data);
            remove(node);
        }
    }

    public void printList()
    {
        Node<E> temp = head.next;
        while (temp != null && temp != tail)
        {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
    }

    private Node<E> searchList(E data)
    {
        Node<E> temp = head;
        while (temp != null)
        {
            if(temp.getData() != data)
            {
                temp = temp.getNext();
            }
            else
            {
                return temp;
            }
        }
        return null;
    }

    private E remove(Node<E> node)
    {
        Node<E> next = node.getNext();
        Node<E> previous = node.getPrev();
        next.setPrev(previous);
        previous.setNext(next);
        size--;
        return node.getData();
    }

    public class Node<E>
    {
        private E data;
        private Node<E> next;
        private Node<E> previous;

        public Node(E data, Node<E> next, Node<E> previous)
        {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        public Node<E> getNext()
        {
            return this.next;
        }

        public Node<E> getPrev()
        {
            return this.previous;
        }

        public void setNext(Node<E> next)
        {
            this.next = next;
        }

        public void setPrev(Node<E> previous)
        {
            this.previous = previous;
        }

        public E getData()
        {
            return this.data;
        }
    }













    public static void main(String[] args)
    {
        Main<Integer> dll = new Main<Integer>();
        //System.out.println("Before Operations");
        //dll.printList();
        String input = "1.in 3.in 5.in 3.del 2.in 1.sch 1.in 8.in 9.in 12.in 11.in";
        String[] arrofOps = input.split(" ");
        for(String a : arrofOps)
        {
            String[] split = a.split("\\.");
            //System.out.println(split[1]);
            if(split[1].equals("in"))
            {
                //System.out.println("Adding " + split[1]);
                dll.addFirst(Integer.parseInt(split[0]));
            }
            if(split[1].equals("del"))
            {
                //System.out.println("Removing " + split[1]);
                dll.removeNode(Integer.parseInt(split[0]));
            }
            if(split[1].equals("sch"))
            {
                if(dll.searchList(Integer.parseInt(split[0])) == null)
                {
                    System.out.println("Not Found");
                }
                else
                {
                    System.out.println("Found");
                }
            }
        }
        System.out.print("List After Operations: ");
        dll.printList();
    }
}
