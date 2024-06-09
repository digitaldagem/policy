# POLICY
A java service developed using the Spring Boot Framework for processing credit policy requests.

## How to run locally:
`make up`
## How to stop running service:
`make down`

# Endpoint:

## Create a new policy:
`POST :8000/post_policy`

### An example request payload:

```json 
{  
	"customerAge": 20,
	"customerDebt": 500,  
	"customerIncome": 1000,
	"paymentRemarks": 1,
	"paymentRemarks12m": 0
}  
```  

### An example 200 ok response:

```json 
{  
	"response": "LOW_INCOME"  
}
```

### An example 201 created response:

```json 
{  
	"response": "ACCEPTED"  
}  
```  

### 2 example 400 bad request responses:

#### (if any field is missing)

``` 
not a valid request object
```
