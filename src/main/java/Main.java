import Controllers.*;

import static spark.Spark.staticFiles;

/**
 * Created by Leonardo on 09/06/2016.
 */
public class Main {

    public static void main(String[] args) {

        staticFiles.location("/public");
        Routes rutas = new Routes();


    }
}
