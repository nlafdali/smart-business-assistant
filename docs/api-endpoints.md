# Smart Business Assistant API

## Base URL

```http
http://localhost:8080/api/requests
```

---

# Endpoints

| Methode | URL | Beschreibung |
|----------|-----|--------------|
| GET | /api/requests | Alle Requests abrufen |
| GET | /api/requests/{id} | Einen Request nach ID abrufen |
| POST | /api/requests | Neuen Request erstellen |
| PUT | /api/requests/{id} | Request aktualisieren |
| DELETE | /api/requests/{id} | Request löschen |

---

# POST Beispiel

## Request

```json
{
  "text": "Mein Drucker funktioniert nicht",
  "category": "GENERAL",
  "priority": "HIGH"
}
```

## Response

```json
{
  "id": 1,
  "text": "Mein Drucker funktioniert nicht",
  "category": "GENERAL",
  "priority": "HIGH",
  "status": "OPEN"
}
```

---

# Fehlerbehandlung

## Validation Error

```json
{
  "message": "Text darf nicht leer sein",
  "status": 400
}
```

## Invalid Enum

```json
{
  "message": "Ungültige Category: IT",
  "status": 400
}
```