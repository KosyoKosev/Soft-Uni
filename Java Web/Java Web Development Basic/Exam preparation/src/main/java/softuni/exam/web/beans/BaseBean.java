package softuni.exam.web.beans;

import javax.faces.context.FacesContext;
import java.io.IOException;

public abstract class BaseBean {
    protected void redirect(String url){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(String.format("/views%s.jsf", url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
