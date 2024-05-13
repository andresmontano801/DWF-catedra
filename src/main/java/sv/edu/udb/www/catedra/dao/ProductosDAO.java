package sv.edu.udb.www.catedra.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sv.edu.udb.www.catedra.ProductosUtil;
import sv.edu.udb.www.catedra.ProductosEntity;

import java.util.List;

public class ProductosDAO {
    public void addProducto(ProductosEntity productos){
        SessionFactory sesFact = ProductosUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            ses.save(productos);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.close();
        }
    }
    public void deleteProducto(Integer idProducto){
        SessionFactory sesFact = ProductosUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            ProductosEntity producto = (ProductosEntity)
                    ses.get(ProductosEntity.class,idProducto);
            ses.delete(producto);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.close();
        }
    }
    public void updateProducto(Integer idProducto, ProductosEntity newProductos){
        SessionFactory sesFact = ProductosUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            ProductosEntity producto = (ProductosEntity)
                    ses.load(ProductosEntity.class,idProducto);
            producto.setId(producto.getId());
            producto.setMarca(newProductos.getMarca());
            producto.setModelo(newProductos.getModelo());
            producto.setPrecio(newProductos.getPrecio());
            producto.setTalla(newProductos.getTalla());
            producto.setColor(newProductos.getColor());
            producto.setStock(newProductos.getStock());


            ses.update(producto);
            ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.close();
        }
    }
    public ProductosEntity getProductoID(Integer idProducto){
        ProductosEntity producto = null;
        SessionFactory sesFact = ProductosUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            String queryString = "from ProductosEntity where id = :idFind";
            Query query = ses.createQuery(queryString);
            query.setParameter("idFind", idProducto);
            producto = (ProductosEntity) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.close();
        }
        return producto;
    }
    public List<ProductosEntity> obtenerProductos(){
        List<ProductosEntity> productos = null;
        SessionFactory sesFact = ProductosUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
        try {
            tra=ses.beginTransaction();
            String queryString = "from ProductosEntity ";
            Query query = ses.createQuery(queryString);
            productos= query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.close();
        }
        return productos;
    }
        }
