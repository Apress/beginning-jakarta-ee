import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class Accounting implements Serializable {

    @Inject private FacesContext facesContext;
    @Inject private HttpServletRequest servletRequest;
    @Inject private ExternalContext externalContext;
    @Inject private ServletContext servletContext;
    @Inject private HttpSession httpSession;
	
    ...
}
