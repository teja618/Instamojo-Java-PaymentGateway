# Instamojo-Java-PaymentGateway
This repo is used to serve payments with Instamojo Payment Gateway.

Create Payment API Endpoint: https://barclays-hackathon.herokuapp.com/payment/v1

Sample Request (All the fields are mandatory):

{
  "amount": [Amount],
  "description": "[Reason]",
  "email": "[Email]",
  "name": "[Name]",
  "phone": "[10 Digit Phone Num]"
}

Get Order Status by Transaction ID : https://barclays-hackathon.herokuapp.com/order/{TransactionID}

