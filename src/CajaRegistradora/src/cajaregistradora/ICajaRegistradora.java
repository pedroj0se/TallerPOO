
package cajaregistradora;

public interface ICajaRegistradora {
    // Devuelve el nombre de la caja
    String getNombre();

    // Devuelve el número de tipos de monedas presentes en la caja
    int getNumTipoMonedas();

    // Devuelve la cantidad de unidades del tipo de moneda especificado
    int getUnidadesTipoMoneda(double tipo);

    // Ingresa monedas del tipo y cantidad especificados
    boolean meterMonedas(double tipo, int unidades);

    // Valida si el tipo de moneda especificado es válido
    boolean monedaValida(double tipo);

    // Extrae monedas del tipo y cantidad especificados
    boolean sacarMonedas(double tipo, int unidades);

    // Vacía completamente la caja registradora
    void vaciarCajaRegistradora();

    // Devuelve un array con los tipos de monedas presentes en la caja
    double[] getTiposDeMonedas();

    // Devuelve el saldo total de la caja registradora
    double getSaldo();
}