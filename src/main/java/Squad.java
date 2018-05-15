import java.util.ArrayList;

import java.util.List;

public class Squad {

    private String mSquadName;

    private String mSquadCause;

    private int mSquadSize;

    private static List<Squad> instances = new ArrayList<>();

    private List<Hero> mHeros;

    private int mID;

    public Squad(String squadName, String squadCause, int squadSize){

        mSquadName = squadName;

        mSquadCause = squadCause;

        mSquadSize = squadSize;

        instances.add(this);

        mID = instances.size();

        mHeros = new ArrayList<>();

    }

    //Method to get Squad Name
    public String getSquadName(){

        return mSquadName;

    }

    //Method to get Squad Cause

    public String getSquadCause() {

        return mSquadCause;

    }

    //Method to get Squad Size

    public int getSquadSize() {

        return mSquadSize;

    }

    //Method to return all instances
    public static List<Squad> all() {

        return instances;

    }

    //Method to clear instances from ArrayList
    public static void clear(){

        instances.clear();

    }

    //method for instantiating with ID

    public int getId() {

        return mID;

    }

    //Method for finding specific ID
    public static Squad find(int id){

        return instances.get(id - 1);

    }

    //Method to add heros to our Squads Array
    public void addHero(Hero hero){

        mHeros.add(hero);

    }
}