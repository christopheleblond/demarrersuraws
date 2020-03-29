#!/bin/zsh

# Creer l'utilisateur pour le comptable
aws iam create-user --user-name "Robert"

# Set le password pour l'acces à la console
aws iam create-login-profile --user-name "Robert" --password "R@b3RT" --no-password-reset-required

# Créer le groupe "Comptables"
aws iam create-group --group-name "Comptables"

# Ajoute les roles nécessaires
aws iam attach-group-policy --group-name "Comptables" --policy-arn "arn:aws:iam::aws:policy/job-function/Billing"

# Ajoute Robert dans le groupe des comptables
aws iam add-user-to-group --user-name "Robert" --group-name "Comptables"

# Donne un accès en lecture seule à S3
aws iam attach-user-policy --user-name "Robert" --policy-arn "arn:aws:iam::aws:policy/AmazonS3ReadOnlyAccess"

# Supprimer l'utilisateur
#aws iam delete-user --user-name "Robert"

# Supprimer le groupe
#aws iam delete-group --group-name "Comptables"