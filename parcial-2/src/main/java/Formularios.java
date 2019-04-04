import org.simpleframework.xml.strategy.Strategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formularios {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String sector;
    private String nivelEscolar;
    private String latitud;
    private String longitud;


    public Formularios() {
    }

    public Formularios(String nombre, String sector, String nivelEscolar, String latitud, String longitud) {
        this.nombre = nombre;
        this.sector = sector;
        this.nivelEscolar = nivelEscolar;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {  return sector;  }

    public void setSector(String sector) {    this.sector = sector;    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getLatitud() {   return latitud;     }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
