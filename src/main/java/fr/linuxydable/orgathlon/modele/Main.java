package fr.linuxydable.orgathlon.modele;

import fr.linuxydable.orgathlon.Database.InputDataBase.InputContact;
import fr.linuxydable.orgathlon.Database.InputDataBase.InputCourse;
import fr.linuxydable.orgathlon.Database.InputDataBase.InputTache;
import fr.linuxydable.orgathlon.Database.RequestDataBase.RequestContactExt;
import fr.linuxydable.orgathlon.Database.RequestDataBase.RequestCourse;
// import fr.linuxydable.orgathlon.Database.RequestDataBase.UpdateDatabaseContactExt;
import fr.linuxydable.orgathlon.modele.contacts.Contact;
import fr.linuxydable.orgathlon.modele.contacts.ContactExterne;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	/*RequestContactExt req = new RequestContactExt();
    	Contact test = req.request(1);
    	Contact test2 = new ContactExterne("Roger","Chevalier");
    	InputContact.input(test2);
    	System.out.println(test.getPrenom_c().getClass());
    	System.out.println(test2.getPrenom_c());
    	
    	test2.setPrenom_c("Max");
    	UpdateDatabaseContactExt up = new UpdateDatabaseContactExt();
    	up.UpdateDatabaseContactExt((ContactExterne)test2);
    }
    
    
    
}
    	*/
    
    	
    	fr.linuxydable.orgathlon.modele.Course test = new Course("test") ;
    
    	InputCourse in = new InputCourse() ;
    	
    	in.inputCourse(test) ;
    	
    	
    	
    }
    
}

