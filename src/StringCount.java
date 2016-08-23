

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class StringCount {

    static final int MINIMUM_NUMBER_OF_OCCURENCE = 1;
    static final int MAXIMUM_NUMBER_OF_OCCURENCE = 9;
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int requiredWordFrequency = 0;
        String fileName = getTheFile();
        requiredWordFrequency = getOccurence();

        WordCounter counter = new WordCounter(fileName, requiredWordFrequency);
        try {

            counter.displayWordFrequency(requiredWordFrequency);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getTheFile() {
        File file = null;
        String fileName;
        while (true) {
            try {
                System.out.println("Enter filename: ");
                fileName = sc.next();
                file = new File(fileName);
                System.out.println("****" + fileName.length());
                if (!file.exists() || file.isDirectory()) {
                    throw new FileNotFoundException("Not found as a file");
                }
                if (fileName != null) {
                    break;
                }
                if (!(fileName.isEmpty())) {
                    break;
                }
                if ((file.length() == 0)) {
                    //System.out.println("The file is empty! please provide a file with words.");
                    throw new IOException("The file is empty! please provide a file with words.");
                }
            } catch (FileNotFoundException fe) {
                System.out.println(fe.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        assert fileName != null : "file name is null";
        assert !(fileName.isEmpty()) : "file name is empty";
        return fileName;
    }

    private static int getOccurence() {

        int numberOfOccurence;
        while (true) {
            try {
                System.out.println("Enter the minimum number of occurence: ");
                numberOfOccurence = Integer.parseInt(sc.next());
                if (numberOfOccurence < MINIMUM_NUMBER_OF_OCCURENCE) {
                    throw new InputMismatchException("Enter valid input between 0 to 9");
                } else if (numberOfOccurence > MAXIMUM_NUMBER_OF_OCCURENCE) {
                    throw new InputMismatchException("Enter valid input between 0 to 9");
                }
                break;

            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e1) {
                System.out.println("zshvhjvdsaajuvc");
            }

        }

        assert numberOfOccurence > MINIMUM_NUMBER_OF_OCCURENCE : "Incorrect number of occurences";
        return numberOfOccurence;
    }
}