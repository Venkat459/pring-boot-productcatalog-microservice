# spring-boot-productcatalog-microservice
This is simple product microservice developed using spring boot version 2.0.0
Below Dependencies are used

	spring-boot-starter-web
	spring-boot-starter-jetty
	spring-boot-starter-data-jpa
	com.h2database(runtime)
	spring-boot-starter-test(test)
	jdk 1.8

Note: By Default 5 records will be inserted as a default using data.sql file ids from 1 to 5.
Below Rest Resource APIs are designed.

1) POST (Create A single product resource)

	Request:  
		
	url:http://localhost:8080/products  
	httpmethod: post  
	httpheaders:  [accept:application/json]  
	Request Payload:  
	{
	
	"productName":"Spring boot 2 in Action",
	"productDescription": "Sprin boot 2 in Action- Description",
	"productType": "books",
	"price": 1000.0
	}
	
	Response payload:
	
	{
    "status": "success"
	}

2) GET (GET ALL PRODUCTS)

	Request:  
		
	url:http://localhost:8080/products  
	httpmethod: get  
	httpheaders:  [accept:application/json]  
	Request Payload:NA    
	
	
	Response Payload:  
	

  [
    {
        "id": 1,
        "productName": "HeadFirstDesign Design Patterns- Description",
        "productDescription": "HeadFirstDesign Design Patterns",
        "productType": "books",
        "price": 1000
    },
    {
        "id": 2,
        "productName": "HeadFirst Java- Description",
        "productDescription": "HeadFirst Java",
        "productType": "books",
        "price": 1000
    },
    {
        "id": 3,
        "productName": "Bicyle- Description",
        "productDescription": "Bicycle",
        "productType": "bicyles",
        "price": 1000
    },
    {
        "id": 4,
        "productName": "Toy- Description-1",
        "productDescription": "Toy1",
        "productType": "toys",
        "price": 100
    },
    {
        "id": 5,
        "productName": "Toy- Description-2",
        "productDescription": "Toy2",
        "productType": "toys",
        "price": 5000
    },
    {
        "id": 6,
        "productName": "Spring boot 2 in Action",
        "productDescription": "Sprin boot 2 in Action- Description",
        "productType": "books",
        "price": 1000
    }
]

	
3) GET (GET ALL PRODUCTS which productType is Books)

	Request Payload:  
		
	http://localhost:8080/products/prouductType/books
	httpmethod: get  
	httpheaders:  [accept:application/json]  
	Request Payload:NA    
	
	
	Response Payload:
	
	[
    {
        "id": 1,
        "productName": "HeadFirstDesign Design Patterns- Description",
        "productDescription": "HeadFirstDesign Design Patterns",
        "productType": "books",
        "price": 1000
    },
    {
        "id": 2,
        "productName": "HeadFirst Java- Description",
        "productDescription": "HeadFirst Java",
        "productType": "books",
        "price": 1000
    },
    {
        "id": 6,
        "productName": "Spring boot 2 in Action",
        "productDescription": "Sprin boot 2 in Action- Description",
        "productType": "books",
        "price": 1000
    }
]
	
4) GET (GET ALL PRODUCTS which productType is Toys)

	Request:  
		
	http://localhost:8080/products/prouductType/toys
	httpmethod: get  
	httpheaders:  [accept:application/json]  
	Request Payload:NA    
	
	
	Response Payload:
	
[
    {
        "id": 4,
        "productName": "Toy- Description-1",
        "productDescription": "Toy1",
        "productType": "toys",
        "price": 100
    },
    {
        "id": 5,
        "productName": "Toy- Description-2",
        "productDescription": "Toy2",
        "productType": "toys",
        "price": 5000
    }
]
	
	
5) GET (GET Single Product by productId)

	Request:  
		
	http://localhost:8080/products/1
	httpmethod: get  
	httpheaders:  [accept:application/json]  
	Request Payload:NA    
	
	
	Response payload:
	
	{
    "id": 1,
    "productName": "HeadFirstDesign Design Patterns- Description",
    "productDescription": "HeadFirstDesign Design Patterns",
    "productType": "books",
    "price": 1000
	}  

5) PUT (update Product by productId)

	Request:  
		
	http://localhost:8080/products/1
	httpmethod: put  
	httpheaders:  [accept:application/json]  
	Request Payload:    
	
	{
	
	"productName":"HeadFirst Java updated with 8-updated",
	"productDescription": "HeadFirst Java-updated with 8 - Description-updated"
	}
	
	Response payload:
	
	{ 
    "status": "success" 
	} 
	
6) DELETE (Delete product by productId)

	Request:  
		
	http://localhost:8080/products/6
	httpmethod: delete  
	httpheaders:  [accept:application/json]  
	Request Payload:NA    
	
	Response payload:
	
	
    {
    "status": "success"
	}
	}