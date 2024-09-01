package de.ait.shop42.product.service;

import de.ait.shop42.product.dto.ProductRequestDTO;
import de.ait.shop42.product.dto.ProductResponseDTO;
import de.ait.shop42.product.entity.Product;
import de.ait.shop42.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.ProviderNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll().stream()
                .map(p->mapper.map(p,ProductResponseDTO.class))
                .toList();
    }


    @Override
    public ProductResponseDTO createNewProduct(ProductRequestDTO dto) {
        Product entity = mapper.map(dto, Product.class); // dto -> product
        entity = repository.save(entity);
        return mapper.map(entity,ProductResponseDTO.class);// entity -> dto
    }

    @Override
    @Transactional
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {
        Product entity = mapper.map(dto, Product.class); //dto -> entity
        entity.setId(id);
        entity = repository.save(entity);
        return mapper.map(entity,ProductResponseDTO.class); // entity -> dto
    }

    @Override
    @Transactional
    public ProductResponseDTO setActiveStatus(Long id, boolean active) {
        String exceptionMsg = "Change active status fail. Product id %d not found";
        Product productEntity = repository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundException(String.format(exceptionMsg,id)));

        productEntity.setActive(active);

        return mapper.map(productEntity,ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> getProducts(Boolean active) {
        if(active==null){
            return getAllProducts();
        } else {
            List<Product> productByActive = repository.findByActive(active);
            return productByActive.stream()
                    .map(p->mapper.map(p,ProductResponseDTO.class))
                    .toList();
        }
    }
}
