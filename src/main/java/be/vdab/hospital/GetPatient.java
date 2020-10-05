package be.vdab.hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetPatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("read");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Patient p = em.find(Patient.class, 1L);

            System.out.println("Patient ID: " + p.getId());
            System.out.println("Patient Name: " + p.getName());

            MedicalFile m  = em.find(MedicalFile.class, 1L);
            System.out.println("Accessing medical file associated with this Patient");
            System.out.println("Patient Height: " + m.getHeight());
            System.out.println("Patient Weight: " + m.getWeight());

            tx.commit();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
