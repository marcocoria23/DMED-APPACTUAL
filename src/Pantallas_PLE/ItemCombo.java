/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas_PLE;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class ItemCombo {
    private String texto;
    private int valor;

    public ItemCombo(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return texto; // Esto es lo que se mostrará en el JComboBox
    }
}