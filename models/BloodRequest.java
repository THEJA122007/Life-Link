package models;

public class BloodRequest {
    private int requestId;
    private String patientName;
    private String bloodGroup;
    private int unitsRequired;
    private String city;
    private String urgency;

    public BloodRequest(int requestId,String patientName,String bloodGroup,int unitsRequired,String city,String urgency) {
        this.requestId = requestId;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.unitsRequired = unitsRequired;
        this.city = city;
        this.urgency = urgency;
    }

    public int getRequestId() {
        return requestId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getUnitsRequired() {
        return unitsRequired;
    }

    public String getCity() {
        return city;
    }

    public String getUrgency() {
        return urgency;
    }

    public void displayRequest() {
        System.out.println("\n--- Blood Request ---");
        System.out.println("Request ID: " + requestId);
        System.out.println("Patient: " + patientName);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Units Required: " + unitsRequired);
        System.out.println("City: " + city);
        System.out.println("Urgency: " + urgency);
    }
}