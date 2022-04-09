package fairyShop.models.shops;

import fairyShop.models.helpers.Helper;
import fairyShop.models.presents.Present;

public interface Shop {
    void craft(Present present, Helper helper);
}
