package com.sep.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.sep.pojos.Product;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This class provides methods for reading data from a JSON file and returning it as objects.
 * The data is stored in the file "src/test/resources/test_data/qa_data.json", which is a JSON array of objects.
 */
public class QaDataReader {

    private final static String path = "src/test/resources/test_data/qa_data.json";

    /**
     * This method returns a single product based on the program ID.
     *
     * @param programCode The program ID of the product to retrieve.
     * @return The product with the specified program ID, or null if no product with the specified ID exists.
     */
    public static Product getSingleProduct(String programCode) {
        Product product = null;
        for (Product eachProduct : getAllProducts()) {
            if (eachProduct.getProgramCode().equalsIgnoreCase(programCode)) {
                product = eachProduct;
            }
        }
        return product;
    }

    /**
     * This method returns all products stored in the JSON file.
     *
     * @return A list of all products stored in the JSON file.
     */
    public static List<Product> getAllProducts() {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Product.class);
        List<Product> products = null;

        try {
            products = mapper.readValue(file, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

}
