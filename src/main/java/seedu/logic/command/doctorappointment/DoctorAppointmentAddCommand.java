package seedu.logic.command.doctorappointment;

import seedu.model.doctorappointment.AppointmentList;
import seedu.logic.command.Command;
import seedu.ui.DoctorAppointmentUI;

import java.io.IOException;

public class DoctorAppointmentAddCommand extends Command {

    private String[] input;

    public DoctorAppointmentAddCommand(String[] parsedInput) {
        input = parsedInput;
    }

    @Override
    public void execute(AppointmentList appointment, DoctorAppointmentUI ui) throws IOException {
        AppointmentList.addAppointment(input);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}