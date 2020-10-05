package be.vdab.hospital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("create");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            Patient patient = em.getReference(Patient.class, 1L);
            tx.begin();
            em.remove(patient);
            tx.commit();
            System.out.println("Patient Deleted");

        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
