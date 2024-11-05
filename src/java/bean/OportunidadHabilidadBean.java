
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
import ejb.OportunidadHabilidadFacadeLocal;
import entities.OportunidadHabilidad;

@ManagedBean(name = "oportunidadHabilidadBean")
@ViewScoped
public class OportunidadHabilidadBean implements Serializable {

    @Inject
    private OportunidadHabilidadFacadeLocal oportunidadHabilidadFacadeLocal;
    private OportunidadHabilidad oportunidadHabilidad;
    private List<OportunidadHabilidad> oportunidadesHabilidad;

    @PostConstruct
    public void init() {
        oportunidadHabilidad = new OportunidadHabilidad();
        oportunidadesHabilidad = oportunidadHabilidadFacadeLocal.findAll();
    }

    public void create() throws IOException {
        oportunidadHabilidadFacadeLocal.create(oportunidadHabilidad);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oportunidad Habilidad creada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        oportunidadHabilidadFacadeLocal.edit(oportunidadHabilidad);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oportunidad Habilidad actualizada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        oportunidadHabilidadFacadeLocal.remove(oportunidadHabilidad);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oportunidad Habilidad eliminada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public OportunidadHabilidad getOportunidadHabilidad() {
        return oportunidadHabilidad;
    }

    public void setOportunidadHabilidad(OportunidadHabilidad oportunidadHabilidad) {
        this.oportunidadHabilidad = oportunidadHabilidad;
    }

    public List<OportunidadHabilidad> getOportunidadesHabilidad() {
        return oportunidadesHabilidad;
    }
}

