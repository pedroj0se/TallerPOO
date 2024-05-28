
package parcialtres;


public interface IFabricaDeTrajes {
    void añadirComponenteAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException;
    void listarComponentes();
    void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeExisteException;
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvio();
    void crearComponentesDePrueba();
}





