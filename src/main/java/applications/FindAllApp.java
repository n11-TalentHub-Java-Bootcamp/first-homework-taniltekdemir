package applications;

import entity.Kategori;
import entity.Urun;
import entity.ProductComment;
import entityservice.KategoriEntitiyService;
import entityservice.UrunEntityService;
import entityservice.ProductCommentEntityService;

import java.util.List;

public class FindAllApp {

    public static void main(String[] args) {

        KategoriEntitiyService service = new KategoriEntitiyService();
        List<Kategori> kategoriList = service.findAll();
        for (Kategori kategori : kategoriList) {
            System.out.println(kategori);
        }

        UrunEntityService service1 = new UrunEntityService();
        List<Urun> urunList = service1.findAll();
        for (Urun urun : urunList) {
            System.out.println(urun);
        }

        ProductCommentEntityService service2 = new ProductCommentEntityService();
        List<ProductComment> productCommentList = service2.findAll();
        for (ProductComment productComment : productCommentList) {
            System.out.println(productComment);
        }

    }
}
