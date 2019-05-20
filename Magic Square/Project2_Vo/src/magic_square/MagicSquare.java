/**
 * Magic Square
 * The objective of the project is to create a program to help the user create a
 * magic square. The magic square is a a grid of number where each row, column,
 * and diagonal add up to the same number. The program will first ask the user for
 * the size of the magic square. The program then displays the empty magic square.
 * Then it will ask the user for the row and column number. Then ask the user for
 * a value to put there. After this, the programs displays what the magic square
 * looks like. It will then repeat this process over and over until each row, column,
 * and diagonal is equal to the same number and displays "Victory!".
 */
package magic_square;

import java.util.Scanner;


public class MagicSquare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Ask for user's input for the size of the magic square.
        System.out.print("Let's make a Magic Square! How big should it be? ");
        int size = input.nextInt();
        //This while loop prevents the user from inputing incorrect values. If
        //the user enters a size that is below 3 or 9 higher than 9, the program will
        //output an error message and asks the user re-input the size of the square.
        while (size <= 2 || size >= 9) {
            if (size <= 2) {
                System.out.println("That would violate the laws of mathematics!\n");
                System.out.print("Let's make a Magic Square! How big should it be? ");
                size = input.nextInt();
            } else if (size >= 9) {
                System.out.println("That's huge! Please enter a number less than 9.\n");
                System.out.print("Let's make a Magic Square! How big should it be? ");
                size = input.nextInt();
            }
        }
        //Once the user inputs the correct size between 2 and 9, the system will
        //output "Great!"
        if (size < 9 && size > 2) {
            System.out.println("Great!");
            System.out.println("");
        }
        //The input value for the size is then the size of a two dimensional 
        //array called magicSquare. 
        int[][] magicSquare = new int[size][size];
        //The two dimensional array is then outputed to show the current
        //form of the magic square.
        System.out.println("The square currently looks like this:");
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                System.out.print(magicSquare[row][column] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        //Variables are intalized. The constant variable is the number that each
        //row, column, and diagonal should equal to. The constant variable is dependent
        //on the size variable. So depending on the size of the magic square
        //the constant will change.
        int constant = (size * (size * size + 1)) / 2;
        int diagonal1 = 0;
        int diagonal2 = 0;
        int rowTotal = 0;
        int columnTotal = 0;
        int rowCount = 0;
        int columnCount = 0;

        //This while loop will keep on repeating, asking the user for a value for each row
        // and column until all the rows, columns, and diagonals are equal to each other.
        //It will print the magic square out and proceeds to ask the questions again.
        //This while loop will end when diagonal1 and diagonal2 are equal to constant and 
        //the rowCount and columnCount are both equal to the size. 
        while (!(diagonal1 == constant && diagonal2 == constant && rowCount == size && columnCount == size)) {
            //Asks the user for a row number.
            System.out.println("Where do you want to put a new value?");
            System.out.print("Row: ");
            int choiceRow = input.nextInt();
            //If the row number is below 0 or higher or equal the size variable, 
            //the program will output and error message and ask the user to 
            //re-enter the row number.The while loop will keep on repeating until
            //the user enters the correct number.
            while (choiceRow < 0 || choiceRow >= size) {
                System.out.printf("You can only use numbers between 0 and %d\n", size - 1);
                System.out.print("Re-enter Row: ");
                choiceRow = input.nextInt();
            }

            //Asks user for column number.
            System.out.print("Column: ");
            int choiceColumn = input.nextInt();
            //If the column number is below 0 or higher or equal the size variable, 
            //the program will output and error message and ask the user to 
            //re-enter the column number.The while loop will keep on repeating until
            //the user enters the correct number.
            while (choiceColumn < 0 || choiceColumn >= size) {
                System.out.printf("You can only use numbers between 0 and %d\n", size - 1);
                System.out.print("Re-enter Column: ");
                choiceColumn = input.nextInt();
            }
            //After asking the user for row and column number, the program will output 
            //and ask for a value to go there.
            System.out.print("What value should go there? ");
            //The limit variable will determine what is the largest value that is 
            //allowed to be in the magic square.
            int limit = size * size;
            int value = input.nextInt();
            //The if statement here checks the value entered for the magic square if it 
            //is below 1 or higher than the limit allowed. If it is below 1 or higher than
            //the limit, the system will output an error message. 
            if (value < 1 || value > limit) {
                System.out.println("You can only use numbers between 1 and " + limit + " for this square.");
            } else {
                //This for loop goes throug all the values in the magic square to check
                //if the value entered by the user is repeated. If the user enters
                //a value that was repeated, the program will output an error message
                //and set the value equal to -1, so that the value won't be entered
                //into the magic square.
                for (int row = 0; row < size; row++) {
                    for (int column = 0; column < size; column++) {
                        if (value == magicSquare[row][column]) {
                            System.out.println("You can only use this number once.");
                            value = -1;
                        }

                    }
                }
            }
            //Once the value went through all the checks for its value, if the value
            //is then between 1 and the limit. The value will be put into the magic
            //square at whatever row and column inputed by the user.
            if (!(value < 1 || value > limit)) {
                magicSquare[choiceRow][choiceColumn] = value;
            }
            //After entering the new value into the magic square, the program will
            //output a new magic square.
            System.out.println("");
            System.out.println("The square currently looks like this:");
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    System.out.print(magicSquare[row][column] + " ");
                }
                System.out.println("");
            }
            System.out.println("");

            //The variable diagonal1 will keep the total of the diagonal from the 
            //top left corner to the bottom right corner.
            diagonal1 = 0;
            //This for loop will add up the total of the values of the diagonal in 
            //the top left corner to the bottom right corner of the magic square.  
            for (int i = 0; i < size; i++) {
                diagonal1 += magicSquare[i][i];
            }
            //The variable diagonal2 will keep the total of the diagonal from the 
            //bottom left corner to the top right corner.
            diagonal2 = 0;
            int diagonalColumn = 0;
            //This for loop will add up the total of the values of the diagonal in 
            //the bottom left corner to the top right corner of the magic square.  
            for (int row = size - 1; row >= 0; row--) {
                diagonal2 += magicSquare[row][diagonalColumn];
                diagonalColumn++;
            }

            rowCount = 0;
            //This for loop will check if each row is equal to the constant, If it 
            //is, the rowCount will then go up. The rowCount variable is used to check
            //if all the rows are equal to each other. If rowCount is equal to the size
            //then this means all the rows are equal to each other. 
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    rowTotal += magicSquare[row][column];
                }
                if (rowTotal == constant) {
                    rowCount++;
                }
                rowTotal = 0;
            }

            columnCount = 0;
            //This for loop will check if each column is equal to the constant, If it 
            //is, the columnCount will then go up. The columnCount variable is used to check
            //if all the columns are equal to each other. If columnCount is equal to the size
            //then this means all the columns are equal to each other. 
            for (int column = 0; column < size; column++) {
                for (int row = 0; row < size; row++) {
                    columnTotal += magicSquare[row][column];
                }
                if (columnTotal == constant) {
                    columnCount++;
                }
                columnTotal = 0;
            }
        }
        //The program will print out "Victory!" once the while loop ends. When the while
        //loop ends, it means that all the rows, columns, and diagonals are equal to each other.
        System.out.println("Victory!");
        input.close();
    }

}
