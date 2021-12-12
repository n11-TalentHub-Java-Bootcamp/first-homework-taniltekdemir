package dao;

import base.BaseDao;
import dto.UrunDetayDto;
import dto.ProductCommentsDto;
import entity.Urun;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class UrunDao extends BaseDao {

    public List<Urun> findAll() {

        String sql = "SELECT urun FROM Urun urun";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    public Urun findAById(Long id) {

        String sql = "SELECT urun FROM Urun urun WHERE urun.id = :givenId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("givenId", id);

        return (Urun) query.uniqueResult();
    }

    public List<Urun> findAllUrunListByFiyatGeAndFiyatLe(BigDecimal fiyatGe, BigDecimal fiyatLe) {

        String sql = "SELECT urun FROM Urun urun WHERE 1=1 ";

        if (fiyatGe != null) {
            sql = sql + " and urun.fiyat >= :fiyatGe";
        }

        if (fiyatLe != null) {
            sql = sql + " and urun.fiyat <= :fiyatLe";
        }
        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("fiyatGe", fiyatGe);
        query.setParameter("fiyatLe", fiyatLe);

        return query.list();
    }

    public List<Urun> findAllUrunListByFiyatBetween(BigDecimal fiyatGe, BigDecimal fiyatLe) {

        String sql = "SELECT urun FROM Urun urun WHERE 1=1 ";

        if (fiyatGe != null && fiyatLe != null) {
            sql = sql + " and urun.fiyat between :fiyatGe and :fiyatLe";
        }

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("fiyatGe", fiyatGe);
        query.setParameter("fiyatLe", fiyatLe);

        return query.list();
    }

    public List<Urun> findAllUrunListByKategoriKirilim(Long kirilim) {
        String sql = "SELECT urun FROM Urun urun " +
                "left join Kategori kategori on urun.kategori.id = kategori.id " +
                "where kategori.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public List<UrunDetayDto> findAllUrunDetayDtoByKategoriKirilim(Long kirilim) {
        String sql = "SELECT new dto.UrunDetayDto(urun.adi, kategori.adi, urun.fiyat) " +
                "FROM Urun urun " +
                "left join Kategori kategori on urun.kategori.id = kategori.id " +
                "where kategori.kirilim = :kirilim ";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("kirilim", kirilim);

        return query.list();
    }

    public List<ProductCommentsDto> findAllProductCommentsDto() {

        String sql = "SELECT new dto.ProductCommentsDto(urun.id, urun.adi, urun.fiyat, nullif (count(productComment) , 0) )" +
                " FROM Urun urun" +
                " left join ProductComment productComment on productComment.urun.id = urun.id" +
                " group by urun.id";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }
}
