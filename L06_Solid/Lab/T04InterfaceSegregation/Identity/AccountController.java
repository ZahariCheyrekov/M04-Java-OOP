package M04_JavaOOP.L06_Solid.Lab.T04InterfaceSegregation.Identity;

import M04_JavaOOP.L06_Solid.Lab.T04InterfaceSegregation.Identity.Interfaces.Account;

public class AccountController {
    private final Account manager;

    public AccountController(Account manager) {
        this.manager = manager;
    }
    public void changePassword(String oldPass,String newPass){
        this.manager.changePassword(oldPass,newPass);
    }
}
