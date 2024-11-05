
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
import ejb.HabilidadesFacadeLocal;
import entities.Habilidades;

@ManagedBean(name = "habilidadesBean")
@ViewScoped
public class HabilidadesBean implements Serializable {

    @Inject
    private HabilidadesFacadeLocal habilidadesFacadeLocal;
    private Habilidades habilidad;
    private List<Habilidades> habilidades;

    @PostConstruct
    public void init() {
        habilidad = new Habilidades();
        habilidades = habilidadesFacadeLocal.findAll();
    }

    public void create() throws IOException {
        habilidadesFacadeLocal.create(habilidad);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habilidad creada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        habilidadesFacadeLocal.edit(habilidad);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habilidad actualizada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        habilidadesFacadeLocal.remove(habilidad);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Habilidad eliminada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public Habilidades getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidades habilidad) {
        this.habilidad = habilidad;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }
}
