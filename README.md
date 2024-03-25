# test-ekwateur

Demarer le serveur via la commande : ./mvnw spring-boot:run

Le programme contient 2 endpoints: 

```bash

POST /facture/particulier

POST /facture/professionnel

```

qui doivent prendre un json en body 

```json
{"refClient": "EKW12345678", "consommations": ["GAZ", "ELECTRICITE"], "kwh": 5.6, "ca": 100000000000.0}
```

pour recevoir la facture totale

```json
 {
    "refClient": "EKW12345678",
    "total": 1.2599999999999998
}
```
