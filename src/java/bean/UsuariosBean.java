
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
import ejb.UsuariosFacadeLocal;
import entities.Usuarios;

@ManagedBean(name = "usuariosBean")
@ViewScoped
public class UsuariosBean implements Serializable {

    @Inject
    private UsuariosFacadeLocal usuariosFacadeLocal;
    private Usuarios usuario;
    private List<Usuarios> usuarios;

    @PostConstruct
    public void init() {
        // Inicializamos el usuario
        usuario = new Usuarios();

        // Obtenemos el ID del usuario si estamos editando
        String usuarioIdParam = FacesContext.getCurrentInstance()
            .getExternalContext().getRequestParameterMap().get("usuarioId");
        if (usuarioIdParam != null) {
            Long usuarioId = Long.parseLong(usuarioIdParam);
            usuario = usuariosFacadeLocal.find(usuarioId);
        }

        // Cargamos la lista de usuarios
        this.usuarios = usuariosFacadeLocal.findAll();
    }

    public void create() throws IOException {
        usuariosFacadeLocal.create(usuario);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Usuario creado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void edit() throws IOException {
        usuariosFacadeLocal.edit(usuario);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Usuario actualizado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    public void delete() throws IOException {
        usuariosFacadeLocal.remove(usuario);
        FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
            .addMessage(null, new FacesMessage("Usuario eliminado."));
        FacesContext.getCurrentInstance()
            .getExternalContext().redirect("index.xhtml");
    }

    // Getters y Setters
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getUsuarios() {
        return usuarios;
    }
}
