package Controllers;
/**
 * Created by Leonardo on 09/06/2016.
 */
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Routes {

    public Routes() {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(Routes.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        /**Get methods**/

        get("/rutas/", (request, reponse) -> {
            return "Ejemplo de rutas... GET";
        });

        get("/home/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario en FreeMarker");
            return new ModelAndView(attributes, "index.html");
        }, freeMarkerEngine);





        post("/rutas/", (request, reponse) -> {
            return "Ejemplo de rutas... POST";
        });


        put("/rutas/", (request, reponse) -> {
            return "Ejemplo de rutas... PUT";
        });

        delete("/rutas/", (request, reponse) -> {
            return "Ejemplo de rutas... DELETE";
        });
    }
}


