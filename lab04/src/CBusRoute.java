import java.util.ArrayList;
import java.util.List;

public class CBusRoute {
    public static String COMPANY = "MPK Krakow";
    private int number;
    private List<CBusStop> route = new ArrayList<>();

    public CBusRoute(int number) {
        this.number = number;
    }

    public void addBusStop(String name) {
        route.add(new CBusStop(name));
    }


    public void addBusStop(String name, String ... changes) {
        route.add(new CBusStop(name, changes));
    }

    public void addBusStop(String name, int nextMeters, float nextMinutes) {
        route.add(new CBusStopNext(name, nextMeters, nextMinutes));
    }

    public void addBusStop(String name, int nextMeters, float nextMinutes, String ... changes) {
        route.add(new CBusStopNext(name, nextMeters, nextMinutes, changes));
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(" POJAZD NR.%d. Przewoznik: %s. Trasa:\n",this.number,COMPANY));

        for(Object bs: route){
            sb.append(bs.toString()).append("\n");
        }
        return sb.toString();
    }
}
