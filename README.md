
# CREDIT-POLICY
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
	"customer_income": 1000,  
	"customer_debt": 500,  
	"payment_remarks_12m": 0,  
	"payment_remarks": 1,  
	"customer_age": 20  
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

#### example 1:

```json 
{  
	"customer_income": [  
		"This field is required."  
	],  
	"customer_debt": [  
		"This field is required."  
	],  
	"payment_remarks_12m": [  
		"This field is required."  
	],  
	"payment_remarks": [  
		"This field is required."  
	],  
	"customer_age": [  
		"This field is required."  
	]  
}
```

#### example 2:

```json 
{  
	"customer_income": [  
		"A valid integer is required."  
	],
	"customer_debt": [  
		"A valid integer is required."  
	],
	"payment_remarks_12m": [  
		"A valid integer is required."  
	],
	"payment_remarks": [  
		"A valid integer is required."  
	],
	"customer_age": [  
		"A valid integer is required."  
	]
}  
```  