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
            emf = Persistence.createEntityManagerFactory("create");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Patient patient = new Patient();
            MedicalFile medicalFile = new MedicalFile();
            patient.setId(1L);
            patient.setName("Kevin van der Kruk");
            patient.addMedicalFile(medicalFile);
            medicalFile.setHeight(172);
            medicalFile.setWeight(59);
            medicalFile.setPatient(patient);
            em.persist(patient);
            em.persist(medicalFile);
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
