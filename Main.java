
public class Main {

    public static void main(String[] args) {

        Hospital hospital = new Hospital(
                "XYZ",
                "Chaklala, Rawalpindi",
                "05163308102"
        );

        // Create doctors
        Doctor d1 = new Doctor(
                "Eman", 110, "abc@gmail.com",
                "03345678911", "Heart", 20000.0
        );

        Doctor d2 = new Doctor(
                "Mehak", 110, "xyz@gmail.com",
                "03354512668", "Brain", 30000.0
        );

        Doctor d3 = new Doctor(
                "Ali", 112, "ali@gmail.com",
                "03345678912", "Surgery", 40000.0
        );

        // Display hospital information
        System.out.println("===== HOSPITAL INFORMATION =====");
        hospital.displayHospitalInfo();

        // Test doctor registration
        System.out.println("\n===== DOCTOR REGISTRATION =====");

        System.out.println(
                "Register Eman: " + hospital.addDoctor(d1)
        );

        System.out.println(
                "Register Mehak with duplicate ID: "
                + hospital.addDoctor(d2)
        );

        System.out.println(
                "Register Ali: " + hospital.addDoctor(d3)
        );

        // Display all registered doctors
        System.out.println("\n===== ALL REGISTERED DOCTORS =====");
        hospital.displayAllDoctors();

        // Test doctor search
        System.out.println("\n===== SEARCH DOCTOR =====");

        Doctor foundDoctor = hospital.searchDoctor(110);

        if (foundDoctor != null) {
            System.out.println("Doctor found:");
            foundDoctor.displayDoctorInfo();
        } else {
            System.out.println("Doctor not found.");
        }

        Doctor missingDoctor = hospital.searchDoctor(999);

        if (missingDoctor != null) {
            missingDoctor.displayDoctorInfo();
        } else {
            System.out.println("Doctor with ID 999 not found.");
        }

        // Test doctor removal
        System.out.println("\n===== REMOVE DOCTOR =====");

        System.out.println(
                "Remove doctor 110: " + hospital.removeDoctor(110)
        );

        System.out.println(
                "Remove doctor 999: " + hospital.removeDoctor(999)
        );

        // Test null input
        System.out.println("\n===== NULL INPUT TEST =====");

        try {
            hospital.addDoctor(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation passed: " + e.getMessage());
        }

        // Display doctors after removal
        System.out.println("\n===== DOCTORS AFTER REMOVAL =====");
        hospital.displayAllDoctors();
    }
}