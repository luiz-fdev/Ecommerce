package com.unifacisa.ecommerce.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unifacisa.ecommerce.entities.pk.CartItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cart_item")
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CartItemPk id = new CartItemPk();

    private Integer quantity;
    private double price;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product, Integer quantity, double price) {
        if (cart != null && product != null) {
            this.id.setCart(cart);
            this.id.setProduct(product);
            this.quantity = quantity;
            this.price = price;
        } else {
            throw new IllegalArgumentException("Cart and Product cannot be null");
        }
    }

    @JsonIgnore
    public Cart getCart() {
        return id.getCart();
    }

    public void setCart(Cart cart) {
        if (cart != null) {
            this.id.setCart(cart);
        } else {
            throw new IllegalArgumentException("Cart cannot be null");
        }
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.id.setProduct(product);
        } else {
            throw new IllegalArgumentException("Product cannot be null");
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CartItem other = (CartItem) obj;
        return Objects.equals(id, other.id);
    }
}