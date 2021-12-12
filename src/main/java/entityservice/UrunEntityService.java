package entityservice;

import dao.UrunDao;
import dto.UrunDetayDto;
import dto.ProductCommentsDto;
import entity.Urun;

import java.math.BigDecimal;
import java.util.List;

public class UrunEntityService {

    private UrunDao urunDao;

    public UrunEntityService() {
        urunDao = new UrunDao();
    }

    public List<Urun> findAll() {
        return urunDao.findAll();
    }

    public Urun findById(Long id) {
        return urunDao.findAById(id);
    }

    public List<Urun> findAllUrunListByFiyatGeAndFiyatLe(BigDecimal fiyatGe, BigDecimal fiyatLe) {
        return urunDao.findAllUrunListByFiyatGeAndFiyatLe(fiyatGe, fiyatLe);
    }

    public List<Urun> findAllUrunListByFiyatBetween(BigDecimal fiyatGe, BigDecimal fiyatLe) {
        return urunDao.findAllUrunListByFiyatBetween(fiyatGe, fiyatLe);
    }

    public List<Urun> findAllUrunByKategoriKirilim(Long kirilim) {
        return urunDao.findAllUrunListByKategoriKirilim(kirilim);
    }

    public List<UrunDetayDto> findAllUrunDetayDtoByKategoriKirilim(Long kirilim) {
        return urunDao.findAllUrunDetayDtoByKategoriKirilim(kirilim);
    }

    public List<ProductCommentsDto> findAllProductCommentsDto() {
        return urunDao.findAllProductCommentsDto();
    }
}
