public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem next) {
        this.rightLink = next;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem previous) {
        this.leftLink = previous;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if(this.value instanceof Comparable && item.getValue() instanceof Comparable) {
            Comparable thisVal = (Comparable) this.value;
            Comparable otherVal = (Comparable) item.getValue();
            return thisVal.compareTo(otherVal);
        } else {
            throw new IllegalArgumentException("Values must be Comparable");
        }
    }
}
