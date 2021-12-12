package entityservice;

import dao.ProductCommentDao;
import dto.CommentDetailDto;
import dto.CommentsOfaProductDto;
import entity.ProductComment;

import java.util.List;

public class ProductCommentEntityService {

    private ProductCommentDao productCommentDao;

    public ProductCommentEntityService() { productCommentDao = new ProductCommentDao();}

    public List<ProductComment> findAll() { return productCommentDao.findAll();}

    public List<CommentsOfaProductDto> findAllCommentsOfaProductDtoByProductId(Long urunId) {
        return productCommentDao.findAllCommentsOfaProductDtoByProductId(urunId);
    }
    public List<CommentDetailDto> findAllCommentDetailDtoByUserId(Long userId) {
        return productCommentDao.findAllCommentDetailDtoByUserId(userId);
    }
}
