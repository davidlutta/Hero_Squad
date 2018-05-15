import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String mHeroName;

    private String mHeroPower;

    private int mHeroAge;

    private String mHeroWeakness;

    private static List<Hero> heroList = new ArrayList<>();

    private int mID;


    public Hero(String heroName, String heroPower, int heroAge, String heroWeakness){

        mHeroName = heroName;

        mHeroPower = heroPower;

        mHeroAge = heroAge;

        mHeroWeakness = heroWeakness;

        heroList.add(this);

        mID = heroList.size();

    }

    //Method to get Hero Name
    public String getHeroName() {

        return mHeroName;

    }

    //Method to get hero Power
    public String getHeroPower(){

        return mHeroPower;

    }

    //Method to get Hero Age
    public int getHeroAge(){

        return mHeroAge;

    }

    //Method to return all heros in the list
    public static List<Hero> getHeroList() {

        return heroList;

    }

    //Method for getting hero Weakness
    public String getHeroWeakness(){

        return mHeroWeakness;

    }

    //Method to clear heros from ArrayList
    public static void clear(){

            heroList.clear();

            }

        //Method for instantiating with Id
    public int getId() {

        return mID;

    }

    //Method for Finding Specific Id
    public static Hero find(int id){

        return heroList.get(id - 1);
    }
}
