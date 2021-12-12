package applications;

import dto.CommentDetailDto;
import entityservice.ProductCommentEntityService;

import java.util.List;

public class FindAllCommentsByUserId {

    public static void main(String[] args) {
        ProductCommentEntityService productCommentEntityService = new ProductCommentEntityService();
        List<CommentDetailDto> allCommentDetailDto = productCommentEntityService.findAllCommentDetailDtoByUserId(4L);
        for (CommentDetailDto commentDetailDto : allCommentDetailDto) {
            System.out.println(commentDetailDto);
        }
    }
}
