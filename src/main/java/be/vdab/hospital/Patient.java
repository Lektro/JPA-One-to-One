package be.vdab.hospital;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="MEDICALFILE")
    private MedicalFile medicalFile () {
        return medicalFile();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMedicalFile(MedicalFile mf) {

        mf.setPatient(this);
    }
    public void removeMedicalFile() {
            medicalFile().setPatient(null);
        }
    }

