class Patient{
    private int id;
    private String name;
    private int birthYear;
    private double height = 170.0;
    private double weight = 70.0;
    private String bloodGroup = "O";
    private String phoneNumber = "none";

    public Patient(int id, String name, int birthYear, double height, double weight, String bloodGroup, String phoneNumber){
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    
        if(height <= 0){
            System.out.println("[!] Invalid height for \"" + this.name + "\", set to default as " + this.height + " cm.");
        }
        else this.height = height;

        if(weight <= 0) {
            System.out.println("[!] Invalid weight for \"" + this.name + "\", set to default as " + this.weight + " kg.");
        }
        else this.weight = weight;

        bloodGroup = bloodGroup.toUpperCase();
        if(bloodGroup.equals("A") || bloodGroup.equals("B") || bloodGroup.equals("AB") || bloodGroup.equals("O")){
            this.bloodGroup = bloodGroup;
        }
        else System.out.println("[!] Invalid blood-group for \"" + this.name + "\", set to default as '" + this.bloodGroup + "'.");

        boolean hasString = false;
        try {
            Double temp = Double.parseDouble(phoneNumber);
        } catch (NumberFormatException e) {
            hasString = true;
        }
        if(hasString == false && phoneNumber.length() == 10){
            this.phoneNumber = phoneNumber;
        }
        else System.out.println("[!] Invalid phone-number for \"" + this.name + "\", set to default as '" + this.phoneNumber + "'.");
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(int currentYear){
        if (currentYear > this.birthYear) {
            return currentYear - this.birthYear;
        }
        else return 0;
         
    }
    public double getHeight(){
        return this.height;
    }
    public double getWeight(){
        return this.weight;
    }
    public String getBloodGroup(){
        return this.bloodGroup;
    }

    public double getBMI(){
        double heightM = this.height / 100;
        return weight / (heightM * heightM);
    }

    public void displayDetails(int currentYear) { 
        System.out.println("Patient Name: " + name); 
        System.out.println("Patient Age: " + getAge(currentYear)); 
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("BMI: " + getBMI());
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Phone Number: " + phoneNumber);
    }
}