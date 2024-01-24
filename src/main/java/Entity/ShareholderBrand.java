package Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShareholderBrand {
    private int shareholderBrandId;
    private int shareholderId;
    private int brandId;

    public ShareholderBrand(int shareholderId, int brandId) {
        this.shareholderId=shareholderId;
        this.brandId=brandId;
    }

    public void setShareholderBrand(int shareholderId,int brandId){
    this.shareholderId=shareholderId;
    this.brandId=brandId;
    }
}
