package uz.elmurodov.ui;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Saydali Murodullayev, Thu 10:38 AM. 1/13/2022
 */
@Getter
@AllArgsConstructor
public abstract class BaseAbstractUI {

    protected void show(ResponseEntity<Data<?>> response) {
        if (Pattern.matches("(200|201|202)", "" + response.getStatus()))
            Print.println(Color.GREEN, response.getBody().getData());
        else if (response.getStatus() == 404)
            Print.println(Color.RED, response.getBody().getData());
        else
            Print.println(Color.RED, "Response not found");
    }

}
