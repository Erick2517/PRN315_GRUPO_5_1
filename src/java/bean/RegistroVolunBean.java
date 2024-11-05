
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
import ejb.RegistroVolunFacadeLocal;
import entities.RegistroVolun;

@ManagedBean(name = "registroVolunBean")
@ViewScoped
public class RegistroVolunBean implements Serializable {

    @Inject
    private RegistroVolunFacadeLocal registroVolunFacadeLocal;
    private RegistroVolun registroVolun;
    private List<RegistroVolun> registrosVolun;

    @PostConstruct
    public void init() {
        // Inicializamos el registro de voluntariado
        registroVolun = new RegistroVolun();

        // Obtenemos el ID del registro si estamos editando
        String registroIdParam = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("registroId");
        if (registroIdParam != null) {
            Long registroId = Long.parseLong(registroIdParam);
            registroVolun = registroVolunFacadeLocal.find(registroId);
        }

        // Cargamos la lista de registros de voluntariado
        this.registrosVolun = registroVolunFacadeLocal.findAll();
    }

    public void create() throws IOException {
        registroVolunFacadeLocal.create(registroVolun);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Registro de voluntariado creado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        registroVolunFacadeLocal.edit(registroVolun);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Registro de voluntariado actualizado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        registroVolunFacadeLocal.remove(registroVolun);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Registro de voluntariado eliminado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    // Getters y Setters
    public RegistroVolun getRegistroVolun() {
        return registroVolun;
    }

    public void setRegistroVolun(RegistroVolun registroVolun) {
        this.registroVolun = registroVolun;
    }

    public List<RegistroVolun> getRegistrosVolun() {
        return registrosVolun;
    }
}


