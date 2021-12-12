package applications;

import dto.ProductCommentsDto;
import entityservice.UrunEntityService;

import java.util.List;

public class FindAllProductComments {

    public static void main(String[] args) {
        UrunEntityService service = new UrunEntityService();
        List<ProductCommentsDto> allProductCommentsDto = service.findAllProductCommentsDto();
        for (ProductCommentsDto productCommentsDto : allProductCommentsDto) {
            System.out.println(productCommentsDto);
        }
    }
}
