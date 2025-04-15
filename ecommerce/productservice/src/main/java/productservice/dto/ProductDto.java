package productservice.dto;

public class ProductDto {
    int productId;
    String productName;
    int orderId;
    String orderName;
    int quantity;
    int price;
    String tansactionId;
    String status;
    public ProductDto(){

    }
    public ProductDto(int productId, String productName, int orderId, String orderName, int quantity, int price, String tansactionId, String status) {
        this.productId = productId;
        this.productName = productName;
        this.orderId = orderId;
        this.orderName = orderName;
        this.quantity = quantity;
        this.price = price;
        this.tansactionId = tansactionId;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTansactionId() {
        return tansactionId;
    }

    public void setTansactionId(String tansactionId) {
        this.tansactionId = tansactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
