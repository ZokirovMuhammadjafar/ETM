package uz.elmurodov.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

/**
 * @author Saydali Murodullayev, Thu 10:38 AM. 1/13/2022
 */
@Getter
@AllArgsConstructor
public abstract class BaseAbstractUI {

    protected void show(ResponseEntity<Data<?>> response) {
        if (response.getStatus() == 200)
            Print.println(Color.GREEN, response.getBody().getData());
        else if (response.getStatus() == 404)
            Print.println(Color.RED, response.getBody().getData());
        else
            Print.println(Color.RED, "Response not found");
    }

}
