/**
 * superLibrary should include many subroutines to make programming easier
 * will include things like:
 * -quick print
 * -read file
 * -write file
 * -get file length
 * -various sorting methouds
 * -get system time
 * -get system time in millaseconds
 * -convert anything to a string
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Calendar;//used for system time
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
/**
 *
 * @author william
 */
public class superLibrary {
    
    public static void print(String toPrint){//prints a given string
        /**
         * UPDATES TO MAKE: 
         * 
         */
        System.out.println(toPrint);
    }//end print (WORKING)
    
    public static long getTimeInMillis(){//returns date and time
        Calendar cal = Calendar.getInstance();//grabs the time from the system
        Long time = cal.getTimeInMillis();
        return time;
    }//end getTimeInMillis (WORKING)
    
    public static Date getTime(){
        Calendar cal = Calendar.getInstance();//grabs the time from the system
        Date time = cal.getTime();
        return time;
    }//end get time (WORKING)
    
    public static int[] bubbleSort(int unSorted[]){//bubble sort
        //get array length
        int len = unSorted.length;
        int temp;
        //start the sort
        for (int i = 1; i < len; i++){
            for (int k = 0; k < len -1; k++){
                if (unSorted[k] > unSorted[k+1]){
                    //switch(unSorted[k],unSorted[k+1]);//this would be a lovely way of doing it
                    temp = unSorted[k];
                    unSorted[k] = unSorted[k+1];
                    unSorted[k+1] = temp;
                }//end first if statment
            }//end k loop
        }//end i loop
        return unSorted;//returns sorted list... I know... this is an example of a bad choice of variable name... no I'm not going to change it 
    }//end bubbleSort(WORKING)
    
    public static int[] bubbleSmallToBig(int unSorted[]){//smallest bubble to the top (sorts)
        //get array length
        int len = unSorted.length;
        int temp;
        //start the sort
        for (int i = 1; i < len; i++){
            for (int k = 0; k < len -1; k++){
                if (unSorted[k] > unSorted[k+1]){
                    //switch(unSorted[k],unSorted[k+1]);//this would be a lovely way of doing it
                    temp = unSorted[k];
                    unSorted[k] = unSorted[k+1];
                    unSorted[k+1] = temp;
                }//end first if statment
            }//end k loop
        }//end i loop
        return unSorted;
    }//end bubblesmallToBig (WORKING)
       
    public static int[] bubbleBigToSmall(int unSorted[]){//biggest bubble to top (sorts)
        //get array length
        int len = unSorted.length;
        int temp;
        //start the sort
        for (int i = 1; i < len; i++){
            for (int k = 0; k < len -1; k++){
                if (unSorted[k] < unSorted[k+1]){
                    //switch(unSorted[k],unSorted[k+1]);//this would be a lovely way of doing it
                    temp = unSorted[k];
                    unSorted[k] = unSorted[k+1];
                    unSorted[k+1] = temp;
                }//end first if statment
            }//end k loop
        }//end i loop
        return unSorted;
    }//end bubble big to small (WORKING)
        
    public static int randomInt (int lowerLimit, int upperLimit){//sub returns a random value between a given upper and lower limit
       int randomInt = ThreadLocalRandom.current().nextInt(lowerLimit ,upperLimit);//random int between lower and upper limits      
       return randomInt;
    }//end randomInt    (WORKING)
    
    public static boolean isEven(int num){//returns true if num is even
        //convert num to string
        String sNum = String.valueOf(num);
        System.out.println("string: " +sNum);
        //grab the last charecter of sNum
        char lastLetter = sNum.charAt(sNum.length() - 1);
        System.out.println("Char last: " +lastLetter);
        //convert last letter back into int
        int intLastLetter = Character.getNumericValue(lastLetter);
        
        //if intLastLetter ends with an even number it itself must be even
        System.out.println("as int last: "+intLastLetter);
        if (intLastLetter == 1 | intLastLetter == 3 | intLastLetter == 5 | intLastLetter == 7 | intLastLetter == 9){
            return false;
        }
        else{return true;}
    }//end isEven (WORKING)
    
    public static void writeSingle(String fileName , String toWrite){//sub writes a single line to any file
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");//opens folder.. if folder does not excist it creates one
            writer.println(toWrite);               
            writer.close();//closes file
            }
        catch (IOException e) {
            // do something
        }//end catch
    }//end writeSingle      (working)
    
    public static int fileLength(String fileName){//will be used to get the length of a file
         //code borrowed from: mkyong.com/java/how-to-get-the-total-number-of-lines-of-a-file-in-java/
        int linenumber = 0;//needed to declare this outside of try/if for some reason probibly because java thinks those things may never assign it a value
        try{
            File file = new File(fileName);// there is a file, lets call it "file", it is found at fileName
            if (file.exists()){//if there really is a file at that spot do this
                FileReader fr = new FileReader(file);
                LineNumberReader lnr = new LineNumberReader(fr);//lnr stands for Line Number Reader
               
                linenumber = 0;//we have not started counting lines yet so we set this to zero
                while (lnr.readLine() != null){//as long as we're still getting lines with data (any thing askii) keep looping
                    linenumber++;//add one to your line count
                }
                // System.out.println("Total number of lines:"+ linenumber);//for testing
                lnr.close();//no point leaving the file open
            }//END IF \
            else{//if there is no file at that spot tell the user how bad of a programmer i am
                System.out.println("OMG! ERROR! file cound not be found");
            }//end else
           
        }
        catch(IOException e){//if something terrable happens
            e.printStackTrace();//gives debugging information
        }
        return linenumber;//returns the number of lines
    }//end fileLength()     (WORKING)
    
    public static void addLine(String fileName, String toAppend){//sub will be responsable for appending line to data file
        //get data file as list
        String oldFile[] = grabFile(fileName);
        //get length of data file
        int oldLength = fileLength(fileName);
        //new length = length +1
        int newLength = oldLength +1;
        //create list of new length
        String newList[] = new String[newLength];
        //right all the lines of the old list to the new list (leave the last spot empty)
        for (int i = 0; i<oldLength; i++){//i is 0, keep going untill i is not less than oldLength, every loop increase i by one
            newList[i]= oldFile[i];
        }
        //put the appended thing into the last spot 
        newList[newLength-1] = toAppend;
        //rewrite the data file with our new list
        writeList(fileName, newList);
    }//end addLine      (WORKING)
    
    public static String[] grabFile(String fileName/*UPDATE NEEDED: use fileLength function*/){
        //!!!get length of data file as linenumber
        //code borrowed from: mkyong.com/java/how-to-get-the-total-number-of-lines-of-a-file-in-java/
        int linenumber = 0;//needed to declare this outside of try/if for some reason probibly because java thinks those things may never assign it a value
        try{
            File file = new File(fileName);// there is a file, lets call it "file", it is found at fileName
            if (file.exists()){//if there really is a file at that spot do this
                FileReader fr = new FileReader(file);
                LineNumberReader lnr = new LineNumberReader(fr);//lnr stands for Line Number Reader
               
                linenumber = 0;//we have not started counting lines yet so we set this to zero
                while (lnr.readLine() != null){//as long as we're still getting lines with data (any thing askii) keep looping
                    linenumber++;//add one to your line count
                }
                // System.out.println("Total number of lines:"+ linenumber);//for testing
                lnr.close();//no point leaving the file open
            }//END IF \
            else{//if there is no file at that spot tell the user how bad of a programmer i am
                System.out.println("OMG! ERROR! file cound not be found");
            }//end else
           
        }
        catch(IOException e){//if something terrable happens
            e.printStackTrace();//gives debugging information
        }
        //!!!create list of that length
        String fileLines[] = new String[linenumber];
        //!!!take data from data file and put each line into list
        try{
            FileReader file = new FileReader(fileName);//open file
            BufferedReader buffer = new BufferedReader(file);
            for (int i=0;i<linenumber; i++){//start i at zero, increase by one each time, stop when i lis not less than the amount of lines
                fileLines[i] = buffer.readLine();
            }//end i loop
            buffer.close();
        }
        catch(IOException e){
            System.out.println ("Sorry, the file was not found (was looking to read).");
        } 
        //return list
       
        return fileLines;
    }//end grabFile     (WORKING)
    
    public static void writeList(String fileName, String toWrite[]){//writes a list to a file
        int length = toWrite.length;//gets length of file as length
        //open file
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");//opens folder.. if folder does not excist it creates one
            for (int i = 0; i<length; i++){//loop as long as the lenght of the list
                 writer.println(toWrite[i]);
            }//end for i loop
            writer.close();//closes file
           }
            catch (IOException e) {}//end catch
       
       
       
    }//end writeList()      (WORKING)
}
/**
 * THINGS TO ADD
 * bogosort
 * quick sort
 * open file and return contents as list
 * file appender (does not over write previous lines in the file simply adds text to botom of file)
 */