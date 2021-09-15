# API SPEC
Berikut ini merupakan list API yang dapat di akses oleh kawan-kawan :
## CREATE PRODUCT
- Method : POST
- Endpoint : `/api/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json

Request :
 ```json
{
  "id": "string,unique",
  "name": "string",
  "price": "long",
  "quantity": "integer",
  "createdAt": "date",
  "updatedAt":"date"    
} 
```
 Response :
 ```json
{
  "code": "number",
  "status": "string",
  "data" :{
            "id": "string,unique",
            "name": "string",
            "price": "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt":"date"    
          } 
}
```


## GET PRODUCT
- Method : GET
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type: application/json
    - Accept: application/json

Response :
 ```json
{
  "code": "number",
  "status": "string",
  "data" :{
            "id": "string,unique",
            "name": "string",
            "price": "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt":"date"    
          } 
} 
```
## UPDATE PRODUCT
- Method : PUT
- Endpoint : `/api/products/{id_product}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
    
Request :
 ```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer",
  "createdAt": "date",
  "updatedAt":"date"    
} 
```
 Response :
 ```json
{
  "code": "number",
  "status": "string",
  "data" :{
            "id": "string,unique",
            "name": "string",
            "price": "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt":"date"    
          } 
} 
```
## LIST PRODUCT
- Method : GET
- Endpoint : `/api/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Query Parameter:
    - size : number
    - page : number
Response :
 ```json
{
  "code": "number",
  "status": "string",
  "data" :[{
            "id": "string,unique",
            "name": "string",
            "price": "long",
            "quantity": "integer",
            "createdAt": "date",
            "updatedAt":"date"    
          },
          {
            "id": "string,unique",
            "name": "string",
            "price": "long",
            "createdAt": "date",
            "updatedAt":"date"    
          }] 
} 
```
## DELETE PRODUCT
- Method : DELETE
- Endpoint : `/api/product/{id_product}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
Response :
 ```json
{
  "code": "number",
  "status": "string"
} 
```