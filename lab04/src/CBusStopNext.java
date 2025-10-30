public class CBusStopNext extends CBusStop {
    protected int nextMeters = 0;
    protected float nextMinutes = 0.0f;

   public CBusStopNext(String name, int nextMeters, float nextMinutes, String ... changes) {
       super(name, changes);
       this.nextMeters = nextMeters;
       this.nextMinutes = nextMinutes;
   }

   public CBusStopNext(String name, int nextMeters, float nextMinutes) {
       super(name);
       this.nextMeters = nextMeters;
       this.nextMinutes = nextMinutes;
   }

    public int getNextMeters() {
        return nextMeters;
    }

    public float getNextMinutes() {
        return nextMinutes;
    }

    public void setNextMeters(int nextMeters) {
        this.nextMeters = nextMeters;
    }

    public void setNextMinutes(float nextMinutes) {
        this.nextMinutes = nextMinutes;
    }

    @Override
    public String toString() {
       return super.toString() + ", następny przystanek: " + nextMeters + "m, " + nextMinutes + " minut";
    }
}
