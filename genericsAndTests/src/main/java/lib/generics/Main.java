package lib.generics;

public class Main {
    public static void main(String[] args) {
        ScoreManager<Integer> sm = new ScoreManager<>();
        sm.addScore(100);
        sm.addScore(80);
        sm.addScore(90);
        System.out.println(sm.size());
        System.out.println(sm.getAverage());
        for(Integer score : sm) {
            System.out.println(score);
        }

    }
}