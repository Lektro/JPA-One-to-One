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
            emf = Persistence.createEntityManagerFactory("read");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();


            Patient patient = em.find(Patient.class, 1L);
            em.getTransaction().begin();
            em.remove(patient);
            em.getTransaction().commit();
            System.out.println("Patient Deleted");

        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
