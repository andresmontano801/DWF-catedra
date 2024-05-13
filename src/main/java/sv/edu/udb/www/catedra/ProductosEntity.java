package sv.edu.udb.www.catedra;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductosEntity {
    @Id
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int talla;
    private int stock;
    private String color;

    public ProductosEntity() {
    }

    public ProductosEntity(String marca, String modelo, String color, double precio, int talla, int stock) {
    }

    public ProductosEntity(String marca, String modelo, double precio, String color, int talla, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.color = color;
        this.talla = talla;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosEntity that = (ProductosEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.precio, precio) != 0) return false;
        if (talla != that.talla) return false;
        if (stock != that.stock) return false;
        if (marca != null ? !marca.equals(that.marca) : that.marca != null) return false;
        if (modelo != null ? !modelo.equals(that.modelo) : that.modelo != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + talla;
        result = 31 * result + stock;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
