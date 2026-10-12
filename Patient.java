// store one pateints information and validate its own feild
class Patient extends Person{
    private int patientID ;
    private int age ;
    private String gender ;
    private String bloodGroup ;

    public void displayPatientInfo(){
        System.out.printf("Patient Name       : %s\n", getName());
        System.out.printf("Pateint ID         : %d\n", patientID);
        System.out.printf("Age                : %d\n", age);
        System.out.printf("Contack #          : %s\n", getContactNo());
        System.out.printf("Gender             : %s\n", gender);
        System.out.printf("Blood Group        : %s\n", bloodGroup);
    }
    

    public Patient(String patientName, int patientID, String patientContactNo, int age, String gender,
            String bloodGroup) {
        super(patientName, patientContactNo);
        setPatientID(patientID);
        setAge(age);
        setGender(gender);
        setBloodGroup(bloodGroup);
    
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 100){
            this.age = age;
        }else{
            throw new IllegalArgumentException("Invalid Age");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if( gender != null && (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("transgender"))){
            this.gender = gender.trim().toLowerCase();
        }else{
            throw new IllegalArgumentException("Invalid gender");
        }
        
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        if(Helper.validateBloodGroup(bloodGroup)){
            this.bloodGroup = bloodGroup.trim().toUpperCase();
        }else{
            throw new IllegalArgumentException("Invalid Blood group");
        }
    }


    public int getPatientID() {
        return patientID;
    }


    private void setPatientID(int patientID) {
        if(patientID > 0){
            this.patientID = patientID;
        }else{
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    
    
}