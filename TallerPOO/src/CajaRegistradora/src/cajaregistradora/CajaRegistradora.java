
package cajaregistradora;

class CajaRegistradora implements ICajaRegistradora {
    private String nombre;
    private double[] tiposMonedas;
    private int[] unidadesMonedas;

    // Constructor de la clase CajaRegistradora
    public CajaRegistradora(String nombre) {
        this.nombre = nombre;
        this.tiposMonedas = new double[0]; // Inicializa el array de tipos de monedas vacío
        this.unidadesMonedas = new int[0]; // Inicializa el array de unidades de monedas vacío
    }

    @Override
    public String getNombre() {
        return this.nombre; // Devuelve el nombre de la caja
    }

    @Override
    public int getNumTipoMonedas() {
        return tiposMonedas.length; // Devuelve el número de tipos de monedas presentes en la caja
    }

    @Override
    public int getUnidadesTipoMoneda(double tipo) {
        // Devuelve la cantidad de unidades del tipo de moneda especificado
        for (int i = 0; i < tiposMonedas.length; i++) {
            if (tiposMonedas[i] == tipo) {
                return unidadesMonedas[i];
            }
        }
        return -1; // Si el tipo de moneda no se encuentra, devuelve -1
    }

    @Override
    public boolean meterMonedas(double tipo, int unidades) {
        // Ingresa monedas del tipo y cantidad especificados
        if (monedaValida(tipo) && unidades > 0) {
            int index = -1;
            // Busca si ya existe el tipo de moneda en la caja
            for (int i = 0; i < tiposMonedas.length; i++) {
                if (tiposMonedas[i] == tipo) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                // Si el tipo de moneda ya existe, agrega las unidades a las existentes
                unidadesMonedas[index] += unidades;
            } else {
                // Si el tipo de moneda no existe, agrega un nuevo tipo y sus unidades
                double[] newTiposMonedas = new double[tiposMonedas.length + 1];
                int[] newUnidadesMonedas = new int[unidadesMonedas.length + 1];
                for (int i = 0; i < tiposMonedas.length; i++) {
                    newTiposMonedas[i] = tiposMonedas[i];
                    newUnidadesMonedas[i] = unidadesMonedas[i];
                }
                newTiposMonedas[newTiposMonedas.length - 1] = tipo;
                newUnidadesMonedas[newUnidadesMonedas.length - 1] = unidades;
                tiposMonedas = newTiposMonedas;
                unidadesMonedas = newUnidadesMonedas;
            }
            return true;
        }
        return false; // Si los parámetros no son válidos, devuelve false
    }

    @Override
    public boolean monedaValida(double tipo) {
        // Implementación de la validación de moneda
        return true; // En esta implementación siempre devuelve true
    }

    @Override
    public boolean sacarMonedas(double tipo, int unidades) {
        // Extrae monedas del tipo y cantidad especificados
        if (monedaValida(tipo)) {
            for (int i = 0; i < tiposMonedas.length; i++) {
                if (tiposMonedas[i] == tipo) {
                    if (unidadesMonedas[i] >= unidades) {
                        unidadesMonedas[i] -= unidades;
                        return true; // Si se pudo realizar la operación, devuelve true
                    } else {
                        return false; // Si no hay suficientes unidades, devuelve false
                    }
                }
            }
        }
        return false; // Si el tipo de moneda no es válido, devuelve false
    }

    @Override
    public void vaciarCajaRegistradora() {
        // Vacía completamente la caja registradora
        tiposMonedas = new double[0]; // Reinicia el array de tipos de monedas
        unidadesMonedas = new int[0]; // Reinicia el array de unidades de monedas
    }

    @Override
    public double[] getTiposDeMonedas() {
        return tiposMonedas; // Devuelve un array con los tipos de monedas presentes en la caja
    }

    @Override
    public double getSaldo() {
        // Calcula y devuelve el saldo total de la caja registradora
        double saldo = 0.0;
        for (int i = 0; i < tiposMonedas.length; i++) {
            saldo += tiposMonedas[i] * unidadesMonedas[i];
        }
        return saldo;
    }
}