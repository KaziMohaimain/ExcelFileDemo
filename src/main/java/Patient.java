public class Patient
{
    String gender, age, incident, dept;

    public Patient(String gender, String age, String incident, String dept)
    {
        this.gender = gender;
        this.age = age;
        this.incident = incident;
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getIncident() {
        return incident;
    }

    public String getDept() {
        return dept;
    }


}
