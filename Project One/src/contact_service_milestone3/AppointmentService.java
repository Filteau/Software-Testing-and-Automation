package contact_service_milestone3;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    // Constructor to initialize the in-memory storage
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
    	//System.out.println("accessed addAppointment");
        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointment.getAppointmentID(), appointment);
    }

    // Method to delete an appointment by ID
    public void deleteAppointment(String appointmentID) {
    	//System.out.println("accessed deleteAppointment");
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentID);
    }

    // Method to retrieve an appointment by ID
    public Appointment getAppointment(String appointmentID) {
    	//System.out.println("accessed getAppointment");
        return appointments.get(appointmentID);
    }
}

