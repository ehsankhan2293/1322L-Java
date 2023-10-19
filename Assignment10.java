import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Java program to read the RawGradesFile.txt and to find
 * the average grade for the quiz, test and final exam.
 * The final results will be saved in a file named FinalGradesFile.txt
 * and the error data will be saved in ErrorGradesFile.txt
 * @author
 */
public class Assignment10 {
    // Buffered Writer instance for writing the error
    // file and final grade file
    private static BufferedWriter errorGradeWriter= null,finalGradeWriter= null;
    // scanne rto read the input file
    private static Scanner fileScanner = null;
    // scanner to read the command line inputs
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Utility function to close all writer
     * instances and scanner instances
     */
    private static void closeFiles() {
        try {
            if (errorGradeWriter!=null) {
                errorGradeWriter.close();
            }
            if (finalGradeWriter!=null) {
                finalGradeWriter.close();
            }
            scanner.close();
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Utility function to find the grade letter, for the
     * given average value
     * @param average
     * @return String
     */
    private static String getGradeLetter(double average) {
        String letter = "";
        if (average >=89.5) {
            letter = "A";
        }
        else if (average>=79.5 && average <89.5) {
            letter = "B";
        }
        else if (average>=69.5 && average <79.5) {
            letter = "C";
        }
        else if (average>=59.5 && average <69.5) {
            letter = "D";
        }
        else {
            letter = "F";
        }
        return letter;
    }

    //DRIVER CODE
    public static void main(String[] args) {
        System.out.print("Enter name of input file: ");
        String fileName  = scanner.next();

        // read the input file name from command line
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error: System.IO.FileNotFoundException: "
                    + "Could not find file...");
        }
        // initiate the writer instances of the Finalgradesfile.txt
        // and ErrorGradesFile.txt
        try {
            finalGradeWriter = new BufferedWriter(
                    new FileWriter(new File("FinalGradesFile.txt")));
            errorGradeWriter = new BufferedWriter(
                    new FileWriter(new File("ErrorGradesFile.txt")));

            // read each line of input file
            while(fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                // split the line into words using comma
                String[] words = line.split(",");
                int wc = 0; // word counter
                String name = ""; // variable to student name
                long id = 0; // variable to hold student id
                Double grades[] = new Double[10]; // holds the grades
                double test1=0.00, test2=0.00, finalExam =0.00; // tests
                int gc = 0; // grade counter
                boolean validData = true; // flag for checking valid row or not
                double lowest = 1000; // lowest grade value
                int lowestIndex = -1; // lowest grade value index in array
                for (String word :words) {
                    if (wc==0) {
                        name = word;
                    }
                    else if (wc==1) {
                        // skip records with invalid student id
                        if (word.equals(" ")) {
                            errorGradeWriter.write(line + "\n");
                            validData = false;
                            break;
                        }
                        else {
                            id = Long.parseLong(word);
                        }
                    }
                    // populate the  quiz grade values
                    else if (wc>=2 && wc<=11) {
                        grades[gc] = Double.parseDouble(word);
                        if (grades[gc] < lowest) {
                            lowest = grades[gc];
                            lowestIndex = gc;
                        }
                        gc++;
                    }
                    // populate the test grades
                    else if (wc==12) { // test1
                        test1 = Double.parseDouble(word);
                    }
                    else if (wc==13) { // test2
                        test2 = Double.parseDouble(word);
                    }
                    else if (wc==14) { // final exam
                        finalExam = Double.parseDouble(word);
                    }
                    wc++;
                }
                if (!validData) {
                    continue;
                }
                //if one of the test grades are missing,
                //assign it with final exam
                if (words.length == 14) {
                    finalExam = test2;
                }
                if (words.length == 13) {
                    finalExam = test1;
                    test2 = test1;
                }

                // calculate the quiz grades
                // by dropping the lowest grade value
                double quizTotal = 0.0;
                for (int i =0; i <10;i++) {
                    if (i!=lowestIndex) {
                        quizTotal += grades[i];
                    }
                }

                // find the average quiz for 9/10 grades,
                // since we have skipped the lowest
                double quizAvg = (quizTotal / 9) * 0.25;

                // assign the final exam grade to test1, if test1 < final exam
                if (test1 >= 0 && test2 >= 0 && finalExam >=0 && finalExam > test1) {
                    test1 = finalExam;
                }
                // assign the final exam grade to test2, if test2 < final exam
                else {
                    if (test1 >= 0 && test2 >= 0 && finalExam >=0 && finalExam > test2) {
                        test2 = finalExam;
                    }
                }
                // calculate the grade average, by skipping the -1 grade values
                double gradeAvg = (test1>= 0? test1 * 0.25 : 0) + (test2>=0? test2 * 0.25 : 0) +
                        (finalExam>=0? finalExam * 0.25 : 0);
                /*System.out.println("Quiz avg: " + quizAvg + " Grade Avg: " + gradeAvg);*/
                double finalAvg = quizAvg + gradeAvg;
                // find corresponding grade letter
                String letter = getGradeLetter(finalAvg);
                //write the result to file
                finalGradeWriter.write(name + " " + id +" " + finalAvg + " " + letter + "\n");
            }
            closeFiles();
        } catch (IOException e) {
            System.out.println("Error while reading file IOException...");
            System.exit(0);
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Trying to access array index out of bounds ");
            System.exit(0);
        }
        catch(NumberFormatException e) {
            System.out.println("Error: System.IO.FormatException: Input string was not in correct format... ");
            closeFiles();
        }
    }
}

