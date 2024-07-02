# Web Help Desk Application

## Endpoints

### 1. Register new employee
*Request*: `POST /api/register`

#### 1.1 registering a new employee with a valid request body

*Request body*:
```json
{
    "email": "<username>@<domain>.<extension>",
    "password": "<string, at least 5 characters long>"
}
```

*Response*: `200 OK`

#### 1.2 registering a new employee with a valid request body but the email address is already taken
#### 1.3 registering a new employee with an invalid email
#### 1.4 registering a new employee with a too short password

*Request body*:
```json
{
    "email": "test@mail.org",
    "password": "strongpassword"
}
```

*Response*: `400 BAD REQUEST`
<hr/>

[<<](./README.md#auth-module)

### 4. Show all employees
*Request*: `GET /api/employee`

*Response*: `200 OK`

*Response body*:
```json
[
    {
	"id": 1,
	// employee details
    },
    {
	"id": 2,
	// employee details
    }
]
```
<hr/>

[<<](./README.md#employee-module)
