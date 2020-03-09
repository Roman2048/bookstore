package nextg.bookstore.domain.dto;

public class ShopAndSalesDto {

    private Long shopId;

    private Long shopAddress;

    private Integer soldBooksCount;

    private Integer summarySale;

    public ShopAndSalesDto() {
    }

    public ShopAndSalesDto(Long shopId, Long shopAddress, Integer soldBooksCount, Integer summarySale) {
        this.shopId = shopId;
        this.shopAddress = shopAddress;
        this.soldBooksCount = soldBooksCount;
        this.summarySale = summarySale;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Long shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Integer getSoldBooksCount() {
        return soldBooksCount;
    }

    public void setSoldBooksCount(Integer soldBooksCount) {
        this.soldBooksCount = soldBooksCount;
    }

    public Integer getSummarySale() {
        return summarySale;
    }

    public void setSummarySale(Integer summarySale) {
        this.summarySale = summarySale;
    }
}
