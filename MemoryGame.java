/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BrotherBear
 */
import java.util.*;
public class MemoryGame 
{
    public static void main (String [] args)
    {
       int[] randNums;
       int[] enteredNums;
       String[] numbers = {"one:   ","two:   ","three: ","four:  ","five:  ",
           "six:   ","seven: ","eight: ","nine:  ","ten:   "};
       int tempNum = 0;
       int difficulty = 0;
       int delay = 0;
       int score = 0;
       int incorrect = 0;
       int level = 1;
       Scanner kybd = new Scanner(System.in);
       while(true)
       {
            System.out.print(""
                    + "************************************\n"
                    + "*        Memory Testing Game       *\n"
                    + "************************************\n"
                    + "   Watch the numbers flash on the   \n"
                    + "  screen and try to memorise them.  \n"
                    + "************************************\n"
                    + "Difficulty Levels:\n"
                    + "1 - Beginner.   (1.50s delay.)\n"
                    + "2 - Very Easy.  (1.25s delay.)\n"
                    + "3 - Easy.       (1.00s delay.)\n"
                    + "4 - Medium.     (0.75s delay.)\n"
                    + "5 - Hard.       (0.50s delay.)\n"
                    + "6 - Very Hard.  (0.25s delay.)\n"
                    + "Please choose a difficulty (1-6): ");
            difficulty = kybd.nextInt();
            while(difficulty < 1 || difficulty > 6) // Check for valid entry.
            {
                System.out.print("Invalid entry. Please choose a difficulty (1-6): ");
                difficulty = kybd.nextInt();
            }
            delay = (7-difficulty)*250; // Calculate delay.
            System.out.printf("Difficulty level %d chosen. Press enter to begin.",difficulty);
            kybd.nextLine(); // Flush the nextInt() whitespace.
            kybd.nextLine();
            
            //GAME LOOP
            while(true)
            {
            randNums = new int[level];
            enteredNums = new int[level];
            for (int i = 0; i < level; i++){randNums[i] = (int)(Math.random()*10);}
            // FLASH NUMBERS
            for(int i = 0; i < level; i++)
            {
                System.out.print("Number " + numbers[i] + randNums[i]);
                try{Thread.sleep(delay);}
                catch(Exception e){}
                System.out.print("\r");
            }
            // ENTER NUMBERS
            System.out.println("Enter the numbers that appeared one by one.");
            
            for(int i = 0; i < level; i++)
            {
                System.out.print("What was number " + numbers[i]);
                tempNum = kybd.nextInt();
                while(tempNum < 0 || tempNum > 9)
                {
                    System.out.print("Invalid Entry: What was number " + numbers[i]);
                    tempNum = kybd.nextInt();
                }
                enteredNums[i] = tempNum;
            }
            // CHECK NUMBERS
            for(int i = 0; i < level; i++)
            {if(randNums[i] == enteredNums[i]){score++;}
            else{incorrect++;}}
            // DISPLAY NUMBERS
            if(level<10)
            {
                System.out.printf(""
                        + "************************************\n"
                        + "*          Your score: %2d          *\n"
                        + "************************************\n",score);

                System.out.print("Random Numbers: ");
                for(int i = 0; i < level; i++){System.out.print(randNums[i]);}
                System.out.print("\nYour Numbers:   ");
                for(int i = 0; i < level; i++){System.out.print(enteredNums[i]);}           
                System.out.printf("\nLevel %d complete. Press enter to continue.",level);            
		level++; 		
                kybd.nextLine();
                kybd.nextLine();
            }
            else
            {
                System.out.print("\n************************************\n"
                    + "Random Numbers: ");
                for(int i = 0; i < level; i++){System.out.print(randNums[i]);}
                System.out.print("\nYour Numbers:   ");
                for(int i = 0; i < level; i++){System.out.print(enteredNums[i]);}
                System.out.printf(""
                    + "\n************************************\n"
                    + "*    Score: %2d    Incorrect: %2d    *\n"
                    + "************************************\n\n",score,incorrect);
                level = 0;
                break;
            }
            }
        }
    }
}
