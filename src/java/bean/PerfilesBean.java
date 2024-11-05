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
import ejb.PerfilesFacadeLocal;
import entities.Perfiles;

@ManagedBean(name = "perfilesBean")
@ViewScoped
public class PerfilesBean implements Serializable {

    @Inject
    private PerfilesFacadeLocal perfilesFacadeLocal;
    private Perfiles perfil;
    private List<Perfiles> perfiles;

    @PostConstruct
    public void init() {
        // Inicializamos el perfil
        perfil = new Perfiles();

        // Obtenemos el ID del perfil si estamos editando
        String perfilIdParam = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("perfilId");
        if (perfilIdParam != null) {
            Long perfilId = Long.parseLong(perfilIdParam);
            perfil = perfilesFacadeLocal.find(perfilId);
        }
        
        // Cargamos la lista de perfiles
        this.perfiles = perfilesFacadeLocal.findAll();
    }

    public void create() throws IOException {
        perfilesFacadeLocal.create(perfil);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Perfil creado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        perfilesFacadeLocal.edit(perfil);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Perfil actualizado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        perfil = perfilesFacadeLocal.find(perfil.getId());
        perfilesFacadeLocal.remove(perfil);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Perfil eliminado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    // Getters y Setters
    public Perfiles getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfiles perfil) {
        this.perfil = perfil;
    }

    public List<Perfiles> getPerfiles() {
     return perfiles;
    }
}