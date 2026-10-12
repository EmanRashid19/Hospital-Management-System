public class Person {
    private String name;
    private String contactNo;
    public Person(String name, String contactNo) {
        setName(name);
        setContactNo(contactNo);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(Helper.validateName(name)){
            this.name = name.trim();
        }else{
            throw new IllegalArgumentException("Invalid Name");
        }
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        if(Helper.validateContactNo(contactNo)){
            this.contactNo = contactNo.trim();
        }else{
            throw new IllegalArgumentException("Invalid Contact Number.");
        }
    }

    
    
}
