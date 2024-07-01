# Web Help Desk Application
RESTful API for a Web Help Desk Application

## REST API 

### Auth

- [ ] [`POST /api/register`](#1-register-new-employee) : Register new employee
- [ ] `POST /api/login` : Logging in an employee
- [ ] `POST /api/logout` : Logging out of an employee

### Employee module

- [ ] all request with authentication
- [ ] all request with authorization
- [ ] [`GET /api/employee`](#4-show-all-employees) : Show all employees
  - [ ] get with pagination
- [x] `GET /api/employee/{id}` : Show a specific employee by specified id
- [x] `POST /api/employee` : Create a new employee
- [x] `PUT /api/employee/{id}` : Update employee details by specified id
- [x] `DELETE /api/employee/{id}` : Remove an employee by specified id
  - [x] : Remove only if there is no assigned ticket

### Ticket module

- [ ] all request with authentication
- [ ] all request with authorization
- [ ] `GET /api/ticket` : Show all ticket
  - [ ] get with pagination
- [x] `GET /api/ticket/{id}` : Show a specific ticket by specified id
- [ ] `POST /api/ticket` : Create a new ticket
  - [x] : new ticket without assignee
  - [ ] : new ticket with assignee
  - [x] : new ticket without watcher/s
  - [ ] : new ticket with watcher/s
- [ ] `PUT /api/ticket/{id}` : Update ticket details by specified id
  - [ ] : update ticket add assignee
  - [ ] : update ticket remove assignee
  - [ ] : update ticket add watcher/s
  - [ ] : update ticket remove watcher/s
- [x] `DELETE /api/ticket/{id}` : Remove a ticket by specified id
- [x] `POST /api/ticket/{ticket-id}/assign/{employee-id}` : Assign a ticket to an employee
  - [x] : can only be assigned once
- [x] `POST /api/ticket/{ticket-id}/watch/{employee-id}` : Add a watched ticket to an employee
- [x] `GET /api/ticket/employee/{id}` : Show tickets by employee number

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
