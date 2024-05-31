public class StrukturQueue {
    private NodeQueue FRONT = null;
    private NodeQueue REAR = null;
    private int size;

    public boolean isEmpty() {
        return getFRONT() == null;
    }

    public NodeQueue getFRONT() {
		return FRONT;
		
	}

	public void setFRONT(NodeQueue fRONT) {
		FRONT = fRONT;
		
	}


    // Nambah Mahasiswa
	public void enqueue(Mahasiswa data) {
        NodeQueue newNode = new NodeQueue(data);
        if (isEmpty()) {
            setFRONT(newNode);
            REAR = newNode;
        } else {
            REAR.setNext(newNode);
            REAR = newNode;
        }
        size++;
    }


    // Penghapusan Mahasiswa
    public Mahasiswa dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong");
            return null;
        } else {
            Mahasiswa data = getFRONT().getData();
            setFRONT(getFRONT().getNext());
            size--;
            if (getFRONT() == null) {
                REAR = null;
            }
            return data;
        }
    }

    public int size() {
        return size;
    }


    // Menampilkan Semua Mahasiswa
    public void display() {
        if (isEmpty()) {
            System.out.print("Element queue: Element Kosong");
        } else {
            System.out.print("Elemen queue: ");
            NodeQueue curNode = getFRONT();
            while (curNode != null) {
                System.out.print(curNode.getData() + " ");
                curNode = curNode.getNext();
            }
        }
        System.out.println();
    }



    // Bagian Search Mahasiswa Berdasarkan NIM
    public Mahasiswa search(int nim) {
        NodeQueue curNode = getFRONT();
        while (curNode != null) {
            if (curNode.getData().getNim() == nim) {
                return curNode.getData();
            }
            curNode = curNode.getNext();
        }
        return null;
    }
}
