#!/bin/bash

curl -kH @headers -d @bodycreatebanana -X POST http://localhost:8080/answer 
curl -kH @headers -d @bodycreatemelon -X POST http://localhost:8080/answer 
