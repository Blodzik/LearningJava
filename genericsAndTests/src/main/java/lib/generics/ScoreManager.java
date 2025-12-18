package lib.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScoreManager<T extends Number> implements Iterable<T> {
    private List<T> scores;
    private String managerName;

    public ScoreManager() {
        scores = new ArrayList<>();
    }

    public ScoreManager(List<T> scores) {
        this.scores = new ArrayList<>(scores);
    }

    public void addScore(T score) {
        double value = score.doubleValue();
        if(value >= 0 && value <= 100)
         {
            scores.add(score);
        } else {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }

    public double getAverage() {
        if(scores.isEmpty()) {
            throw new IllegalArgumentException("No score found");
        }
        double sum = 0.0;
        for(T score : scores) {
            sum += score.doubleValue();
        }
        return sum / scores.size();
    }

    public int size() {
        return scores.size();
    }

    @Override
    public Iterator<T> iterator() {
        return scores.iterator();
    }

}
