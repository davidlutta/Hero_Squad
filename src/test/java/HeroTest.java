import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class HeroTest {

    //Test to check if program will instantiate hero correctly
    @Test
    public void Hero_istantiatesCorrectly_true(){

        Hero myHero = new Hero("Batman","intelligence", 44,"bullets");

        assertEquals(true, myHero instanceof Hero);

    }

    //Test to check if Hero can be assigned a name
    @Test
    public void Hero_canBeAssignedName_String(){

        Hero myHero = new Hero("Batman","intelligence", 44,"bullets");

        assertEquals("Batman", myHero.getHeroName());

    }

    //Test to check if Hero can be assigned a Power
    @Test
    public void Hero_canBeAssignedAPower_String(){

        Hero myHero = new Hero("Batman", "intelligence", 44,"bullets");

        assertEquals("intelligence", myHero.getHeroPower());

    }

    //Test to check if Hero can be assigned a Weakness
    @Test
    public void Hero_canBeAssignedAWeakness_String(){

        Hero myHero = new Hero("Batman", "intelligence", 44,"bullets");

        assertEquals("bullets", myHero.getHeroWeakness());

    }

    //Test to check if Hero can be assigned an Age
    @Test
    public void Hero_canBeAssignedAnAge(){

        Hero myHero = new Hero("Batman","intelligence", 44,"bullets");

        assertEquals(44, myHero.getHeroAge());

    }

    //Test to return all instances of of Squad
    @Test
    public void all_returnsAllInstancesOfSquad_true(){

        Hero myHero1 = new Hero("Batman","intelligence",44,"bullets");

        Hero myHero2 = new Hero("Black Panther","super speed",28,"love");

        assertEquals(true, Hero.getHeroList().contains(myHero1));

        assertEquals(true, Hero.getHeroList().contains(myHero2));


        }
    //Test to clear the list of all Squads
    @Test
    public void clear_emptiesAllSquadsFromArrayList_0(){

        Hero myHero = new Hero("Batman","intelligence",44,"bullets");

        Hero.clear();

        assertEquals(Hero.getHeroList().size(), 0);

    }

    //Test of Assigning Unique Id
    public void getId_SquadsInstantiateWithId_1(){

        Hero.clear(); //To clear List for test to work

        Hero myHero = new Hero("Batman","intelligence",44,"bullets");

        assertEquals(1, myHero.getId());

    }

    //Test for finding Specific object
    @Test
    public void squad_WillReturnSquadWithSameId_mySquad2(){

        Hero Hero1 = new Hero("Batman","intelligence",44,"bullets");

        Hero myHero2 = new Hero("Black Panther","super speed",28,"love");

        assertEquals(Hero.find(myHero2.getId()), myHero2);

    }

}
