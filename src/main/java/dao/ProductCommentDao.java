package dao;

import base.BaseDao;
import dto.CommentDetailDto;
import dto.CommentsOfaProductDto;
import entity.ProductComment;
import org.hibernate.query.Query;

import java.util.List;

public class ProductCommentDao extends BaseDao {

    public List<ProductComment> findAll() {

        String sql = "SELECT prodcutComment FROM ProductComment prodcutComment";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    public List<CommentsOfaProductDto> findAllCommentsOfaProductDtoByProductId(Long productId) {

        String sql = "SELECT new dto.CommentsOfaProductDto(urun.adi, urun.kategori.adi, urun.fiyat, user.name, user.surname, user.email, user.phone, prodcutComment.comment, prodcutComment.comment_date)" +
                " FROM ProductComment prodcutComment" +
                " left join User user on prodcutComment.user.id = user.id" +
                " left join Urun urun on prodcutComment.urun.id = urun.id" +
                " where urun.id = :productId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("productId", productId);

        return query.list();
    }

    public List<CommentDetailDto> findAllCommentDetailDtoByUserId(Long userId) {

        String sql = "SELECT new dto.CommentDetailDto(user.id, user.name, productComment.urun.adi, productComment.comment, productComment.comment_date)" +
                " FROM ProductComment productComment" +
                " left join User user on productComment.user.id = user.id " +
                " where user.id = :userId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("userId", userId);

        return query.list();
    }
}
