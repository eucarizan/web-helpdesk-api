# Web Help Desk Application
RESTful API for a Web Help Desk Application

## REST API 

### Auth

- [ ] [`POST /api/register`](#register-new-employee): Register new employee
- [ ] `POST /api/login` : Logging in an employee
- [ ] `POST /api/logout` : Logging out of an employee

### Employee module

- [x] `GET /api/employee` : Show all employees
- [x] `GET /api/employee/{id}` : Show a specific employee by specified id
- [x] `POST /api/employee` : Create a new employee
- [x] `PUT /api/employee/{id}` : Update employee details by specified id
- [x] `DELETE /api/employee/{id}` : Remove an employee by specified id
- [ ] `POST /api/employee/{employee-id}/assign-ticket/{ticket-id}` : Assign a ticket to an employee
- [ ] `POST /api/employee/{employee-id}/watch-ticket/{ticket-id}` : Add a watched ticket to an employee

### Ticket module

- [x] `GET /api/ticket` : Show all ticket
- [x] `GET /api/ticket/{id}` : Show a specific ticket by specified id
- [x] `POST /api/ticket` : Create a new ticket
- [x] `PUT /api/ticket/{id}` : Update ticket details by specified id
- [x] `DELETE /api/ticket/{id}` : Remove a ticket by specified id

<hr/>

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
