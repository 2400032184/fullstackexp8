# Product Search Module - Spring Boot JPQL & Query Methods

A Spring Boot application demonstrating JPQL queries and derived query methods for product search functionality.

## Features

- **Category-based Search**: Find products by category
- **Price Filtering**: Filter products within a price range
- **Price Sorting**: Sort products by price
- **Price Range Queries**: Find products above a certain price

## Project Structure

```
src/main/java/com/ecommerce/
├── ProductSearchApplication.java
└── product/
    ├── entity/
    │   └── Product.java
    ├── repository/
    │   └── ProductRepository.java
    └── controller/
        └── ProductController.java
```

## Technologies Used

- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database
- Maven

## API Endpoints

### 1. Get All Products
```
GET /products
```

### 2. Get Products by Category
```
GET /products/category/{category}
Example: GET /products/category/Electronics
```

### 3. Filter Products by Price Range
```
GET /products/filter?min=500&max=5000
```

### 4. Get Products Sorted by Price
```
GET /products/sorted
```

### 5. Get Products Above a Price
```
GET /products/expensive/{price}
Example: GET /products/expensive/10000
```

### 6. Create a New Product
```
POST /products
Content-Type: application/json

{
  "name": "Product Name",
  "category": "Category",
  "price": 1000.00
}
```

## Sample Data

The application includes sample products in the following categories:
- **Electronics**: Laptop, Mouse, Keyboard, Monitor
- **Clothing**: T-Shirt, Jeans, Shoes, Jacket
- **Books**: Novel, Textbook, Magazine, Dictionary

## Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. Application starts on `http://localhost:8080`

## Testing with Postman

1. **Get all products**: `GET http://localhost:8080/products`
2. **Filter by category**: `GET http://localhost:8080/products/category/Electronics`
3. **Filter by price range**: `GET http://localhost:8080/products/filter?min=500&max=5000`
4. **Get sorted products**: `GET http://localhost:8080/products/sorted`
5. **Get expensive products**: `GET http://localhost:8080/products/expensive/10000`

## Database

The application uses H2 in-memory database. Access H2 Console at:
```
http://localhost:8080/h2-console
```

## Query Methods Implemented

### Derived Query Methods
- `findByCategory(String category)` - Find products by category
- `findByPriceBetween(Double min, Double max)` - Find products within price range

### JPQL Queries
- `findAllSortedByPrice()` - Get all products sorted by price
- `findProductsAbovePrice(Double price)` - Get products above a price
- `findByJpqlCategory(String category)` - Get products by category using JPQL
