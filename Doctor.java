// store and validate info of one doctor
class Doctor extends Person {
    private int doctorID;
    private String emailID;
    private String specialization ;
    private double salary;

    public Doctor(String doctorName, int doctorID, String emailID, String doctorContactNo, String specialization,
            double salary) {
        super(doctorName, doctorContactNo);
        setDoctorID(doctorID);
        setEmailID(emailID);
        setSpecialization(specialization);
        setSalary(salary);
    }
    
    public void displayDoctorInfo(){
        System.out.printf("Doctor Name       : %s\n", getName());
        System.out.printf("Doctor ID         : %d\n",doctorID);
        System.out.printf("Email             : %s\n", emailID);
        System.out.printf("Contack #         : %s\n", getContactNo());
        System.out.printf("Specialization    : %s\n", specialization);
        System.out.printf("Salary            : %.1f\n", salary);
    }



    public int getDoctorID() {
        return doctorID;
    }

    private void setDoctorID(int doctorID) {
        if(doctorID <= 0){
            throw new IllegalArgumentException("Invalid ID");
        }
        this.doctorID = doctorID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        if(Helper.validateEmailID(emailID)){
            this.emailID = emailID.trim();
        }else{
            throw new IllegalArgumentException("Invalid email");
        }
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if(specialization == null || specialization.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid specialization.");
        }
        this.specialization = specialization.trim();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(!Double.isFinite(salary)){
            throw new IllegalArgumentException("Invalid Salary");
        }
        this.salary = salary;
    }
}

