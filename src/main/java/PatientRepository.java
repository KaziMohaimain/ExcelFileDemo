import java.util.ArrayList;
import java.util.List;

public class PatientRepository
{
    List<Patient> patients;

//Constructor:
    public PatientRepository()
    {
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient p)
    {
        patients.add(p);
    }

    public List<Patient> getPatients()
    {
        return patients;
    }


}
