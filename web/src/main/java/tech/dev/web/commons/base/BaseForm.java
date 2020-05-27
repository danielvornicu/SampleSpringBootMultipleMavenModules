package tech.dev.web.commons.base;


import tech.dev.commons.to.base.TransferObject;

import java.io.Serializable;

/**
 * Formulaire de base dont tous les formulaires doivent hériter
 * <p>
 * Date: 11/12/2018
 *
 * @version 1.0 $Revision$ $Date$
 */

public abstract class BaseForm<T extends TransferObject> implements Serializable {

    public abstract void initForm(T to);
    public abstract T saveForm();

    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

}