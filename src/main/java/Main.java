public class Main
{
    public static void main(String[] args) {

        PatientRepository repository = new PatientRepository();
        XMLReader.loadPatients("sampledatasafety.xlsx", repository);

        for(int i=0;i<10;i++)
        {
            Patient p = repository.getPatients().get(i);
            System.out.println(p.getIncident() + " -> " + p.getDept());
        }
    }
}
