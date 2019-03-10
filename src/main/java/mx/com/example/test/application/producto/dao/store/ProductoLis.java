package mx.com.example.test.application.producto.dao.store;

import mx.com.core.db.BaseStore;

public class ProductoLis extends BaseStore {
    private int par_IDProducto;
    private String par_Producto;
    private Double par_Costo;
    private Double par_Precio;
    private String par_CodigoRapido;
    private String par_CodigoBarras;
    private String par_TipoVentaProd;
    private String par_EsGravable;
    private String par_EsIEPS;
    private String par_EsISH;
    private String par_Estatus;
    private int par_IDDepartamento;
    private Double par_CantidadMinima;
    private Double par_CantidadMaxima;
    private int par_NumOpcion;


    public int getPar_IDProducto() {
        return par_IDProducto;
    }

    public void setPar_IDProducto(int par_IDProducto) {
        this.par_IDProducto = par_IDProducto;
    }

    public String getPar_Producto() {
        return par_Producto;
    }

    public void setPar_Producto(String par_Producto) {
        this.par_Producto = par_Producto;
    }

    public Double getPar_Costo() {
        return par_Costo;
    }

    public void setPar_Costo(Double par_Costo) {
        this.par_Costo = par_Costo;
    }

    public Double getPar_Precio() {
        return par_Precio;
    }

    public void setPar_Precio(Double par_Precio) {
        this.par_Precio = par_Precio;
    }

    public String getPar_CodigoRapido() {
        return par_CodigoRapido;
    }

    public void setPar_CodigoRapido(String par_CodigoRapido) {
        this.par_CodigoRapido = par_CodigoRapido;
    }

    public String getPar_CodigoBarras() {
        return par_CodigoBarras;
    }

    public void setPar_CodigoBarras(String par_CodigoBarras) {
        this.par_CodigoBarras = par_CodigoBarras;
    }

    public String getPar_TipoVentaProd() {
        return par_TipoVentaProd;
    }

    public void setPar_TipoVentaProd(String par_TipoVentaProd) {
        this.par_TipoVentaProd = par_TipoVentaProd;
    }

    public String getPar_EsGravable() {
        return par_EsGravable;
    }

    public void setPar_EsGravable(String par_EsGravable) {
        this.par_EsGravable = par_EsGravable;
    }

    public String getPar_EsIEPS() {
        return par_EsIEPS;
    }

    public void setPar_EsIEPS(String par_EsIEPS) {
        this.par_EsIEPS = par_EsIEPS;
    }

    public String getPar_EsISH() {
        return par_EsISH;
    }

    public void setPar_EsISH(String par_EsISH) {
        this.par_EsISH = par_EsISH;
    }

    public String getPar_Estatus() {
        return par_Estatus;
    }

    public void setPar_Estatus(String par_Estatus) {
        this.par_Estatus = par_Estatus;
    }

    public int getPar_IDDepartamento() {
        return par_IDDepartamento;
    }

    public void setPar_IDDepartamento(int par_IDDepartamento) {
        this.par_IDDepartamento = par_IDDepartamento;
    }

    public Double getPar_CantidadMinima() {
        return par_CantidadMinima;
    }

    public void setPar_CantidadMinima(Double par_CantidadMinima) {
        this.par_CantidadMinima = par_CantidadMinima;
    }

    public Double getPar_CantidadMaxima() {
        return par_CantidadMaxima;
    }

    public void setPar_CantidadMaxima(Double par_CantidadMaxima) {
        this.par_CantidadMaxima = par_CantidadMaxima;
    }

    public int getPar_NumOpcion() {
        return par_NumOpcion;
    }

    public void setPar_NumOpcion(int par_NumOpcion) {
        this.par_NumOpcion = par_NumOpcion;
    }
}
