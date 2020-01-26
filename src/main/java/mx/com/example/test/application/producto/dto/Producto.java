package mx.com.example.test.application.producto.dto;


import mx.com.core.db.base.TipoLlamada;
import mx.com.core.db.base.TransaccionBaseStore;
import mx.com.core.db.param.Parameter;


public class Producto extends TransaccionBaseStore {
    @Parameter(targets = {TipoLlamada.CONSULTA})
    protected String idProducto;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String producto;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String costo;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String precio;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String codigoRapido;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String codigoBarras;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String tipoVentaProd;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String esGravable;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String esIEPS;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String esISH;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String estatus;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String idDepartamento;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String cantidadMinima;
    @Parameter(targets = {TipoLlamada.ALTA})
    protected String cantidadMaxima;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCodigoRapido() {
        return codigoRapido;
    }

    public void setCodigoRapido(String codigoRapido) {
        this.codigoRapido = codigoRapido;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getTipoVentaProd() {
        return tipoVentaProd;
    }

    public void setTipoVentaProd(String tipoVentaProd) {
        this.tipoVentaProd = tipoVentaProd;
    }

    public String getEsGravable() {
        return esGravable;
    }

    public void setEsGravable(String esGravable) {
        this.esGravable = esGravable;
    }

    public String getEsIEPS() {
        return esIEPS;
    }

    public void setEsIEPS(String esIEPS) {
        this.esIEPS = esIEPS;
    }

    public String getEsISH() {
        return esISH;
    }

    public void setEsISH(String esISH) {
        this.esISH = esISH;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(String cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(String cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }
}
