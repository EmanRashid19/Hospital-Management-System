public  class Helper {
    public static boolean validateContactNo(String number){
        if(number == null){
            return false;
        }
        number = number.trim();
        if(number.matches("\\d{11}") && number.charAt(0) == '0'){
            int code = Integer.parseInt(number.substring(1,4));
            if((code >= 300 && code <= 310 )|| (code >= 330 && code <= 348 && code != 338 && code != 339)){
                return true;
            }
        }
        return false;
    }

    public static boolean validateName(String name){
        if(name == null || name.trim().isEmpty() || !name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$") ) {
            return false;
        }
        return true;
    }

   public static boolean validateEmailID(String email){
        if( email != null && email.trim().isEmpty()== false && email.matches("^\\w+@gmail\\.com$") ){
            return true;
        }
        return false;
   }

   public static boolean validateBloodGroup(String bloodGroup){
    String [] validGroups = {"A+","A-","B+","B-","O+","O-","AB+","AB-"};
    if(bloodGroup == null || bloodGroup.trim().isEmpty()){
        return false;
    }
    for(String blood : validGroups){
        if(blood.equalsIgnoreCase(bloodGroup.trim())){
            return true;
        }
    }
    return false;
   }
}
