package webshop.domain;

/**
 * @author yahia
 * @created Jul 19, 2020 - 7:20:42 AM
 * @project WebShop
 */
public class OrderLine {
    private int quantity;
    private Product product;

    public OrderLine() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
