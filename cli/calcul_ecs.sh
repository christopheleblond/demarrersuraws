#!/bin/zsh

# Construire l'image docker en local
ng build --prod
docker build -t movies-front .

# Créer un dépot ECR

# Pousser l'image docker sur ECR

# Créer un cluster ECS

