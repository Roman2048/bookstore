package nextg.bookstore.domain.dto;

public class ShopAndSalesDto {

    private Long shopId;

    private String shopAddress;

    private Integer soldBooksCount;

    public ShopAndSalesDto() {
    }

    public ShopAndSalesDto(Long shopId, String shopAddress, Integer soldBooksCount) {
        this.shopId = shopId;
        this.shopAddress = shopAddress;
        this.soldBooksCount = soldBooksCount;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Integer getSoldBooksCount() {
        return soldBooksCount;
    }

    public void setSoldBooksCount(Integer soldBooksCount) {
        this.soldBooksCount = soldBooksCount;
    }
}
