package M04_JavaOOP.L04InterfacesAndAbstraction.Lab.T01CarShop;

import java.io.Serializable;

public interface Car extends Serializable {
    int TIRES = 4;

    String getModel();
    String getColor();
    Integer getHorsePower();
    String countryProduced();
}