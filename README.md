# spring-boot-rest

http://localhost:8080/swagger-ui.html

{
  "swagger": "2.0",
  "info": {
    "description": "\"Spring Boot REST API\"",
    "version": "1.0.0",
    "title": "Pokemon API"
  },
  "host": "localhost:8080",
  "basePath": "/",
  "tags": [
    {
      "name": "evolution-controller",
      "description": "Evolution Controller"
    },
    {
      "name": "main-controller",
      "description": "Main Controller"
    },
    {
      "name": "pokemon-controller",
      "description": "Pokemon Controller"
    },
    {
      "name": "trainer-controller",
      "description": "Trainer Controller"
    }
  ],
  "paths": {
    "/evolutions/all": {
      "get": {
        "tags": [
          "evolution-controller"
        ],
        "summary": "getAll",
        "operationId": "getAllUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "array",
              "items": {
                "type": "string"
              }
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/evolutions/evolve": {
      "post": {
        "tags": [
          "evolution-controller"
        ],
        "summary": "evolvePokemon",
        "operationId": "evolvePokemonUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "evolutionRequest",
            "description": "evolutionRequest",
            "required": true,
            "schema": {
              "$ref": "#/definitions/EvolutionRequest"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/main/capture": {
      "post": {
        "tags": [
          "main-controller"
        ],
        "summary": "capturePokemon",
        "operationId": "capturePokemonUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "captureRequest",
            "description": "captureRequest",
            "required": true,
            "schema": {
              "$ref": "#/definitions/CaptureRequest"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/pokemons/add": {
      "post": {
        "tags": [
          "pokemon-controller"
        ],
        "summary": "postPokemon",
        "operationId": "postPokemonUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "pokemon",
            "description": "pokemon",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Pokemon"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "integer",
              "format": "int32"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/pokemons/add/{id}": {
      "put": {
        "tags": [
          "pokemon-controller"
        ],
        "summary": "putPokemon",
        "operationId": "putPokemonUsingPUT",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          },
          {
            "in": "body",
            "name": "pokemon",
            "description": "pokemon",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Pokemon"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/pokemons/all": {
      "get": {
        "tags": [
          "pokemon-controller"
        ],
        "summary": "getAllPokemon",
        "operationId": "getAllPokemonUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object",
              "additionalProperties": {
                "$ref": "#/definitions/Pokemon"
              }
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/pokemons/delete/{id}": {
      "delete": {
        "tags": [
          "pokemon-controller"
        ],
        "summary": "deletePokemon",
        "operationId": "deletePokemonUsingDELETE",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "204": {
            "description": "No Content"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          }
        }
      }
    },
    "/pokemons/update/{id}": {
      "put": {
        "tags": [
          "pokemon-controller"
        ],
        "summary": "updatePokemon",
        "operationId": "updatePokemonUsingPUT",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          },
          {
            "in": "body",
            "name": "pokemon",
            "description": "pokemon",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Pokemon"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/pokemons/{id}": {
      "get": {
        "tags": [
          "pokemon-controller"
        ],
        "summary": "getPokemon",
        "operationId": "getPokemonUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/Pokemon"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/trainers/add": {
      "post": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "postTrainer",
        "operationId": "postTrainerUsingPOST",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "in": "body",
            "name": "trainer",
            "description": "trainer",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Trainer"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "integer",
              "format": "int32"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/trainers/add/{id}": {
      "put": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "putTrainer",
        "operationId": "putTrainerUsingPUT",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          },
          {
            "in": "body",
            "name": "trainer",
            "description": "trainer",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Trainer"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/trainers/all": {
      "get": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "getAllTrainers",
        "operationId": "getAllTrainersUsingGET",
        "produces": [
          "*/*"
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "object",
              "additionalProperties": {
                "$ref": "#/definitions/Trainer"
              }
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/trainers/delete/{id}": {
      "delete": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "deleteTrainer",
        "operationId": "deleteTrainerUsingDELETE",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "204": {
            "description": "No Content"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          }
        }
      }
    },
    "/trainers/update/{id}": {
      "put": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "updateTrainer",
        "operationId": "updateTrainerUsingPUT",
        "consumes": [
          "application/json"
        ],
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          },
          {
            "in": "body",
            "name": "trainer",
            "description": "trainer",
            "required": true,
            "schema": {
              "$ref": "#/definitions/Trainer"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "type": "string"
            }
          },
          "201": {
            "description": "Created"
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/trainers/{id}": {
      "get": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "getTrainer",
        "operationId": "getTrainerUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "id",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/Trainer"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    },
    "/trainers/{trainerId}/backpack/{backpackId}": {
      "get": {
        "tags": [
          "trainer-controller"
        ],
        "summary": "getCapturedPokemon",
        "operationId": "getCapturedPokemonUsingGET",
        "produces": [
          "*/*"
        ],
        "parameters": [
          {
            "name": "trainerId",
            "in": "path",
            "description": "trainerId",
            "required": true,
            "type": "integer",
            "format": "int32"
          },
          {
            "name": "backpackId",
            "in": "path",
            "description": "backpackId",
            "required": true,
            "type": "integer",
            "format": "int32"
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "schema": {
              "$ref": "#/definitions/CapturedPokemon"
            }
          },
          "401": {
            "description": "Unauthorized"
          },
          "403": {
            "description": "Forbidden"
          },
          "404": {
            "description": "Not Found"
          }
        }
      }
    }
  },
  "definitions": {
    "CaptureRequest": {
      "type": "object",
      "properties": {
        "nickname": {
          "type": "string",
          "description": "Nickname of the pokemon",
          "allowEmptyValue": false
        },
        "pokemonId": {
          "type": "integer",
          "format": "int32",
          "description": "Id of the pokemon",
          "allowEmptyValue": false
        },
        "trainerId": {
          "type": "integer",
          "format": "int32",
          "description": "Id of the trainer",
          "allowEmptyValue": false
        }
      },
      "title": "CaptureRequest"
    },
    "CapturedPokemon": {
      "type": "object",
      "properties": {
        "pokemonId": {
          "type": "integer",
          "format": "int32",
          "description": "Id of the pokemon",
          "allowEmptyValue": false
        },
        "pokemonLevel": {
          "type": "integer",
          "format": "int32",
          "description": "Level of the pokemon",
          "allowEmptyValue": false
        },
        "pokemonNickname": {
          "type": "string",
          "description": "Nickname of the pokemon",
          "allowEmptyValue": false
        }
      },
      "title": "CapturedPokemon"
    },
    "EvolutionRequest": {
      "type": "object",
      "properties": {
        "backpackId": {
          "type": "integer",
          "format": "int32",
          "description": "Position of pokemon in backpack",
          "allowEmptyValue": false
        },
        "trainerId": {
          "type": "integer",
          "format": "int32",
          "description": "Id of the trainer",
          "allowEmptyValue": false
        }
      },
      "title": "EvolutionRequest"
    },
    "Pokemon": {
      "type": "object",
      "properties": {
        "evolution": {
          "type": "integer",
          "format": "int32"
        },
        "name": {
          "type": "string",
          "description": "Name of the entity",
          "allowEmptyValue": false
        },
        "type": {
          "type": "string",
          "description": "Type of the pokemon",
          "allowEmptyValue": false
        }
      },
      "title": "Pokemon"
    },
    "Trainer": {
      "type": "object",
      "properties": {
        "name": {
          "type": "string",
          "description": "Name of the entity",
          "allowEmptyValue": false
        },
        "sex": {
          "type": "string",
          "description": "Sex of the trainer",
          "allowEmptyValue": false,
          "enum": [
            "MALE",
            "FEMALE"
          ]
        }
      },
      "title": "Trainer"
    }
  }
}
