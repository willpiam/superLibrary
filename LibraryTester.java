/**
 * program is to test library
 * library is to simplify programming and help study for final exam
 * my name is william 
 * date: june 26th 2017 
 */

//import superLibrary;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
/**
 *
 * @author william
 */
public class LibraryTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        superLibrary funTimes = new superLibrary(); //ties to library
        //test print 
        funTimes.print("william");//print function test
        //test getTimeInMillis
        System.out.println(funTimes.getTimeInMillis());//time since 1970 function
        //test getTime
        System.out.println(funTimes.getTime());//date function
        
        int listLength = 1000;//how long should list be 
        
        int list[] = new int [listLength];//makes a list
        
        for (int i = 0; i < list.length; i++){
            list[i]= funTimes.randomInt(0,1000);//loop writes random numbers to list
            System.out.print(list[i]+",");//prints list nicly
        }
        
        System.out.println("");//formating
        
        int newList[] = new int [listLength];//to hold sorted list
        
        newList = funTimes.bubbleBigToSmall(list);//sorts list and saves it as newList
        
        for (int i = 0; i < list.length; i++){
            System.out.print(newList[i]+",");//prints sorted list
        }
        
        //test isEven
        int num1 = 9878872;
        System.out.println("");
        System.out.println(funTimes.isEven(num1));
        
        System.out.println("");
        System.out.println("");
        //test random number generator
        System.out.println(funTimes.randomInt(0,10000));
        
        //test single line writer
        funTimes.writeSingle("test.txt", "this is only a test");
        
        //test getFile length
        System.out.println(funTimes.fileLength("test.txt"));
        
        //TEST addLine
        
        funTimes.addLine("test.txt", "this is but a test fello spock'");
        
        System.out.println(funTimes.fileLength("test.txt"));
    }
    
}
