# spring-boot-productcatalog-microservice
This is simple product microservice developed using spring boot version 2.0.0
Below Dependencies are used

	spring-boot-starter-web
	spring-boot-starter-jetty
	spring-boot-starter-data-jpa
	com.h2database(runtime)
	spring-boot-starter-test(test)
	jdk 1.8

Below Rest Resource APIs are designed.

1) POST (Create A single product resource)

	Request:  
		
	url:http://localhost:8080/products  
	httpmethod: post  
	httpheaders:  [accept:application/json]  
	Request Payload:  
	{
	
	"productName":"HeadFirstDesign Design Patterns",
	"productDescription": "HeadFirstDesign Design Patterns- Description",
	"productType": "books",
	"price": 1000.0
	}
	
	Response:
	
	{
    "status": "success"
	}
