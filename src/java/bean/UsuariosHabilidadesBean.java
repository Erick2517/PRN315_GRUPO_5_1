
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
import ejb.UsuariosHabilidadesFacadeLocal;
import entities.UsuariosHabilidades;

@ManagedBean(name = "usuariosHabilidadesBean")
@ViewScoped
public class UsuariosHabilidadesBean implements Serializable {

    @Inject
    private UsuariosHabilidadesFacadeLocal usuariosHabilidadesFacadeLocal;
    private UsuariosHabilidades usuarioHabilidad;
    private List<UsuariosHabilidades> usuariosHabilidades;

    @PostConstruct
    public void init() {
        // Inicializamos la relación usuario-habilidad
        usuarioHabilidad = new UsuariosHabilidades();

        // Obtenemos el ID de la relación si estamos editando
        String usuarioHabilidadIdParam = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("usuarioHabilidadId");
        if (usuarioHabilidadIdParam != null) {
            Long usuarioHabilidadId = Long.parseLong(usuarioHabilidadIdParam);
            usuarioHabilidad = usuariosHabilidadesFacadeLocal.find(usuarioHabilidadId);
        }

        // Cargamos la lista de relaciones usuario-habilidad
        this.usuariosHabilidades = usuariosHabilidadesFacadeLocal.findAll();
    }

    public void create() throws IOException {
        usuariosHabilidadesFacadeLocal.create(usuarioHabilidad);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Relación usuario-habilidad creada."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        usuariosHabilidadesFacadeLocal.edit(usuarioHabilidad);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Relación usuario-habilidad actualizada."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        usuariosHabilidadesFacadeLocal.remove(usuarioHabilidad);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Relación usuario-habilidad eliminada."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    // Getters y Setters
    public UsuariosHabilidades getUsuarioHabilidad() {
        return usuarioHabilidad;
    }

    public void setUsuarioHabilidad(UsuariosHabilidades usuarioHabilidad) {
        this.usuarioHabilidad = usuarioHabilidad;
    }

    public List<UsuariosHabilidades> getUsuariosHabilidades() {
        return usuariosHabilidades;
    }
}
