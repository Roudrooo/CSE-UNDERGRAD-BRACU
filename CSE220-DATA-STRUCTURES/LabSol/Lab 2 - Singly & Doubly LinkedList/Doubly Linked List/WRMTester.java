public class WRMTester {
    public static void main(String[] args) {
        System.out.println("** Welcome to Waiting Room Management System **");
        // To Do
        // Create WRM Object and call the necessary methods
        WRM manage=new WRM();
        manage.registerPatient(10001,"ABC",20,"O+");
        manage.registerPatient(10002,"BCD",35,"O-");
        manage.registerPatient(10003,"CDE",23,"B-");
        manage.registerPatient(10004,"DEF",67,"A+");
        manage.registerPatient(10005,"EFG",45,"B+");
        System.out.println("\nAll patients:\n");
        manage.showAllPatient();
        System.out.println("\nServing a patient:\n");
        manage.servePatient();
        System.out.println("Serving a patient:");
        manage.servePatient();
        System.out.println("\nAll patients:\n");
        manage.showAllPatient();
        System.out.print("\nDoctor can go home: ");
        if(manage.canDoctorGoHome()) System.out.println("Yes\n");
        else System.out.println("No\n");
        manage.registerPatient(10006,"FGH",18,"Ab-");
        manage.registerPatient(10007,"GHI",87,"A-");
        manage.registerPatient(10008,"HIJ",02,"AB-");
        System.out.println("\nReversing this patient line\n");
        manage.reverseTheLine();
        System.out.println("\nAll patients:\n");
        manage.showAllPatient();
        System.out.println("\nServing a patient\n");
        manage.servePatient();
        System.out.println("\nCancelling all appointment\n");
        manage.cancelAll();
        System.out.print("\nDoctor can go home: ");
        if(manage.canDoctorGoHome()) System.out.println("Yes\n");
        else System.out.println("No\n");
    }
}
