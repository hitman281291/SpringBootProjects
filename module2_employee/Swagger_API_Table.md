# Swagger-Style API Table

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| GET | `/departments` | Get all departments | None | 200 OK |
| GET | `/departments/{id}` | Get department by ID | None | 200 (Found) / 404 (Not Found) |
| POST | `/departments` | Create new department | `{ "title": "...", "isActive": true }` | 201 Created |
| PUT | `/departments/{id}` | Update department | `{ "title": "...", "isActive": true }` | 200 OK / 404 Not Found |
| DELETE | `/departments/{id}` | Delete department | None | 204 No Content / 404 Not Found |
| GET | `/departments/check/{value}` | Check if number is prime (custom annotation) | None | 200 OK / 400 Bad Request |

## Example Request Bodies

### Create Department (POST)
```json
{
  "title": "HR",
  "isActive": true
}
```

### Update Department (PUT)
```json
{
  "title": "Finance",
  "isActive": false
}
```

## Error Response Example (404)
```json
{
  "timestamp": "2025-12-11T17:44:36.231Z",
  "status": 404,
  "error": "Not Found",
  "message": "Department with id 999 not found",
  "path": "/departments/999"
}
```

## Validation Error Example (400)
```json
{
  "timestamp": "2025-12-11T18:00:25.000Z",
  "status": 400,
  "error": "Bad Request",
  "message": ["title: must not be blank"],
  "path": "/departments"
}
```
