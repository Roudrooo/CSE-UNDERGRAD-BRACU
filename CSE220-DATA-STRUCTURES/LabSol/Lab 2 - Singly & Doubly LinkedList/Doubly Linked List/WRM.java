public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
        // To Do
        Patient newPatient=new Patient(id,name,age,bloodgroup,dh,dh.prev);
        dh.prev.next=newPatient;
        dh.prev=newPatient;
        System.out.println("Success (A patient has been registered).");
    }

    public void servePatient() {
        // To do
        if(canDoctorGoHome()){
            System.out.println("No patient to serve.");
        }else{
            Patient firstPatient=dh.next;
            System.out.println("Serving the patient: "+firstPatient.name);
            dh.next=firstPatient.next;
            firstPatient.next.prev=dh;
        }
    }

    public void showAllPatient() {
        // To Do
        if(canDoctorGoHome()){
            System.out.println("No patient available.");
        }else{
            Patient shwPat=dh.next;
            int i=1;
            while(shwPat!=dh){
                System.out.printf("%d. Patient id: %d; Name: %s; Age: %d; Bloodgroup: %s\n",i++,shwPat.id,shwPat.name,shwPat.age,shwPat.bloodGroup);
                shwPat=shwPat.next;
            }
        }
    }

    public boolean canDoctorGoHome() {
        // To Do
        if(dh.next==dh&&dh.prev==dh) return true;
        else return false; // Delete this line once you're ready
    }

    public void cancelAll() {
        // To Do
        dh.next=dh;
        dh.prev=dh;
        System.out.println("Success (All appointments have been canceled).");

    }


    public void reverseTheLine() {
        // To Do
        Patient revPet=dh.next,temp=null;
        while(revPet!=dh){
            temp=revPet.prev;
            revPet.prev=revPet.next;
            revPet.next=temp;
            revPet=revPet.prev;
        }
        dh.next=temp.prev;
        System.out.println("Success (Patient line have been reversed).");
    }
}