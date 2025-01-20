# Internship Assignment

## Overview
This project implements an optimal transfer selection algorithm using dynamic programming. The program finds the most cost-effective combination of transfers while respecting a maximum weight constraint.

##Technologies Used
	•	Java: 17
	•	Maven: 4.0.0
	•	Spring Boot: 3.4.1

## API Documentation

### Calculate Optimal Transfers

**Endpoint:** `/api/calculate`
**Method:** GET
**Content-Type:** application/json

#### Request Body:
```json
{
  "maxWeight": 15,
  "transfers": [
    {
      "weight": 5,
      "cost": 10
    },
    {
      "weight": 10,
      "cost": 20
    },
    {
      "weight": 3,
      "cost": 5
    },
    {
      "weight": 8,
      "cost": 15
    }
  ]
}
```

#### Sample cURL:
```bash
curl -X GET 'http://localhost:8080/api/calculate' \
-H 'Content-Type: application/json' \
-H 'Accept: */*' \
-d '{
  "maxWeight": 15,
  "transfers": [
    {
      "weight": 5,
      "cost": 10
    },
    {
      "weight": 10,
      "cost": 20
    },
    {
      "weight": 3,
      "cost": 5
    },
    {
      "weight": 8,
      "cost": 15
    }
  ]
}'
```

## Building and Running

1. Clone the repository
2. Navigate to the project directory
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The server will start on `http://localhost:8080`

## Testing

Run the tests using:
```bash
mvn test
```

The test suite includes various scenarios:
- Valid inputs with different combinations
- Edge cases (empty transfers list, zero max weight)
- Cases where all transfers exceed max weight
- Exact weight match scenarios
- Large number scenarios
