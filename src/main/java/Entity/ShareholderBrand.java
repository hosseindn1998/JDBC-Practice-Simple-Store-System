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
    public void setShareholderBrand(int shareholderId,int brandId){
    this.shareholderId=shareholderId;
    this.brandId=brandId;
    }
}
