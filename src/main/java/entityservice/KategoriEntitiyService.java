package entityservice;

import dao.KategoriDao;
import entity.Kategori;

import java.util.List;

public class KategoriEntitiyService {

    private KategoriDao kategoriDao;

    public KategoriEntitiyService() {
        kategoriDao = new KategoriDao();
    }

    public List<Kategori> findAll() {
        return kategoriDao.findAll();
    }
}
