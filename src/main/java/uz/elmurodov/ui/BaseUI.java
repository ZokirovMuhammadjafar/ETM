package uz.elmurodov.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Saydali Murodullayev, Wed 11:26 PM. 1/12/2022
 */
public interface BaseUI {
    void create();

    void block();

    void unblock();

    void delete();

    void update();

    void list();



}
