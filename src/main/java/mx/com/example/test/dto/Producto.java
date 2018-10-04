package mx.com.example.test.dto;

public class Producto {
    private int idProducto;
    private String producto;
    private Double costo;
    private Double precio;
    private String codigoRapido;
    private String codigoBarras;
    private String tipoVentaProd;
    private boolean esGravable;
    private boolean esIEPS;
    private boolean esISH;
    private boolean estatus;
    private int idDepartamento;
    private double cantidadMinima;
    private double cantidadMaxima;


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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

    public boolean isEsGravable() {
        return esGravable;
    }

    public void setEsGravable(boolean esGravable) {
        this.esGravable = esGravable;
    }

    public boolean isEsIEPS() {
        return esIEPS;
    }

    public void setEsIEPS(boolean esIEPS) {
        this.esIEPS = esIEPS;
    }

    public boolean isEsISH() {
        return esISH;
    }

    public void setEsISH(boolean esISH) {
        this.esISH = esISH;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public double getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public double getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(double cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }
}
