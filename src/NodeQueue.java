public class NodeQueue {
    Mahasiswa data;
    NodeQueue next;

    NodeQueue(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }

    public Mahasiswa getData() {
        return data;
    }

    public NodeQueue getNext() {
        return next;
    }

    public void setNext(NodeQueue next) {
        this.next = next;
    }
}
