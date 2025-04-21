package mx.org.inegi.insert_TMP_SENAP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marco Coria
 */
public class CAST_FECHA_SENAP {

    private static final String INPUT_DATE_FORMAT = "yyyy-MM-dd"; // Ajusta según tu formato de entrada
    private static final String OUTPUT_DATE_FORMAT = "dd/MM/yyyy";

    // Método para convertir una fecha de String a un formato deseado
    public static String formatDate(String dateString) {

        if (!dateString.equals("")) {
            SimpleDateFormat inputFormat = new SimpleDateFormat(INPUT_DATE_FORMAT);
            SimpleDateFormat outputFormat = new SimpleDateFormat(OUTPUT_DATE_FORMAT);
            try {
                Date date = inputFormat.parse(dateString);
                return outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null; // O maneja el error como prefieras
            }

        } else {
            return null;
        }
    }

}
