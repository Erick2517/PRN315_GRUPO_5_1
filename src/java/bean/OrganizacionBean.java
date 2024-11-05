
package bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import ejb.OrganizacionFacadeLocal;
import entities.Organizacion;

@ManagedBean(name = "organizacionBean")
@ViewScoped
public class OrganizacionBean implements Serializable {

    @Inject
    private OrganizacionFacadeLocal organizacionFacadeLocal;
    private Organizacion organizacion;
    private List<Organizacion> organizaciones;

    @PostConstruct
    public void init() {
        // Inicializamos la organización
        organizacion = new Organizacion();

        // Obtenemos el ID de la organización si estamos editando
        String organizacionIdParam = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("organizacionId");
        if (organizacionIdParam != null) {
            Long organizacionId = Long.parseLong(organizacionIdParam);
            organizacion = organizacionFacadeLocal.find(organizacionId);
        }

        // Cargamos la lista de organizaciones
        this.organizaciones = organizacionFacadeLocal.findAll();
    }

    public void create() throws IOException {
        organizacionFacadeLocal.create(organizacion);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Organización creada."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        organizacionFacadeLocal.edit(organizacion);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Organización actualizada."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        organizacion = organizacionFacadeLocal.find(organizacion.getId());
        organizacionFacadeLocal.remove(organizacion);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Organización eliminada."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    // Getters y Setters
    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public List<Organizacion> getOrganizaciones() {
        return organizaciones;
    }
}
