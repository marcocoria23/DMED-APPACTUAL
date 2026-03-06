/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PLE;

/**
 *
 * @author LAURA.MEDINAJ
 */


public enum Periodo {

    PRIMER_ORDINARIO("1PO"),
    PRIMER_RECESO("1PR"),
    SEGUNDO_ORDINARIO("2PO"),
    SEGUNDO_RECESO("2PR"),
    TERCER_ORDINARIO("3PO"),
    TERCER_RECESO("3PR");

    private final String codigo;

    Periodo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    // Convertir String del Excel → Enum
    public static Periodo fromCodigo(String codigo) {
        for (Periodo p : values()) {
            if (p.codigo.equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Periodo inválido: " + codigo);
    }
}