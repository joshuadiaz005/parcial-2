import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args)  {

//        try {
////            ServicioBootstrap.iniciarBaseDatos();
////            ServicioBaseDatos.getInstancia().testConexion();
//
//            //ServicioBootstrap.crearTablas();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //new GuardarObjeto<Formularios>().save(new Formularios("Joshua", "Sab Igle", "Universitario", "13.23424", "25.342342"));
        staticFiles.location("/plantillas");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        cfg.setClassForTemplateLoading(Main.class, "/plantillas");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(cfg);

        get("/Crear", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "crear-formulario.ftl");
        }, freeMarkerEngine);

        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            Map<String, Object> atributos = new HashMap<>();
            return new ModelAndView(atributos, "crear-formulario.ftl");
        }, freeMarkerEngine);

        get("/listar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "crear-formulario.ftl");
        }, freeMarkerEngine);

    }

    @Override
    protected void finalize() throws Throwable {

        ServicioBootstrap.detenerBaseDatos();
    }

}
