import java.util.Arrays;

public class CBusStop {
    protected String name;
    protected String[] changes;

    public CBusStop(String name) {
        this.name = name;
    }

    public CBusStop(String name, String... changes) {
        this.name = name;
        setChanges(changes);
    }

    public void setChanges(String[] changes) {
        int length = changes.length;
        this.changes =  new String[length];
        if(length > 0) {
            for(int i = 0; i < length; i++) {
                this.changes[i] = changes[i];
            }
        } else {
            this.changes = null;
        }
    }

    @Override
    public String toString() {
        return " Przystanek: " + name + ", Przesiadki: " + (((this.changes != null) ? Arrays.toString(changes) : "brak"));
    }



}
