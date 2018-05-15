import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest{
//    Test to check if program will instantiate squad correctly
    @Test
    public void Squad_instantiatesCorrectly_true() {
        Squad mySquad = new Squad("killersquad", "kill people",2);
        assertEquals(true, mySquad instanceof Squad);
    }

    //Test to check if Squad can be assigned a name
    @Test
    public void Squad_canBeAssignedName_String(){
        Squad mySquad = new Squad("killersquad", "kill people",2);
        assertEquals("killersquad", mySquad.getSquadName());
    }

    //Test to check if Squad Can be assigned a Cause
    @Test
    public void Squad_canBeAssignedCause_String(){
        Squad mySquad = new Squad("killersquad","kill people",2);
        assertEquals("kill people", mySquad.getSquadCause());
    }

    //Test to check if Squad can be assigned a size
    @Test
    public void Squad_canBeAssignedSize_String(){
        Squad mySquad = new Squad("killersquad","kill people",2);
        assertEquals(2, mySquad.getSquadSize());
    }

    //Test to return all instances of of Squad
    @Test
    public void all_returnsAllInstancesOfSquad_true(){
        Squad mySquad1 = new Squad("killersquad","kill people",2);
        Squad mySquad2 = new Squad("justice league","Destroy all the bad guys by putting them in Jail",7);
        assertEquals(true, Squad.all().contains(mySquad1));
        assertEquals(true, Squad.all().contains(mySquad2));
    }

    //Test to clear the list of all Squads
    @Test
    public void clear_emptiesAllSquadsFromArrayList_0(){
        Squad mySquad1 = new Squad("killersquad","kill people",2);
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }

    //Test of Assigning Unique Id
    public void getId_SquadsInstantiateWithId_1(){

        Squad.clear(); //To clear List for test to work

        Squad mySquad = new Squad("killersquad","kill people",2);

        assertEquals(1, mySquad.getId());

    }

    //Test for finding Specific object
    @Test
    public void squad_WillReturnSquadWithSameId_mySquad2(){
        Squad mySquad1 = new Squad("killersquad","kill people",2);
        Squad mySquad2 = new Squad("justice league","Destroy all the bad guys by putting them in Jail",7);
        assertEquals(Squad.find(mySquad2.getId()), mySquad2);
    }

}