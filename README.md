## About This Project

This is a simple project CRUD rest api using Spring with kotlin. 

## API Spec

### Create Note

Request :

- Method : POST
- URL : `/api/notes`
- Request Body :

```json
{
  "title": "test1",
  "content": "content test"
}
```

Response :

```json
{
  "data": {
    "id": "d61a4fa7-267a-410c-8165-ff17e2b2b160",
    "title": "test1",
    "content": "content test",
    "created_at": "2024-10-02T12:37:39.159742371Z",
    "updated_at": "2024-10-02T12:37:39.159750222Z"
  }
}
```

### Update Note

Request :

- Method : PUT
- URL : `/api/notes/{id}`
- Request Body :

```json
{
  "title": "test5",
  "content": "content test edited"
}
```
Response :

```json
{
  "data": {
    "id": "d61a4fa7-267a-410c-8165-ff17e2b2b160",
    "title": "test5",
    "content": "content test edited",
    "created_at": "2024-10-02T12:37:39.159742Z",
    "updated_at": "2024-10-02T12:38:43.216646432Z"
  }
}
```

### Get Note By Id

Request :

- Method : GET
- URL : `/api/notes/{id}`

Response :
```json
{
  "data": {
    "id": "d61a4fa7-267a-410c-8165-ff17e2b2b160",
    "title": "test5",
    "content": "content test edited",
    "created_at": "2024-10-02T12:37:39.159742Z",
    "updated_at": "2024-10-02T12:38:43.216646Z"
  }
}
```

### Get List Note

Request :

- Method : GET
- URL : `/api/notes?page=1&size=2`

Response : 
```json
{
  "data": [
    {
      "id": "6e67b5bd-0f0c-48cb-a4c4-c678090c30a4",
      "title": "test2",
      "content": "content test",
      "created_at": "2024-10-02T12:03:56.041105Z",
      "updated_at": "2024-10-02T12:03:56.041108Z"
    },
    {
      "id": "87893fe9-a804-41b3-9be0-ba0e98d0d0a6",
      "title": "test3",
      "content": "content test",
      "created_at": "2024-10-02T12:04:01.684945Z",
      "updated_at": "2024-10-02T12:04:01.684946Z"
    }
  ],
  "pagination": {
    "page": 1,
    "size": 2,
    "total_item": 5,
    "total_page": 3
  }
}
```

### Delete Note By Id

Request :

- Method : DELETE
- URL : `/api/notes/{id}`

Response : 
```json
{
  "data": "note deleted"
}
```

### Error Response

Response :
```json
{
  "errors": "error message"
}
```

## Install

```
git clone https://github.com/Ikhlashmulya/spring-kotlin-note-api.git
```
```
./gradlew bootRun
```