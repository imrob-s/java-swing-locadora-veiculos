
package com.imrob.locadoraveiculos.Utils;

import java.util.regex.Pattern;
/**
 * Classe utilitária para validação de dados.
 */
public class Validators {
/**
     * Verifica se uma string representa um número.
     * @param valor A string a ser verificada.
     * @return true se a string representar um número, caso contrário false.
     */
    public static boolean isNumber(String valor) {
        try {
            Double.valueOf(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
/**
     * Verifica se uma string contém apenas caracteres alfabéticos.
     * @param valor A string a ser verificada.
     * @return true se a string contiver apenas caracteres alfabéticos, caso contrário false.
     */
    public static boolean isCharacters(String valor) {
        return Pattern.matches("[a-zA-ZÀ-ú ]+", valor);
    }
/**
     * Verifica se uma string tem uma quantidade específica de caracteres.
     * @param valor A string a ser verificada.
     * @param quantidade A quantidade de caracteres esperada.
     * @return true se a string tiver a quantidade correta de caracteres, caso contrário false.
     */
    public static boolean hasNumberQuantity(String valor, int quantidade) {
        return valor.length() == quantidade;
    }
/**
     * Verifica se uma string é um endereço de e-mail válido.
     * @param email O endereço de e-mail a ser verificado.
     * @return true se o endereço de e-mail for válido, caso contrário false.
     */
    public static boolean isValidEmail(String email) {
        return Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", email);
    }
/**
     * Verifica se uma string está vazia.
     * @param valor A string a ser verificada.
     * @return true se a string estiver vazia, caso contrário false.
     */
    public static boolean isEmpty(String valor) {
        return valor.trim().isEmpty();
    }

}

