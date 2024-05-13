package sv.edu.udb.www.catedra.managedbean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import sv.edu.udb.www.catedra.dao.ProductosDAO;
import sv.edu.udb.www.catedra.ProductosEntity;


import java.util.List;

@ManagedBean
@SessionScoped

public class ProductosBean {
    private Integer id;
    private String marca;
    private String modelo;
    private double precio;
    private String color;
    private int talla;
    private int stock;


    public ProductosBean() {
    }
    public void addProducto(){
        ProductosDAO productoDao = new ProductosDAO();
        ProductosEntity producto = new ProductosEntity(marca, modelo, precio, color, talla, stock);
        productoDao.addProducto(producto);
    }
    public void returnProductoId(){
        ProductosDAO productoDao = new ProductosDAO();
        ProductosEntity producto = productoDao.getProductoID(getId()) ;
        if(producto != null){
            setId(producto.getId());
            setMarca(producto.getMarca() );
            setModelo(producto.getModelo());
            setPrecio(producto.getPrecio());
            setTalla(producto.getTalla());
            setColor(producto.getColor());
            setStock(producto.getStock());
        }else{
            setId(0);
            setMarca("");
            setModelo("");
            setPrecio(0);
            setTalla(0);
            setColor("");
            setStock(0);
            FacesContext.getCurrentInstance().addMessage(null, new
                    FacesMessage("Producto NO especificado"));
        }
    }
    public String deleteProducto(){
        ProductosDAO productoDao = new ProductosDAO();
        ProductosEntity producto = productoDao.getProductoID(getId()) ;
        if(producto != null){
            productoDao.deleteProducto(getId());
            setId(getId());
            setMarca("");
            setModelo("");
            setPrecio(0);
            setTalla(0);
            setColor("");
            setStock(0);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Producto con ID " + getId() + " Eliminado" ));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Producto con ID " + getId() + " NO encontrado" ));
        }
        return "Producto";
    }

    public String venderProducto(){
        ProductosDAO productoDao = new ProductosDAO();
        ProductosEntity producto = productoDao.getProductoID(getId()) ;
        if(producto != null){
            productoDao.deleteProducto(getId());
            setId(getId());
            setMarca("");
            setModelo("");
            setPrecio(0);
            setTalla(0);
            setColor("");
            setStock(0);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Producto con ID " + getId() + " Vendido" ));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Producto con ID " + getId() + " NO encontrado" ));
        }
        return "Producto";
    }
    public String updateProducto(){
        ProductosDAO productoDao = new ProductosDAO();
        ProductosEntity obtemproducto = productoDao.getProductoID(getId()) ;
        if(obtemproducto != null){
            ProductosEntity producto = new ProductosEntity(marca, modelo,color, precio, talla, stock);
            productoDao.updateProducto(getId(), producto);
            obtemproducto = productoDao.getProductoID(getId()) ;
            setId(obtemproducto.getId());
            setMarca(obtemproducto.getMarca() );
            setModelo(obtemproducto.getModelo());
            setPrecio(obtemproducto.getPrecio());
            setTalla(obtemproducto.getTalla());
            setColor(obtemproducto.getColor());
            setStock(obtemproducto.getStock());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Producto con ID " + getId() + " Actualizado" ));
        }else{
            setId(0);
            setMarca("");
            setModelo("");
            setPrecio(0);
            setTalla(0);
            setColor("");
            setStock(0);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Producto con ID " + getId() + " NO encontrado" ));
        }
        return "Producto";
    }
    public List<ProductosEntity> getProductos(){
        ProductosDAO productoDao = new ProductosDAO();
        List<ProductosEntity> lista = productoDao.obtenerProductos();
        return lista;
    }

/**
 * @return the id
 */
public Integer getId() {
    return id;
}
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @return the modelo
     */
    public String getMarca() {
        return marca;
    }
    /**
     * @param marca the modelo to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * @param precio the edad to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }
    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * @return the color
     */
    public int getTalla() {
        return talla;
    }
    /**
     * @param talla the talla to set
     */
    public void setTalla(int talla) {
        this.talla = talla;
    }
    /**
     * @talla the talla
     */
    public int getStock() {
        return stock;
    }
    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * @stock the stock
     */
}

