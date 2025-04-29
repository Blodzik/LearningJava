public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // The list was empty, so this item becomes the root
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);

            if (comparison < 0) {
                // newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // No next, insert here
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less, insert before currentItem
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    // currentItem is the root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // Equal, do not add
                System.out.println(newItem.getValue() + " is already present.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null) return false;

        ListItem currentItem = this.root;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // Found the item to remove
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                    if (this.root != null) {
                        this.root.setPrevious(null);
                    }
                } else {
                    ListItem prev = currentItem.previous();
                    ListItem next = currentItem.next();
                    prev.setNext(next);
                    if (next != null) {
                        next.setPrevious(prev);
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {
                // Item not found
                return false;
            }
        }

        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
