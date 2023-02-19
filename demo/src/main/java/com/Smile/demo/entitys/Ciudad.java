package com.Smile.demo.entitys;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String ciudad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad() {
    }
 
    public List<Perfil> getPerfiles() {
        return perfiles;
    }
    
    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
    
    @OneToMany(mappedBy = "ciudad", cascade=CascadeType.ALL)
        private List<Perfil> perfiles;
}
