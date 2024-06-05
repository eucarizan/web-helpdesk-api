# Web Help Desk Application
RESTful API for a Web Help Desk Application

## REST API 

### Auth

- [ ] `POST /api/register`: Register new employee
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

