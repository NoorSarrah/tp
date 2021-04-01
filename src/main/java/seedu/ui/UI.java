package seedu.ui;

import seedu.duke.Constants;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static seedu.duke.Constants.*;

public class UI {
    static final int LARGE_NUMBER = 100;
    static final String UNKNOWN_COMMAND = "unknown";
    static Scanner scanner = new Scanner(System.in);

    public static String scanInput() {
        return scanner.nextLine().trim();
    }

    public String getInput(String requestMenu) {
        System.out.print(requestMenu + " --> ");
        String input = scanner.nextLine();

        while (input.trim().isEmpty()) {
            System.out.print(requestMenu + " --> ");
            input = scanner.nextLine();
        }

        return input.replaceAll("\\s+", " ").trim();
    }

    public static String smartCommandRecognition(String[] commands, String input) {
        int diff = LARGE_NUMBER;
        int index = -1;
        List<String> list = Arrays.asList(commands);

        if( list.contains(input)) {
            return input;
        }
        if (input.length() >= 8 || input.length() < 1) {
            return UNKNOWN_COMMAND;
        }

        for (int i = 0; i < commands.length; i++) {
            int temp = checkCommandDifference(commands[i], input);
            if (temp < diff) {
                diff = temp;
                index = i;
            }
        }
        if (isTypo(commands[index])) {
            return commands[index];
        }
        return UNKNOWN_COMMAND;
    }

    public static boolean contains(char[] array, char input) {
        for (char c : array) {
            if (input == c) {
                return true;
            }
        }
        return false;
    }

    public static int checkCommandDifference(String expected, String actual) {
        char[] first = expected.toLowerCase().toCharArray();
        char[] second = actual.toLowerCase().toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        int numDiff = 0;
        int lengthDiff = abs(first.length -second.length);
        if (lengthDiff > 2) {
            return LARGE_NUMBER;
        }
        int i = 0;
        if (second.length >= first.length) {
            while (i < first.length) {
                if (!contains(first, second[i])) {
                    numDiff++;
                }
                i++;
            }
        } else {
            while (i < second.length - 1) {
                if (first[i] != (second[i]) && lengthDiff > 0) {
                    i++; numDiff++;
                    lengthDiff--;
                    continue;
                } else if (first[i] != second[i]) {
                    numDiff++;
                }
                i++;
            }
        }
        return max(lengthDiff, numDiff);
    }

    public static String cleanseInput(String input) {
        return  input.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static void invalidCommandErrorMessage() {
        System.out.println("OOPS! I cant recognize that command! ");
    }

    public static void noCommandErrorMessage() {
        System.out.println("OOPS! There is no command entered! ");
    }

    public static void invalidFormatErrorMessage() {
        System.out.println("OOPS! Please check to see if your command is properly formatted! ");
    }



    public static void showLine() {
        System.out.println(Constants.LINEBREAK);
    }
    public static void showLongLine() {
        System.out.println(Constants.LONGLINEBREAK);
    }

    public static void printEmptyLine() {
        System.out.print("\n");
    }

    public static void printWelcome() {
        System.out.println("Welcome to \n" + Constants.LOGO);
        showLine();
    }

    public static void printStartMenu() {

        UI.printEmptyLine();

        UI.printEmptyLine();
        int[] lengthPara = {15,40,10};
        printer(new String[]{HELP_HEADER_COMMAND, HELP_HEADER_DESCRIPTION, HELP_HEADER_FORMAT}, lengthPara);
        UI.showLongLine();
        printer(new String[]{TO_STAFF_INSTANCE, TO_STAFF_INSTANCE_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{TO_PATIENT_INSTANCE, TO_PATIENT_INSTANCE_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{TO_APPOINTMENTS_INSTANCE, TO_APPOINTMENTS_INSTANCE_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{TO_SCHEDULES_INSTANCE, TO_SCHEDULES_INSTANCE_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{TO_INVENTORY_INSTANCE, TO_INVENTORY_INSTANCE_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{HELP_COMMAND, HELP_COMMAND_DESCRIPTION, MARK_BLANK}, lengthPara);
        printer(new String[]{EXIT_COMMAND, EXIT_COMMAND_DESCRIPTION, MARK_BLANK}, lengthPara);
        UI.printEmptyLine();

    }

    public static void printGoodbye() {
        System.out.println("Goodbye! Have a nice day!");
    }

    public static void returningToStartMenuMessage() {
        System.out.println("Returning to start menu!");
    }

    public void showLoadingError() {
        System.out.println("OOPS! There was an error loading the file!");
    }

    public static String prettyPrint(String string, int length) {
        return String.format("%1$-" + length + "s", string);
    }

    public static void printer(String[] string, int[] length) {
        for (int i=0; i<length.length; i++) {
            System.out.print(prettyPrint(string[i], length[i]));
        }
        System.out.print("\n");
    }


    public static boolean isTypo(String command) {
        System.out.println("Do you mean \"" + command +"\" (y/n)");
        return scanInput().equals("y");
    }

    public void lineBreak() {
        System.out.print(System.lineSeparator());
    }

}
