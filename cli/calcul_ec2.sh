#!/bin/zsh

# Lister les instances
aws ec2 describe-instances

# Créer une instance EC2 t2.micro AMI
aws ec2 run-instances --image-id ami-0fd9bce3a3384b635 --count 1 --instance-type t2.micro --key-name AWSKey --security-group-ids sg-3ee3a952 --subnet-id subnet-f71a538c

# Connexion SSH
ssh -i AWSKey.pem ec2-user@ec2-35-180-67-202.eu-west-3.compute.amazonaws.com

# Installer le serveur web
sudo yum update -y
sudo yum install httpd -y
sudo service httpd start

# Créer une page exemple
<!DOCTYPE html>
<html>
    <head>
        <title>Elastic Load Balancer Example</title>
    </head>
    <body style="background-color: black;">
        <img src="http://1.bp.blogspot.com/-afufk553ieU/Vg4UldQ3hpI/AAAAAAAACzA/DnvlGkaXL54/s1600/jedi.jpg" alt="lightside" />
    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <title>Elastic Load Balancer Example</title>
    </head>
    <body style="background-color: black;">
        <img width="100%" height="100%" src="https://img.playbuzz.com/image/upload/ar_1.5,c_pad,f_jpg,b_auto/q_auto:good,f_auto,fl_lossy,w_640,c_limit/cdn/74b156b6-9c2a-4ba8-8c65-ec92554fa82f/c119ad5a-bbe0-486d-b56b-61ce4e982034_560_420.jpg" alt="darkside" />
    </body>
</html>

# Load balancing

# Créer une image de l'instance


# Créer un launch template avec user-data

#!/bin/bash
sudo yum update -y
sudo yum install httpd -y
sudo amazon-linux-extras install epel -y
sudo yum install stress -y
sudo service httpd start

# Créer un AS

# Se connecter sur une instannce et stresser
sudo stress --cpu 1 --timeout 320

93v9LDvkXWWFaOpujPRl