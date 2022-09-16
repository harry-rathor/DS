package ds;

import java.util.*;

public class Alt {
    //hackathon,
    // user -
    // 3 pref - to member 1,2,3
    //

    // T1 - 1,2,3
    // T2 - 1,2,

    // .1,.3.,.5



    public static void main(String[] args) {

        vote v1=new vote(1,2,3);//t1

        vote v2=new vote(1,3,2);//t2

        vote v3=new vote(0,3,2);//t1

        Map<String,ArrayList<vote>> teams=new HashMap<>();


        String teamName="t1";
        ArrayList<vote> vList=new ArrayList<>();
        if(teams.containsKey(teamName)) {
            vList = teams.get(teamName);
        }
        vList.add(v1);


         teamName="t2";
        vList=new ArrayList<>();
        if(teams.containsKey(teamName)) {
            vList = teams.get(teamName);
        }
        vList.add(v2);
        teams.put(teamName,vList);


        teamName="t1";
        vList=new ArrayList<>();
        if(teams.containsKey(teamName)) {
            vList = teams.get(teamName);
        }
        vList.add(v3);

        teams.put(teamName,vList);

        // score calculation

        ArrayList<TeamScore> teamScore=new  ArrayList<TeamScore> ();

        for (Map.Entry<String,ArrayList<vote>> entry:teams.entrySet()){
            double score=0;
             for( vote v: entry.getValue()){
                 if(v.getP1()>0)
                 score+=v.getP1()*1;
                 if(v.getP3()>0)
                 score+=v.getP2()*.5;
                 if(v.getP2()>0)
                 score+=v.getP3()*.3;
             }
            teamScore.add(new TeamScore(entry.getKey(),score));
        }

        Collections.sort(teamScore);

        System.out.println(teamScore);
        System.out.println("Winner of hackthon: "+teamScore.get(0));

    }

    static class TeamScore implements Comparable<TeamScore>{
        String teamName;
        double score;

        public TeamScore(String teamName, double score) {
            this.teamName = teamName;
            this.score = score;
        }

        @Override
        public int compareTo(TeamScore o) {
            return (int) (o.score-this.score);
        }

        @Override
        public String toString() {
            return "TeamScore{" +
                    "teamName='" + teamName + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
    static class vote {

        int p1;
        int p2;
        int p3;
        public vote( int p1, int p2, int p3) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;

        }

        public int getP1() {
            return p1;
        }

        public int getP2() {
            return p2;
        }

        public int getP3() {
            return p3;
        }
    }
}
