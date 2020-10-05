package be.vdab.hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("dropCreate");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Patient patient = new Patient();
            patient.setName("Kevin van der Kruk");
            MedicalFile medicalFile = new MedicalFile();
            patient.addMedicalFile(medicalFile);
            medicalFile.setHeight(1.72F);
            medicalFile.setWeight(59.0F);
            medicalFile.setPatient(patient);

            em.persist(medicalFile);
            em.persist(patient);

            tx.commit();
            System.out.println("Patient Saved");

        } finally {
            if (em != null)
                em.close();
            if (emf != null)
                emf.close();
        }
    }
}
