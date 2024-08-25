package contact_service_milestone3;

import java.util.Date;

public class Appointment {
	private final String appointmentID;
    private final Date appointmentDate;
    private final String description;

    // Constructor w validation
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10) {
        	//System.out.println("accessed if appointmentID");
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
        	//System.out.println("accessed if appointmentDate");
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) {
        	//System.out.println("accessed if description");
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentID() {
    	//System.out.println("accessed getter getAppointmentID");
        return appointmentID;
    }

    public Date getAppointmentDate() {
    	//System.out.println("accessed getter getAppointmentDate");
        return appointmentDate;
    }

    public String getDescription() {
    	//System.out.println("accessed getter getDscription");
        return description;
    }
}
