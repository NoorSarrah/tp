package seedu.storage;

import seedu.exceptions.nurseschedules.CrossValidationError;
import seedu.exceptions.nurseschedules.InvalidIDTypeException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.NurseScheduleActions;
import seedu.logic.errorchecker.NurseScheduleChecker;
import seedu.model.NurseSchedule;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static seedu.duke.Constants.SCHEDULES_FILE_PATH;

public class NurseScheduleStorage {

    private static final String FILE_PATH = SCHEDULES_FILE_PATH;
    static ArrayList<NurseSchedule> nurseSchedules = new ArrayList<>();

    /**
     * Creates new file.
     */
    private static void createFile() {
        try {
            File file = new File(FILE_PATH);
            file.createNewFile();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<NurseSchedule> readFile() throws NurseIdNotFound, InvalidIDTypeException, FileNotFoundException, CrossValidationError {
        FileInputStream file = new FileInputStream(FILE_PATH);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] details = sc.nextLine().split("\\|", 0);
            NurseScheduleChecker.checkNurseIDExist(details[0]);
            NurseScheduleChecker.checkValidNurseID(details[0]);
            NurseScheduleChecker.checkValidPatientID(details[1]);
            nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
            }
        return nurseSchedules;
    }

    public void writeToFile(NurseScheduleActions nurseSchedules) {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i<nurseSchedules.getSize(); i++) {
                writer.write(nurseSchedules.toSaveFile(i));
                writer.write("\r\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<NurseSchedule> load() throws FileNotFoundException, InvalidIDTypeException, NurseIdNotFound, CrossValidationError {
        createFile();
        nurseSchedules = readFile();
        return nurseSchedules;
    }
}
