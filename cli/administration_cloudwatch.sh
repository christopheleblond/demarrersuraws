#!/bin/zsh

# Créer topic SNS

# Créer une subscription 'Email' au topic

# Créer une alarme sur CPU > 80% pendant 10min
aws cloudwatch put-metric-alarm --alarm-name cpu-mon --alarm-description "Alarm when CPU exceeds 80 percent" --metric-name CPUUtilization --namespace AWS/EC2 --statistic Average --period 300 --threshold 80 --comparison-operator GreaterThanThreshold  --dimensions "Name=InstanceId,Value=i-12345678" --evaluation-periods 2 --alarm-actions arn:aws:sns:eu-west-3:588135555847:CPU_MON_TOPIC --unit Percent

# Supprime l'alarme
aws cloudwatch delete-alarms --alarm-names cpu-mon

