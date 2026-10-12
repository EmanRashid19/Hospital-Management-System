// manage registered patients, check duplicates and handle registration

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Hospital {
    private String hospitalName ;
    private String location ;
    private String landLineNo ;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String hospitalName, String location, String landLineNo) {
        setHospitalName(hospitalName);
        this.location = location;
        this.landLineNo = landLineNo;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void setHospitalName(String hospitalName) {
        if(Helper.validateName(hospitalName)){
            this.hospitalName = hospitalName;
        }else{
            throw new IllegalArgumentException("Invalid Hospital Name");
        }
    }




    public void setLocation(String location) {
        if(location == null || location.isEmpty()){
            throw new IllegalArgumentException("Invalid Location");
        }
        this.location = location;
    }

    public void setLandLineNo(String landLineNo) {
        if(landLineNo == null || landLineNo.isEmpty() || !landLineNo.matches("^\\d{11}$")){
            throw new IllegalArgumentException("Invalid Number");
        }
        this.landLineNo = landLineNo;
    }


    public List<Doctor> getDoctors() {
        return Collections.unmodifiableList(doctors); // bahir list de to rahe hain but koi use modify nahi karsakta
    }




    public List<Patient> getPatients() {
       return Collections.unmodifiableList(patients);
    }



    public void displayHospitalInfo(){
        System.out.printf("Hospital name    : %s\n", hospitalName);
        System.out.printf("Location         : %s\n", location);
        System.out.printf("Land Line Number : %s\n", landLineNo);
    }

    public boolean addDoctor(Doctor doctor){
        if(doctor == null ){
          throw new IllegalArgumentException("Doctor cannot be null");
        }
        if(searchDoctor(doctor.getDoctorID()) == null){
            doctors.add(doctor);
            return true;
        }
            return false;    
    }

    public boolean removeDoctor(int doctorID){
        Doctor temp = searchDoctor(doctorID);
        if(temp != null){
            doctors.remove(temp);
            return true;
        }
        return false;
    }

    public Doctor searchDoctor(int doctorID){
        for(int i = 0 ; i < doctors.size() ; i++){
            if(doctors.get(i).getDoctorID() == doctorID){
                return doctors.get(i);
            }
        }
        return null;
    }

    
    public void displayAllDoctors(){
        for(Doctor d : doctors){
            d.displayDoctorInfo();
        }
    }


    public boolean addPatient(Patient patient){
        if(patient == null){
            throw new IllegalArgumentException("Patient can not be null");
        }
        if(searchPatient(patient.getPatientID()) == null){
            patients.add(patient);
            return true;
        }
        return false;
    }



    public Patient searchPatient(int patientID) {
        for(Patient p : patients){
            if(p.getPatientID() == patientID){
                return p;
            }
        }
        return null;
        
    }

    public boolean removePatient(int patientID){
        Patient temp = searchPatient(patientID);
        if(temp != null){
            patients.remove(temp);
            return true;
        }
        return false;
    }

    public void displayALLPatients(){
        for(Patient p : patients){
            p.displayPatientInfo();
        }
    }

   
}
  