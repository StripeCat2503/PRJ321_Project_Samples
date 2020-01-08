/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.account;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class AccountRegistrationErrors implements Serializable{
    private String usernameLengthError;
    private String passwordLengthError;
    private String lastnameLengthError;
    private String confirmNotMatchError;
    private String duplicatedUsernameError;
    
    public AccountRegistrationErrors(){
        
    }

    /**
     * @return the usernameLengthError
     */
    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    /**
     * @param usernameLengthError the usernameLengthError to set
     */
    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    /**
     * @return the paswordLengthError
     */
    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    /**
     * @param paswordLengthError the paswordLengthError to set
     */
    public void setPasswordLengthError(String paswordLengthError) {
        this.passwordLengthError = paswordLengthError;
    }

    /**
     * @return the lastnameLengthError
     */
    public String getLastnameLengthError() {
        return lastnameLengthError;
    }

    /**
     * @param lastnameLengthError the lastnameLengthError to set
     */
    public void setLastnameLengthError(String lastnameLengthError) {
        this.lastnameLengthError = lastnameLengthError;
    }

    /**
     * @return the confirmNotMatchError
     */
    public String getConfirmNotMatchError() {
        return confirmNotMatchError;
    }

    /**
     * @param confirmNotMatchError the confirmNotMatchError to set
     */
    public void setConfirmNotMatchError(String confirmNotMatchError) {
        this.confirmNotMatchError = confirmNotMatchError;
    }

    /**
     * @return the duplicatedUsernameError
     */
    public String getDuplicatedUsernameError() {
        return duplicatedUsernameError;
    }

    /**
     * @param duplicatedUsernameError the duplicatedUsernameError to set
     */
    public void setDuplicatedUsernameError(String duplicatedUsernameError) {
        this.duplicatedUsernameError = duplicatedUsernameError;
    }
    
    
}
