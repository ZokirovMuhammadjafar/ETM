package uz.elmurodov.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
public class BaseUtils {
    public static final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static Float getFloat(String s) {
        Print.print(Color.CYAN, s);
        try {
            return new Scanner(System.in).nextFloat();
        } catch (InputMismatchException e) {
            Print.print("Wrong input, please enter float number: ");
            getFloat(s);
        }
        return null;
    }
}
