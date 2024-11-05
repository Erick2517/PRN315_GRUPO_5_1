
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
import ejb.OportunidadVolunFacadeLocal;
import entities.OportunidadVolun;

@ManagedBean(name = "oportunidadVolunBean")
@ViewScoped
public class OportunidadVolunBean implements Serializable {

    @Inject
    private OportunidadVolunFacadeLocal oportunidadVolunFacadeLocal;
    private OportunidadVolun oportunidadVolun;
    private List<OportunidadVolun> oportunidadesVolun;

    @PostConstruct
    public void init() {
        oportunidadVolun = new OportunidadVolun();
        oportunidadesVolun = oportunidadVolunFacadeLocal.findAll();
    }

    public void create() throws IOException {
        oportunidadVolunFacadeLocal.create(oportunidadVolun);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oportunidad creada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        oportunidadVolunFacadeLocal.edit(oportunidadVolun);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oportunidad actualizada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        oportunidadVolunFacadeLocal.remove(oportunidadVolun);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Oportunidad eliminada."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    public OportunidadVolun getOportunidadVolun() {
        return oportunidadVolun;
    }

    public void setOportunidadVolun(OportunidadVolun oportunidadVolun) {
        this.oportunidadVolun = oportunidadVolun;
    }

    public List<OportunidadVolun> getOportunidadesVolun() {
        return oportunidadesVolun;
    }
}
