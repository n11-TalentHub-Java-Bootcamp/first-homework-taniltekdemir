package applications;

import dto.CommentsOfaProductDto;
import entityservice.ProductCommentEntityService;

import java.util.List;

public class FindProductCommentsByProductIdApp {

    public static void main(String[] args) {
        ProductCommentEntityService service = new ProductCommentEntityService();
        List<CommentsOfaProductDto> commentsOfaProductDtos = service.findAllCommentsOfaProductDtoByProductId(1L);

        for (CommentsOfaProductDto commentsOfaProductDto : commentsOfaProductDtos) {
            System.out.println(commentsOfaProductDto);
        }
    }
}
