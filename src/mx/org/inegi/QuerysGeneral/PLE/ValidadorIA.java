/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.QuerysGeneral.PLE;

/**
 *
 * @author ANTONIO.CORIA
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ValidadorIA {

    private final String apiKey;
    private final HttpClient cliente;

 public ValidadorIA() {

    System.setProperty(
        "javax.net.ssl.trustStore",
        "C:\\Users\\antonio.coria\\Desktop\\Temp\\cacerts_ple"
    );

    System.setProperty(
        "javax.net.ssl.trustStorePassword",
        "changeit"
    );

    System.setProperty(
        "javax.net.debug",
        "ssl,handshake"
    );

    apiKey = System.getenv("OPENAI_API_KEY");

    if (apiKey == null || apiKey.isBlank()) {
        throw new IllegalStateException(
            "No se encontró OPENAI_API_KEY"
        );
    }

    cliente = HttpClient.newHttpClient();
}


    public String validarIniciativa(
            String id,
            String nombreIniciativa) throws Exception {

        String prompt =
                "Analiza el siguiente asunto legislativo mexicano. "
              + "Determina si realmente corresponde a una iniciativa legislativa. "
              + "Responde de manera breve con este formato:\\n"
              + "ES_INICIATIVA: SI o NO\\n"
              + "TIPO: tipo de documento\\n"
              + "MOTIVO: explicación breve\\n\\n"
              + "Considera como posibles tipos:\\n"
              + "- Iniciativa de ley\\n"
              + "- Iniciativa de decreto\\n"
              + "- Iniciativa con proyecto de decreto\\n"
              + "- Proposición con punto de acuerdo\\n"
              + "- Exhorto\\n"
              + "- Dictamen\\n"
              + "- Minuta\\n"
              + "- Acuerdo\\n"
              + "- Otro\\n\\n"
              + "Una proposición con punto de acuerdo, exhorto, "
              + "dictamen, minuta o acuerdo no debe considerarse "
              + "automáticamente como iniciativa.\\n\\n"
              + "ID: " + id + "\\n"
              + "NOMBRE: " + nombreIniciativa;

        String json =
                "{"
              + "\"model\":\"gpt-5.6-luna\","
              + "\"input\":\"" + escaparJson(prompt) + "\""
              + "}";

        HttpRequest request =
                HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://api.openai.com/v1/responses"
                ))
                .header(
                        "Authorization",
                        "Bearer " + apiKey
                )
                .header(
                        "Content-Type",
                        "application/json"
                )
                .POST(
                        HttpRequest.BodyPublishers.ofString(json)
                )
                .build();

        HttpResponse<String> response =
                cliente.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        System.out.println(
                "HTTP: " + response.statusCode()
        );

        System.out.println(
                response.body()
        );

        return response.body();
    }


    private String escaparJson(String texto) {

        if (texto == null) {
            return "";
        }

        return texto
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\r", "\\r")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }
}
