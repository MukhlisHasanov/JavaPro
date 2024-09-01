import app.controller.ProductController;
import app.repository.ProductRepository;
import app.repository.ProductRepositoryImpl;
import app.service.ProductService;
import app.service.ProductServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".app");
        ProductController controller = context.getBean(ProductController.class);

/**
        ProductRepository repository = new ProductRepositoryImpl();
        ProductService service = new ProductServiceImpl(repository);
        ProductController controller = new ProductController(service);
*/
        System.out.println(controller.getAllProducts());
    }
}